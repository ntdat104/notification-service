package com.simplize.notificationservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplize.notificationservice.dto.NotiCreate;
import com.simplize.notificationservice.dto.NotiUpdate;
import com.simplize.notificationservice.model.Response;
import com.simplize.notificationservice.service.impl.NotiService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/api/notification/v1/noti")
public class NotiController {

    private final NotiService notiService;

    public NotiController(NotiService notiService) {
        this.notiService = notiService;
    }

    @GetMapping()
    public Response<?> findAll() {
        return notiService.findAll();
    }

    @GetMapping("{id}")
    public Response<?> findById(@PathVariable("id") String id) {
        return notiService.findById(id);
    }

    @PostMapping()
    public Response<?> create(@RequestBody NotiCreate create) {
        return notiService.create(create);
    }

    @PutMapping("{id}")
    public Response<?> update(@PathVariable("id") String id, @RequestBody NotiUpdate update) {
        return notiService.update(id, update);
    }

    @DeleteMapping("{id}")
    public Response<?> delete(@PathVariable("id") String id) {
        return notiService.delete(id);
    }

}
