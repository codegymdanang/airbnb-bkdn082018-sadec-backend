package service;

import entity.ThuNhapThangEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ThuNhapThangSerVice {
    Page<ThuNhapThangEntity> findAll(Pageable pageable);

    ThuNhapThangEntity findById(Long id);

    void save(ThuNhapThangEntity thuNhapThangEntity);

    void remove(Long id);
}
