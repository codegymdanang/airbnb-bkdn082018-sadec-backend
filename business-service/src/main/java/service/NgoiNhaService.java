package service;

import entity.NgoiNhaEntity;

import java.util.List;

public interface NgoiNhaService {
    List<NgoiNhaEntity> findAll();

    NgoiNhaEntity findById(long id);

    NgoiNhaEntity save(NgoiNhaEntity ngoiNhaEntity);

    void remove(Long id);

    List<NgoiNhaEntity> findBySoPhongNgu(int soPhongNgu);

    List<NgoiNhaEntity> findBySoPhongTam(int soPhongTam);

    List<NgoiNhaEntity> findByDiaChi(String diaChi);

    List<NgoiNhaEntity> findByGiaTienTheoDemBetween(float min, float max);
}
