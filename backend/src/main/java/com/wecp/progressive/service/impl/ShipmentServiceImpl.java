package com.wecp.progressive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Shipment;
import com.wecp.progressive.repository.ShipmentRepository;
import com.wecp.progressive.service.ShipmentService;

@Service
public class ShipmentServiceImpl implements ShipmentService  {

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Override
    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    @Override
    public Shipment getShipmentById(int shipmentId) {
        return shipmentRepository.findByShipmentId(shipmentId);
    }

    @Override
    public int addShipment(Shipment shipment) {
        return shipmentRepository.save(shipment).getShipmentId();
    }

    @Override
    public void updateShipment(Shipment shipment) {
        shipmentRepository.save(shipment);
    }

    @Override
    public void deleteShipment(int shipmentId) {
        shipmentRepository.deleteById(shipmentId);
    }

}