package service;

import entity.ThuNhapThangEntity;

import java.util.List;

public interface ThuNhapThangSerVice {
    List<ThuNhapThangEntity> findAll();

    ThuNhapThangEntity findById(Long id);

    ThuNhapThangEntity save(ThuNhapThangEntity thuNhapThangEntity);

    void remove(Long id);
}
