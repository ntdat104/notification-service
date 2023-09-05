package com.simplize.notificationservice.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class NotiDto implements Serializable {
    private String id;

    private String title;

    private String content;

    private String notiType;

    private String notiGroup;
}
