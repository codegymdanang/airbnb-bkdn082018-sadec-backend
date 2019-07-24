package service;

import entity.NgoiNhaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NgoiNhaService {
    Page<NgoiNhaEntity> findAll(Pageable pageable);

    NgoiNhaEntity findById(Long id);

    void save(NgoiNhaEntity ngoiNhaEntity);

    void remove(Long id);
}
