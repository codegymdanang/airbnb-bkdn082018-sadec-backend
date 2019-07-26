package service;

import entity.LichSuThueNhaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LichSuThueNhaService {
    Page<LichSuThueNhaEntity> findAll(Pageable pageable);

    LichSuThueNhaEntity findById(Long id);

    void save(LichSuThueNhaEntity lichSuThueNhaEntity);

    void remove(Long id);
}
