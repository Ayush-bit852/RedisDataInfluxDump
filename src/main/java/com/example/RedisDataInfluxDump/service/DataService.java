package com.example.RedisDataInfluxDump.service;

import org.influxdb.InfluxDB;
import org.influxdb.dto.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class DataService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private InfluxDB influxDB;

    public void fetchDataFromRedisAndStoreInInflux() {
        String redisKey = "sensor:temperature"; // Example Redis Key
        String value = redisTemplate.opsForValue().get(redisKey);

        if (value != null) {
            influxDB.write(Point.measurement("temperature_data")
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .addField("value", Double.parseDouble(value))
                    .build());
            System.out.println("Data stored in InfluxDB: " + value);
        } else {
            System.out.println("No data found in Redis.");
        }
    }
}
