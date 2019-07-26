package service;

import entity.DanhGiaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DanhGiaService {
    Page<DanhGiaEntity> findAll(Pageable pageable);

    DanhGiaEntity findById(Long id);

    void save(DanhGiaEntity danhGiaEntity);

    void remove(Long id);
}
