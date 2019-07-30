package jpaRepository;

import entity.ThongBaoEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThongBaoRepository extends PagingAndSortingRepository<ThongBaoEntity, Long> {

}
