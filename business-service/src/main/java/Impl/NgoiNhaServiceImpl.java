package Impl;

import entity.NgoiNhaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repository.NgoiNhaRepository;
import service.NgoiNhaService;


@Service
public class NgoiNhaServiceImpl implements NgoiNhaService {
    @Autowired
    private NgoiNhaRepository ngoiNhaRepository;

    @Override
    public Page<NgoiNhaEntity> findAll(Pageable pageable) {
        return this.ngoiNhaRepository.findAll(pageable);
    }

    @Override
    public NgoiNhaEntity findById(Long id) {
        return this.ngoiNhaRepository.findById(id).get();
    }

    @Override
    public void save(NgoiNhaEntity danhGiaEntity) {
        this.ngoiNhaRepository.save(danhGiaEntity);
    }

    @Override
    public void remove(Long id) {
        this.ngoiNhaRepository.deleteById(id);
    }
}
