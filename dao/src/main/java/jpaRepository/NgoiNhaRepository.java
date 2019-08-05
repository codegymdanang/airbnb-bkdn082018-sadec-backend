package jpaRepository;

import entity.NgoiNhaEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NgoiNhaRepository extends PagingAndSortingRepository<NgoiNhaEntity, Long> {
    NgoiNhaEntity save(NgoiNhaEntity nhaEntity);
}
