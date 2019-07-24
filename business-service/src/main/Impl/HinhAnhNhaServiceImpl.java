package Impl;

import entity.HinhAnhNhaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repository.HinhAnhNhaRepository;
import service.HinhAnhNhaService;

@Service
public class HinhAnhNhaServiceImpl implements HinhAnhNhaService {
    @Autowired
    private HinhAnhNhaRepository hinhAnhNhaRepository;

    @Override
    public Page<HinhAnhNhaEntity> findAll(Pageable pageable) {
        return this.hinhAnhNhaRepository.findAll(pageable);
    }

    @Override
    public HinhAnhNhaEntity findById(Long id) {
        return this.hinhAnhNhaRepository.findById(id).get();
    }

    @Override
    public void save(HinhAnhNhaEntity danhGiaEntity) {
        this.hinhAnhNhaRepository.save(danhGiaEntity);
    }

    @Override
    public void remove(Long id) {
        this.hinhAnhNhaRepository.deleteById(id);
    }
}
