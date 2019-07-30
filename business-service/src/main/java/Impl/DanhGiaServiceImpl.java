package Impl;

import entity.DanhGiaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jpaRepository.DanhGiaRepository;
import service.DanhGiaService;

import java.util.List;

@Service
public class DanhGiaServiceImpl implements DanhGiaService {
    @Autowired
    private DanhGiaRepository danhGiaRepository;

    @Override
    public List<DanhGiaEntity> findAll() {
        return (List<DanhGiaEntity>) this.danhGiaRepository.findAll();
    }

    @Override
    public DanhGiaEntity findById(Long id) {
        return this.danhGiaRepository.findById(id).get();
    }

    @Override
    public void save(DanhGiaEntity danhGiaEntity) {
        this.danhGiaRepository.save(danhGiaEntity);
    }

    @Override
    public void remove(Long id) {
        this.danhGiaRepository.deleteById(id);
    }
}
