package com.ll.medium_mission_shimkyudae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MediumMissionShimKyuDaeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediumMissionShimKyuDaeApplication.class, args);
    }

}
