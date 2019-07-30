package jpaRepository;

import entity.NhanXetVaPhanHoiEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanXetVaPhanHoiRepository extends PagingAndSortingRepository<NhanXetVaPhanHoiEntity, Long> {
//    Page<NhanXetVaPhanHoiRepository> findAllByNguoiDung(NguoiDungEntity nguoiDungEntity);
//
//    Page<NhanXetVaPhanHoiRepository> findAllByNgoiNha(NgoiNhaEntity ngoiNhaEntity);
}
