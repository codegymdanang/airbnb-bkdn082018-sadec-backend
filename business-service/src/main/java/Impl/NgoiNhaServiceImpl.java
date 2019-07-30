package Impl;

import elasticsearchRepository.NgoiNhaESRepository;
import entity.NgoiNhaEntity;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jpaRepository.NgoiNhaRepository;
import service.NgoiNhaService;

import java.util.List;


@Service
public class NgoiNhaServiceImpl implements NgoiNhaService {
    @Autowired
    private NgoiNhaRepository ngoiNhaRepository;

    @Autowired
    private NgoiNhaESRepository ngoiNhaESRepository;

    @Override
    public List<NgoiNhaEntity> findAll() {
        return IteratorUtils.toList(this.ngoiNhaRepository.findAll().iterator());
    }

    @Override
    public NgoiNhaEntity findById(long id) {
        return this.ngoiNhaRepository.findById(id).get();
    }

    @Override
    public void save(NgoiNhaEntity ngoiNhaEntity) {
        this.ngoiNhaESRepository.save(ngoiNhaEntity);
        this.ngoiNhaRepository.save(ngoiNhaEntity);
    }

    @Override
    public void remove(Long id) {
        this.ngoiNhaESRepository.deleteById(id);
        this.ngoiNhaRepository.deleteById(id);
    }

    @Override
    public List<NgoiNhaEntity> findBySoPhongNgu(int soPhongNgu) {
        return this.ngoiNhaESRepository.findBySoPhongNgu(soPhongNgu);
    }

    @Override
    public List<NgoiNhaEntity> findBySoPhongTam(int soPhongTam) {
        return this.ngoiNhaESRepository.findBySoPhongTam(soPhongTam);
    }

    @Override
    public List<NgoiNhaEntity> findByDiaChi(String diaChi) {
        return this.ngoiNhaESRepository.findByDiaChi(diaChi);
    }

    @Override
    public List<NgoiNhaEntity> findByGiaTienTheoDemBetween(float min, float max) {
        return this.ngoiNhaESRepository.findByGiaTienTheoDemBetween(min, max);
    }

}
