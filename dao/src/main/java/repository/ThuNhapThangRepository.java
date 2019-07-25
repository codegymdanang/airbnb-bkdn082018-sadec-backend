package repository;

import entity.ThuNhapThangEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ThuNhapThangRepository extends PagingAndSortingRepository<ThuNhapThangEntity, Long> {
//    Page<ThuNhapThangEntity> findTopByThuNhap();
//
//    Page<ThuNhapThangEntity> findAllByThoiGian(Date thoiGian);
}
