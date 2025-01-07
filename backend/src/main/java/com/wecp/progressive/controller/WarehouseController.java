package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Warehouse;
import com.wecp.progressive.exception.NoWarehouseFoundForSupplierException;
import com.wecp.progressive.service.impl.WarehouseServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired 
    WarehouseServiceImplJpa warehouseServiceImplJpa;

    @GetMapping
    public ResponseEntity<List<Warehouse>> getAllWarehouses() throws SQLException{
        try {
            return new ResponseEntity<>(warehouseServiceImplJpa.getAllWarehouses(),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{warehouseId}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable int warehouseId)throws SQLException {
        try {
            return new ResponseEntity<>(warehouseServiceImplJpa.getWarehouseById(warehouseId),HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping
    public ResponseEntity<Integer> addWarehouse(@RequestBody Warehouse warehouse)throws SQLException {
        try {
            return new ResponseEntity<>(warehouseServiceImplJpa.addWarehouse(warehouse),HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/{warehouseId}")
    public ResponseEntity<Void> updateWarehouse(@PathVariable int warehouseId,@RequestBody Warehouse warehouse)throws SQLException {
        try {
            Warehouse w = warehouseServiceImplJpa.getWarehouseById(warehouseId);
            if(w == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            warehouse.setWarehouseId(w.getWarehouseId());
            warehouseServiceImplJpa.updateWarehouse(warehouse);

            return  new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{warehouseId}")
    public ResponseEntity<?> deleteWarehouse(@PathVariable int warehouseId) throws SQLException {
        try {
            warehouseServiceImplJpa.deleteWarehouse(warehouseId);
            return new ResponseEntity<>("WareHouse with given Id deleted Succesfully.",HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<List<Warehouse>> getWarehousesBySupplier(  @PathVariable int supplierId)throws SQLException {
        try {
            return new ResponseEntity<>(warehouseServiceImplJpa.getWarehouseBySupplier(supplierId),HttpStatus.OK);
        } catch (NoWarehouseFoundForSupplierException e) {
            // TODO: handle exception
            // e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
