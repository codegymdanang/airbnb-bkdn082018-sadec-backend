package service;

import entity.DanhGiaEntity;

import java.util.List;

public interface DanhGiaService {
    List<DanhGiaEntity> findAll();

    DanhGiaEntity findById(Long id);

    void save(DanhGiaEntity danhGiaEntity);

    void remove(Long id);
}
