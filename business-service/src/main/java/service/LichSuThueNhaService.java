package service;

import entity.LichSuThueNhaEntity;

import java.util.List;

public interface LichSuThueNhaService {
    List<LichSuThueNhaEntity> findAll();

    LichSuThueNhaEntity findById(Long id);

    void save(LichSuThueNhaEntity lichSuThueNhaEntity);

    void remove(Long id);
}
