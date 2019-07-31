package Impl;

import entity.NguoiDungEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jpaRepository.NguoiDungRepository;
import service.NguoiDungService;

import java.util.List;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {
    @Autowired
    private NguoiDungRepository nguoiDungRepository;
    @Override
    public List<NguoiDungEntity> findAll() {
        return (List<NguoiDungEntity>) this.nguoiDungRepository.findAll();
    }

    @Override
    public NguoiDungEntity findByTenNguoiDung(String tenNguoiDung) {
        return nguoiDungRepository.findByTenNguoiDung(tenNguoiDung);
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
