package service;

import entity.NguoiDungEntity;

import java.util.List;

public interface NguoiDungService {
    List<NguoiDungEntity> findAll();

    NguoiDungEntity findByTenNguoiDung(String tenNguoiDung);

    NguoiDungEntity findById(Long id);

    void save(NguoiDungEntity nguoiDungEntity);

    void remove(Long id);
}
