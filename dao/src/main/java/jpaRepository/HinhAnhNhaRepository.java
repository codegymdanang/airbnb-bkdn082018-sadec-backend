package jpaRepository;

import entity.HinhAnhNhaEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HinhAnhNhaRepository extends PagingAndSortingRepository<HinhAnhNhaEntity, Long> {
}
