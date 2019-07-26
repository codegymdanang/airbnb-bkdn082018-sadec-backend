package Impl;

import entity.NguoiDungEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.NguoiDungRepository;
import service.NguoiDungService;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {
    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    @Override
    public Iterable<NguoiDungEntity> findAll() {
        return this.nguoiDungRepository.findAll();
    }

    @Override
    public NguoiDungEntity findById(Long id) {
        return this.nguoiDungRepository.findById(id).get();
    }

    @Override
    public void save(NguoiDungEntity nguoiDungEntity) {
        this.nguoiDungRepository.save(nguoiDungEntity);
    }

    @Override
    public void remove(Long id) {
        this.nguoiDungRepository.deleteById(id);
    }
}
