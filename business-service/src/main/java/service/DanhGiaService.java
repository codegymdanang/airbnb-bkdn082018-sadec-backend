package service;

import entity.DanhGiaEntity;

import java.util.List;

public interface DanhGiaService {
    List<DanhGiaEntity> findAll();

    DanhGiaEntity findById(Long id);

    DanhGiaEntity save(DanhGiaEntity danhGiaEntity);

    void remove(Long id);
}
