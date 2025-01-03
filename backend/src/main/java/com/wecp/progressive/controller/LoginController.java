package com.wecp.progressive.controller;

import com.wecp.progressive.dto.LoginRequest;
import com.wecp.progressive.entity.Supplier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    public ResponseEntity<Supplier> registerUser(Supplier user) {
        return null;
    }

    public ResponseEntity loginUser(LoginRequest loginRequest) {
        return null;
    }
}
