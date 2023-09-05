package com.simplize.notificationservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.simplize.notificationservice.model.Noti;

@Repository
public interface NotiRep extends MongoRepository<Noti, String> {
    
}
