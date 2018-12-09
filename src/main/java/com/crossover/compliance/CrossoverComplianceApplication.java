package com.crossover.compliance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CrossoverComplianceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrossoverComplianceApplication.class, args);
    }
}
