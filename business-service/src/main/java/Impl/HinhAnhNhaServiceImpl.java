package Impl;

import entity.HinhAnhNhaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jpaRepository.HinhAnhNhaRepository;
import service.HinhAnhNhaService;

import java.util.List;

@Service
public class HinhAnhNhaServiceImpl implements HinhAnhNhaService {
    @Autowired
    private HinhAnhNhaRepository hinhAnhNhaRepository;

    @Override
    public List<HinhAnhNhaEntity> findAll() {
        return (List<HinhAnhNhaEntity>) this.hinhAnhNhaRepository.findAll();
    }

    @Override
    public HinhAnhNhaEntity findById(Long id) {
        if (id.equals(null)){
            return null;
        }
        return this.hinhAnhNhaRepository.findById(id).get();
    }

    @Override
    public HinhAnhNhaEntity save(HinhAnhNhaEntity danhGiaEntity) {
        return this.hinhAnhNhaRepository.save(danhGiaEntity);
    }

    @Override
    public void remove(Long id) {
        this.hinhAnhNhaRepository.deleteById(id);
    }
}
