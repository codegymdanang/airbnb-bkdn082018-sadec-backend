package service;

import entity.HinhAnhNhaEntity;

import java.util.List;

public interface HinhAnhNhaService {
    List<HinhAnhNhaEntity> findAll();

    HinhAnhNhaEntity findById(Long id);

    HinhAnhNhaEntity save(HinhAnhNhaEntity hinhAnhNhaEntity);

    void remove(Long id);
}
