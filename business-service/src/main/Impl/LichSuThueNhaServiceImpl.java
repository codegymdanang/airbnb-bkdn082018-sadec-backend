package Impl;

import entity.LichSuThueNhaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repository.LichSuThueNhaRepository;
import service.LichSuThueNhaService;

@Service
public class LichSuThueNhaServiceImpl implements LichSuThueNhaService {
    @Autowired
    private LichSuThueNhaRepository lichSuThueNhaRepository;

    @Override
    public Page<LichSuThueNhaEntity> findAll(Pageable pageable) {
        return this.lichSuThueNhaRepository.findAll(pageable);
    }

    @Override
    public LichSuThueNhaEntity findById(Long id) {
        return this.lichSuThueNhaRepository.findById(id).get();
    }

    @Override
    public void save(LichSuThueNhaEntity danhGiaEntity) {
        this.lichSuThueNhaRepository.save(danhGiaEntity);
    }

    @Override
    public void remove(Long id) {
        this.lichSuThueNhaRepository.deleteById(id);
    }
}
