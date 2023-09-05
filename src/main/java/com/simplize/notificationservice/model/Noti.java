package com.simplize.notificationservice.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "noti")
public class Noti extends BaseEntity {

    @Field(name = "title")
    private String title;

    @Field(name = "content")
    private String content;

    @Field(name = "noti_type")
    private String notiType;

    @Field(name = "noti_group")
    private String notiGroup;
}
