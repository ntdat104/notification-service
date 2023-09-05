package com.simplize.notificationservice.converter;

import com.simplize.notificationservice.dto.NotiCreate;
import com.simplize.notificationservice.dto.NotiDto;
import com.simplize.notificationservice.dto.NotiUpdate;
import com.simplize.notificationservice.model.Noti;

public interface INotiConverter {
    NotiDto convert(Noti noti, NotiDto notiDto);

    Noti convert(NotiCreate create, Noti noti);

    Noti convert(NotiUpdate update, Noti noti);
}
