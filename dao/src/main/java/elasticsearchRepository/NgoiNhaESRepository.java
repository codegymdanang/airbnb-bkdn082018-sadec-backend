package elasticsearchRepository;

import entity.NgoiNhaEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NgoiNhaESRepository extends ElasticsearchRepository<NgoiNhaEntity, Long> {

    List<NgoiNhaEntity> findBySoPhongNgu(int soPhongNgu);

    List<NgoiNhaEntity> findBySoPhongTam(int sophongTam);

    List<NgoiNhaEntity> findByDiaChi(String diaChi);

    List<NgoiNhaEntity> findByGiaTienTheoDemBetween(float min, float max);
}
