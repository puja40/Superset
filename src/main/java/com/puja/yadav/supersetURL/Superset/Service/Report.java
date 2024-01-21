package com.puja.yadav.supersetURL.Superset.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Report {

    @Autowired
    Tool service;

    public String getSuperSetURL() {
        return service.getUri();
    }
}


