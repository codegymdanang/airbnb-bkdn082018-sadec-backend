package service;

import entity.ThongBaoEntity;

import java.util.List;

public interface ThongBaoService {
    List<ThongBaoEntity> findAll();

    ThongBaoEntity findById(Long id);

    ThongBaoEntity save(ThongBaoEntity thongBaoEntity);

    void remove(long id);
}
