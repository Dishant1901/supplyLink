package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Shipment;
import com.wecp.progressive.repository.ShipmentRepository;
import com.wecp.progressive.service.impl.ShipmentServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    @Autowired
    private ShipmentServiceImpl shipmentServiceImpl;

    @GetMapping
    public ResponseEntity<List<Shipment>> getAllShipments() throws SQLException {
        try {
            return new ResponseEntity<>(shipmentServiceImpl.getAllShipments(),HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }



    @GetMapping("/{shipmentID}")
    public ResponseEntity<Shipment> getShipmentById(int shipmentId) throws SQLException{
        try {
            // return new ResponseEntity<>(shipmentRepository.findById(shipmentId),HttpStatus.OK); 
            Shipment ship = shipmentServiceImpl.getShipmentById(shipmentId);
            if(ship == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            return new ResponseEntity<>(ship,HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @PostMapping
    public ResponseEntity<Integer> addShipment(Shipment shipment) throws SQLException{
        try {
            return new ResponseEntity<>(shipmentServiceImpl.addShipment(shipment),HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/{shipmentID}")
    public ResponseEntity<Void> updateShipment(int shipmentId, Shipment shipment)throws SQLException {
        try {
            // return new ResponseEntity<>(shipmentRepository.save())
            Shipment ship = shipmentServiceImpl.getShipmentById(shipmentId);
            if(ship == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            // return new ResponseEntity<>(shipmentServiceImpl.updateShipment(shipment),HttpStatus.NOT_FOUND);
            shipmentServiceImpl.updateShipment(shipment);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{shipmentID}")
    public ResponseEntity<Void> deleteShipment(int shipmentId)throws SQLException {
        try {
            shipmentServiceImpl.deleteShipment(shipmentId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
