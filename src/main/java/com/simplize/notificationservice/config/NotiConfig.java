package com.simplize.notificationservice.config;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.simplize.notificationservice.model.Noti;
import com.simplize.notificationservice.repository.NotiRep;

@Configuration
public class NotiConfig {

    @Bean
    CommandLineRunner commandLineRunner(NotiRep notiRep) {
        return args -> {
            List<Noti> notis = new ArrayList<Noti>();

            IntStream.range(0, 5).forEach(
                    (c) -> notis.add(new Noti("Tiêu đề " + c, "Nội dung " + c, "noti_type_" + c, "noti_group_" + c)));

            notiRep.saveAll(notis);
        };
    }
}
