package repository;

import entity.LichSuThueNhaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LichSuThueNhaRepository extends PagingAndSortingRepository<LichSuThueNhaEntity, Long> {
//    Page<LichSuThueNhaRepository> findAllByTongChiPhi(float tongChiPhi);
//
//    Page<LichSuThueNhaRepository> findAllByTongNgayThue(int soNgayThue);
}
