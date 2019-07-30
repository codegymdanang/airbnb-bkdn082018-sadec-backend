package Impl;

import entity.NhanXetVaPhanHoiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jpaRepository.NhanXetVaPhanHoiRepository;
import service.NhanXetVaPhanHoiService;

import java.util.List;

@Service
public class NhanXetVaPhanHoiServiceImpl implements NhanXetVaPhanHoiService {
    @Autowired
    private NhanXetVaPhanHoiRepository nhanXetVaPhanHoiRepository;

    @Override
    public List<NhanXetVaPhanHoiEntity> findAll() {
        return (List<NhanXetVaPhanHoiEntity>) this.nhanXetVaPhanHoiRepository.findAll();
    }

    @Override
    public NhanXetVaPhanHoiEntity findById(Long id) {
        return this.nhanXetVaPhanHoiRepository.findById(id).get();
    }

    @Override
    public void save(NhanXetVaPhanHoiEntity danhGiaEntity) {
        this.nhanXetVaPhanHoiRepository.save(danhGiaEntity);
    }

    @Override
    public void remove(Long id) {
        this.nhanXetVaPhanHoiRepository.deleteById(id);
    }
}
