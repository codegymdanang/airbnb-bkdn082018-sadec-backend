package Impl;

import entity.ThuNhapThangEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jpaRepository.ThuNhapThangRepository;
import service.ThuNhapThangSerVice;

import java.util.List;

@Service
public class ThuNhapThangSerViceImpl implements ThuNhapThangSerVice {
    @Autowired
    private ThuNhapThangRepository thuNhapThangRepository;

    @Override
    public List<ThuNhapThangEntity> findAll() {
        return (List<ThuNhapThangEntity>) this.thuNhapThangRepository.findAll();
    }

    @Override
    public ThuNhapThangEntity findById(Long id) {
        return this.thuNhapThangRepository.findById(id).get();
    }

    @Override
    public void save(ThuNhapThangEntity danhGiaEntity) {
        this.thuNhapThangRepository.save(danhGiaEntity);
    }

    @Override
    public void remove(Long id) {
        this.thuNhapThangRepository.deleteById(id);
    }
}
