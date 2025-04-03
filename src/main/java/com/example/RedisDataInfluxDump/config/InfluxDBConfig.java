package com.example.RedisDataInfluxDump.config;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfluxDBConfig {

    private static final String INFLUX_DB_URL = "http://localhost:8086";
    private static final String INFLUX_DB_NAME = "mydb";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    @Bean
    public InfluxDB influxDB() {
        InfluxDB influxDB = InfluxDBFactory.connect(INFLUX_DB_URL, USERNAME, PASSWORD);
        influxDB.setDatabase(INFLUX_DB_NAME);
        return influxDB;
    }
}
