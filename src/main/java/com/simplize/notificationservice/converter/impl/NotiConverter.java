package com.simplize.notificationservice.converter.impl;

import org.springframework.stereotype.Component;

import com.simplize.notificationservice.converter.INotiConverter;
import com.simplize.notificationservice.dto.NotiCreate;
import com.simplize.notificationservice.dto.NotiDto;
import com.simplize.notificationservice.dto.NotiUpdate;
import com.simplize.notificationservice.model.Noti;

@Component
public class NotiConverter implements INotiConverter {

    @Override
    public NotiDto convert(Noti noti, NotiDto notiDto) {
        notiDto.setId(noti.getId());
        notiDto.setTitle(noti.getTitle());
        notiDto.setContent(noti.getContent());
        notiDto.setNotiType(noti.getNotiType());
        notiDto.setNotiGroup(noti.getNotiGroup());
        return notiDto;
    }

    @Override
    public Noti convert(NotiCreate create, Noti noti) {
        noti.setTitle(create.getTitle());
        noti.setContent(create.getContent());
        noti.setNotiType(create.getNotiType());
        noti.setNotiGroup(create.getNotiGroup());
        return noti;
    }

    @Override
    public Noti convert(NotiUpdate update, Noti noti) {
        if (update.getTitle() != null) {
            noti.setTitle(update.getTitle());
        }
        ;
        if (update.getContent() != null) {
            noti.setContent(update.getContent());
        }
        ;
        if (update.getNotiType() != null) {
            noti.setNotiType(update.getNotiType());
        }
        ;
        if (update.getNotiGroup() != null) {
            noti.setNotiGroup(update.getNotiGroup());
        }
        ;
        return noti;
    }

}
