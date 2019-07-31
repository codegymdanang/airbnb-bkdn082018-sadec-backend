package Impl;

import entity.LichSuThueNhaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jpaRepository.LichSuThueNhaRepository;
import service.LichSuThueNhaService;

import java.util.List;

@Service
public class LichSuThueNhaServiceImpl implements LichSuThueNhaService {
    @Autowired
    private LichSuThueNhaRepository lichSuThueNhaRepository;

    @Override
    public List<LichSuThueNhaEntity> findAll() {
        return (List<LichSuThueNhaEntity>) this.lichSuThueNhaRepository.findAll();
    }

    @Override
    public LichSuThueNhaEntity findById(Long id) {
        if (id.equals(null)){
            return null;
        }
        return this.lichSuThueNhaRepository.findById(id).get();
    }

    @Override
    public LichSuThueNhaEntity save(LichSuThueNhaEntity danhGiaEntity) {
        return this.lichSuThueNhaRepository.save(danhGiaEntity);
    }

    @Override
    public void remove(Long id) {
        this.lichSuThueNhaRepository.deleteById(id);
    }
}
