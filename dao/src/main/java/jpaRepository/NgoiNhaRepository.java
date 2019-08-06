package jpaRepository;

import entity.NgoiNhaEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NgoiNhaRepository extends PagingAndSortingRepository<NgoiNhaEntity, Long> {
    NgoiNhaEntity save(NgoiNhaEntity nhaEntity);

    List<NgoiNhaEntity> findAllBySoPhongNgu(int soPhongNgu);

    List<NgoiNhaEntity> findAllBySoPhongTam(int sophongTam);

    List<NgoiNhaEntity> findAllByDiaChi(String diaChi);

    List<NgoiNhaEntity> findAllByGiaTienTheoDemBetween(float min, float max);
}
