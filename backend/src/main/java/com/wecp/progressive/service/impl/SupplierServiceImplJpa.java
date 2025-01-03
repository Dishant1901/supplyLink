package com.wecp.progressive.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.dao.SupplierDAO;
import com.wecp.progressive.entity.Supplier;
import com.wecp.progressive.repository.SupplierRepository;
import com.wecp.progressive.service.SupplierService;
 
@Service
public class SupplierServiceImplJpa implements SupplierService  {

    private SupplierDAO supplierDAO;

    @Autowired
    SupplierRepository supplierRepository;

    public SupplierServiceImplJpa(SupplierDAO supplierDAO) {
        this.supplierDAO = supplierDAO;
    }
   
    @Override
    public List<Supplier> getAllSuppliers() {
       return  supplierRepository.findAll();
    }

    @Override
    public int addSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
        return supplier.getSupplierId();
    }

    @Override
    public List<Supplier> getAllSuppliersSortedByName() {
        List<Supplier> supp = supplierRepository.findAll();
        Collections.sort(supp);
        return supp; 
    }

}