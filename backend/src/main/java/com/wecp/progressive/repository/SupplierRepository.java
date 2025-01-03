package com.wecp.progressive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wecp.progressive.entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository <Supplier, Integer> {
}
