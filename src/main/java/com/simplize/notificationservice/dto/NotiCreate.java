package com.simplize.notificationservice.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class NotiCreate implements Serializable {
    private String title;

    private String content;

    private String notiType;

    private String notiGroup;
}
