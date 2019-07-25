package repository;

import entity.NgoiNhaEntity;
import entity.NguoiDungEntity;
import entity.NhanXetVaPhanHoiEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanXetVaPhanHoiRepository extends PagingAndSortingRepository<NhanXetVaPhanHoiEntity, Long> {
//    Page<NhanXetVaPhanHoiRepository> findAllByNguoiDung(NguoiDungEntity nguoiDungEntity);
//
//    Page<NhanXetVaPhanHoiRepository> findAllByNgoiNha(NgoiNhaEntity ngoiNhaEntity);
}
