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
        if (id.equals(null)){
            return null;
        }
        return this.nguoiDungRepository.findById(id).get();
    }

    @Override
    public NguoiDungEntity save(NguoiDungEntity nguoiDungEntity) {
        if (nguoiDungEntity == null){
            return null;
        }
        return this.nguoiDungRepository.save(nguoiDungEntity);
    }

    @Override
    public void remove(Long id) {
        this.nguoiDungRepository.deleteById(id);
    }
}
