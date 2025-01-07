package com.wecp.progressive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wecp.progressive.entity.Shipment;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment,Integer> {

Shipment findByShipmentId(int shipmentId);

@Modifying
@Transactional
@Query("delete from Shipment s where s.warehouse.warehouseId = :warehouseId")
void deleteByWarehouseId(int warehouseId);

@Modifying
@Transactional
@Query("delete from Shipment s where s.product.productId = :productId")
void deleteByProductId(int productId);

@Modifying
@Transactional
@Query("delete from Shipment s where s.warehouse.supplier.supplierId = :supplierId")
void deleteBySupplierId(int supplierId);


}
