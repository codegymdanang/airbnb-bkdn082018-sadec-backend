package jpaRepository;

import entity.ThuNhapThangEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThuNhapThangRepository extends PagingAndSortingRepository<ThuNhapThangEntity, Long> {
//    Page<ThuNhapThangEntity> findTopByThuNhap();
//
//    Page<ThuNhapThangEntity> findAllByThoiGian(Date thoiGian);
}
