package com.metal.assignment.controller;

import com.metal.assignment.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PriceController {

    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/price")
    public ResponseEntity<Map<String, String>> getPrice() {
        System.out.println("GET METHOD OF PRICE");
        try {
            final String url = "https://www.metal.com/Lithium-ion-Battery/202303240001";
            String price = priceService.getPrice(url);
            Map<String, String> response = new HashMap<>();
            response.put("price", price);

            return ResponseEntity.ok(response);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("error", "Failed to retrieve price"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("error", "Check the url entered"));
        }

    }

}
