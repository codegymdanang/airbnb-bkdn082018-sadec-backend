package service;

import entity.HinhAnhNhaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HinhAnhNhaService {
    Page<HinhAnhNhaEntity> findAll(Pageable pageable);

    HinhAnhNhaEntity findById(Long id);

    void save(HinhAnhNhaEntity hinhAnhNhaEntity);

    void remove(Long id);
}
