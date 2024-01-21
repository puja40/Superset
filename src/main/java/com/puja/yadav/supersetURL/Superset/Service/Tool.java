package com.puja.yadav.supersetURL.Superset.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class Tool {

    @Autowired
    Environment env;

    public String getUri()
    {
        return env.getProperty("superset.baseurl");
    }
}
