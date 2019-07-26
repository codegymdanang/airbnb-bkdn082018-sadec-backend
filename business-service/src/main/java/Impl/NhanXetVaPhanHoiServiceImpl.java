package Impl;

import entity.NhanXetVaPhanHoiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repository.NhanXetVaPhanHoiRepository;
import service.NhanXetVaPhanHoiService;

@Service
public class NhanXetVaPhanHoiServiceImpl implements NhanXetVaPhanHoiService {
    @Autowired
    private NhanXetVaPhanHoiRepository nhanXetVaPhanHoiRepository;

    @Override
    public Page<NhanXetVaPhanHoiEntity> findAll(Pageable pageable) {
        return this.nhanXetVaPhanHoiRepository.findAll(pageable);
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
