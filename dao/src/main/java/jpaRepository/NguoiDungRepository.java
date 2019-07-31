package jpaRepository;

import entity.NguoiDungEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguoiDungRepository extends CrudRepository<NguoiDungEntity, Long> {
    NguoiDungEntity findByTenNguoiDung(String tenNguoiDung);
}
