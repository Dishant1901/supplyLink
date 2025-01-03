package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Supplier;
import com.wecp.progressive.service.impl.SupplierServiceImplArraylist;
import com.wecp.progressive.service.impl.SupplierServiceImplJpa;

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

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierServiceImplArraylist supplierServiceImplArraylist;

    @Autowired
    SupplierServiceImplJpa supplierServiceImplJpa;

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return null;
    }


    @GetMapping("/{supplierId}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable int supplierId) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Integer> addSupplier(@RequestBody Supplier supplier) {
        return null;
    }


    @PutMapping("/{supplierId}")
    public ResponseEntity<Void> updateSupplier( @RequestBody  Supplier supplier) {
        return null;
    }


    @DeleteMapping("/{supplierId}")
    public ResponseEntity<Void> deleteSupplier(int supplierId) {
        return null;
    }


    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Supplier>> getAllSuppliersFromArrayList() {
        List<Supplier> sup = supplierServiceImplArraylist.getAllSuppliers();
        return new ResponseEntity<>(sup,HttpStatus.OK);
    }


    @PostMapping("/toArrayList")
    public ResponseEntity<Integer> addSupplierToArrayList(@RequestBody Supplier supplier) {
        int size = supplierServiceImplArraylist.addSupplier(supplier);

        return new ResponseEntity<>(size,HttpStatus.CREATED);
    }


    @GetMapping("/fromArrayList/all")
    public ResponseEntity<List<Supplier>> getAllSuppliersSortedByNameFromArrayList() {
        List<Supplier> s = supplierServiceImplArraylist.getAllSuppliersSortedByName();
        return new ResponseEntity<> (s,HttpStatus.OK);
    }
}