package service;

import entity.NhanXetVaPhanHoiEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NhanXetVaPhanHoiService {
    Page<NhanXetVaPhanHoiEntity> findAll(Pageable pageable);

    NhanXetVaPhanHoiEntity findById(Long id);

    void save(NhanXetVaPhanHoiEntity nhanXetVaPhanHoiEntity);

    void remove(Long id);
}
