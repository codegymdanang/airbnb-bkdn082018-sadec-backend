package service;

import entity.ThongBaoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ThongBaoService {
    Page<ThongBaoEntity> findAll(Pageable pageable);

    ThongBaoEntity findById(Long id);

    void save(ThongBaoEntity thongBaoEntity);

    void remove(long id);
}
