package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Insurance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InsuranceController {
    public ResponseEntity<List<Insurance>> getAllInsurances() {
        return null;
    }

    public ResponseEntity<Insurance> getInsuranceById(int insuranceId) {
        return null;
    }

    public ResponseEntity<Integer> createInsurance(Insurance insurance) {
        return null;
    }

    public ResponseEntity<Void> updateInsurance(int insuranceId, Insurance insurance) {
        return null;
    }

    public ResponseEntity<Void> deleteInsurance(int insuranceId) {
        return null;
    }
}
