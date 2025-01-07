package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.wecp.progressive.dao.ProductDAO;
import com.wecp.progressive.entity.Product;
import com.wecp.progressive.exception.InsufficientCapacityException;
import com.wecp.progressive.repository.ProductRepository;
import com.wecp.progressive.service.ProductService;

@Service
public class ProductServiceImplJpa implements ProductService  {

    private ProductRepository productRepository;

    public ProductServiceImplJpa (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
   
    @Override
    public List<Product> getAllProducts() throws SQLException{
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int productId)throws SQLException {
        return productRepository.findById(productId).get();
    }

    @Override
    public int addProduct(Product product)throws SQLException {
        // return productRepository.save(product).getProductId();
        if(product.getWarehouse().getCapacity() < 1 ) throw new InsufficientCapacityException("Insufficient Capacity");
    
        return productRepository.save(product).getProductId();
    }

    @Override
    @Transactional
    public void updateProduct(Product product)throws SQLException {
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteProduct(int productId)throws SQLException {
        productRepository.deleteById(productId);
        
    }

    public List<Product> getAllProductByWarehouse(int warehouseId)throws SQLException {
        return productRepository.findAllByWarehouse_WarehouseId(warehouseId);
    }

}