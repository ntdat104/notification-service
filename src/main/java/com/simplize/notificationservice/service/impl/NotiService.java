package com.simplize.notificationservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.simplize.notificationservice.converter.impl.NotiConverter;
import com.simplize.notificationservice.dto.NotiCreate;
import com.simplize.notificationservice.dto.NotiDto;
import com.simplize.notificationservice.dto.NotiUpdate;
import com.simplize.notificationservice.model.Noti;
import com.simplize.notificationservice.model.Response;
import com.simplize.notificationservice.repository.NotiRep;
import com.simplize.notificationservice.service.INotiService;

@Service
public class NotiService implements INotiService {

    private final NotiRep notiRep;
    private final NotiConverter notiConverter;

    public NotiService(NotiRep notiRep, NotiConverter notiConverter) {
        this.notiRep = notiRep;
        this.notiConverter = notiConverter;
    }

    @Override
    public Response<?> create(NotiCreate create) {
        Noti noti = notiConverter.convert(create, new Noti());

        try {
            Noti notiSaved = notiRep.save(noti);
            return Response.success(notiConverter.convert(notiSaved, new NotiDto()));
        } catch (Exception e) {
            return Response.fail("Có lỗi xảy ra!");
        }
    }

    @Override
    public Response<?> delete(String id) {
        Noti noti = notiRep.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy dữ liệu!"));

        try {
            notiRep.delete(noti);
            return Response.success(notiConverter.convert(noti, new NotiDto()));
        } catch (Exception e) {
            return Response.fail("Có lỗi xảy ra!");
        }
    }

    @Override
    public Response<List<NotiDto>> findAll() {
        List<Noti> notis = notiRep.findAll();

        List<NotiDto> collections = notis.stream().map((c) -> notiConverter.convert(c, new NotiDto()))
                .collect(Collectors.toList());

        return Response.success(collections);
    }

    @Override
    public Response<?> findById(String id) {
        Noti noti = notiRep.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy dữ liệu!"));

        return Response.success(notiConverter.convert(noti, new NotiDto()));
    }

    @Override
    public Response<?> update(String id, NotiUpdate update) {
        Noti noti = notiRep.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy dữ liệu!"));

        try {
            Noti notiConverted = notiConverter.convert(update, noti);
            Noti notiSaved = notiRep.save(notiConverted);
            return Response.success(notiConverter.convert(notiSaved, new NotiDto()));
        } catch (Exception e) {
            return Response.fail("Có lỗi xảy ra!");
        }
    }

}
