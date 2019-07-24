package Impl;

import entity.ThuNhapThangEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repository.ThuNhapThangRepository;
import service.ThuNhapThangSerVice;

@Service
public class ThuNhapThangSerViceImpl implements ThuNhapThangSerVice {
    @Autowired
    private ThuNhapThangRepository thuNhapThangRepository;

    @Override
    public Page<ThuNhapThangEntity> findAll(Pageable pageable) {
        return this.thuNhapThangRepository.findAll(pageable);
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
