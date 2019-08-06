package elasticsearchRepository;

import entity.NgoiNhaEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NgoiNhaESRepository extends ElasticsearchRepository<NgoiNhaEntity, Long> {

}
