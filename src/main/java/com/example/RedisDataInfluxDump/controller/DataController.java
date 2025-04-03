package com.example.RedisDataInfluxDump.controller;

import com.example.RedisDataInfluxDump.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @GetMapping("/transfer")
    public String transferData() {
        dataService.fetchDataFromRedisAndStoreInInflux();
        return "Data transfer from Redis to InfluxDB completed!";
    }
}
