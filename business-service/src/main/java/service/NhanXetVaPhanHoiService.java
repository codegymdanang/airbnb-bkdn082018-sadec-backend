package service;

import entity.NhanXetVaPhanHoiEntity;

import java.util.List;

public interface NhanXetVaPhanHoiService {
    List<NhanXetVaPhanHoiEntity> findAll();

    NhanXetVaPhanHoiEntity findById(Long id);

    NhanXetVaPhanHoiEntity save(NhanXetVaPhanHoiEntity nhanXetVaPhanHoiEntity);

    void remove(Long id);
}
