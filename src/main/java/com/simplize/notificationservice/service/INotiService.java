package com.simplize.notificationservice.service;

import com.simplize.notificationservice.dto.NotiCreate;
import com.simplize.notificationservice.dto.NotiUpdate;
import com.simplize.notificationservice.model.Response;

public interface INotiService {
    Response<?> findAll();

    Response<?> findById(String id);

    Response<?> create(NotiCreate create);

    Response<?> update(String id, NotiUpdate update);

    Response<?> delete(String id);
}
