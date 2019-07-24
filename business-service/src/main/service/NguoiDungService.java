package service;

import entity.NguoiDungEntity;

public interface NguoiDungService {
    Iterable<NguoiDungEntity> findAll();

    NguoiDungEntity findById(Long id);

    void save(NguoiDungEntity nguoiDungEntity);

    void remove(Long id);
}
