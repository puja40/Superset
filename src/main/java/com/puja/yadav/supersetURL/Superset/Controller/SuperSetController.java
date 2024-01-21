package com.puja.yadav.supersetURL.Superset.Controller;

import com.puja.yadav.supersetURL.Superset.Service.Report;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/superset")
public class SuperSetController {

    private static final Logger logger = LoggerFactory.getLogger(SuperSetController.class);

    @Autowired
    @Lazy
    Report service;

    @GetMapping
    public ResponseEntity<String> getSupersetURL() {
        try {
            String supersetURL = service.getSuperSetURL();

            if (supersetURL == null || supersetURL.isEmpty()) {
                return new ResponseEntity<>("Superset URL not found", HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(supersetURL, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception
            logger.error("Error getting superset URL: {}", e.getMessage(), e);

            // Return a ResponseEntity with a generic error message and status code
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
