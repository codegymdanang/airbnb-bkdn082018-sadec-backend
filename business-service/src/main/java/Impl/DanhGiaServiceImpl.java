package Impl;

import entity.DanhGiaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repository.DanhGiaRepository;
import service.DanhGiaService;

@Service
public class DanhGiaServiceImpl implements DanhGiaService {
    @Autowired
    private DanhGiaRepository danhGiaRepository;

    @Override
    public Page<DanhGiaEntity> findAll(Pageable pageable) {
        return this.danhGiaRepository.findAll(pageable);
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
