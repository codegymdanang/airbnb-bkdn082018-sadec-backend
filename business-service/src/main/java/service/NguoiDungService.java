package service;

import entity.NguoiDungEntity;

import java.util.List;

public interface NguoiDungService {
    List<NguoiDungEntity> findAll();

    NguoiDungEntity findByTenNguoiDung(String tenNguoiDung);

    NguoiDungEntity findById(Long id);

    NguoiDungEntity save(NguoiDungEntity nguoiDungEntity);

    void remove(Long id);
}
