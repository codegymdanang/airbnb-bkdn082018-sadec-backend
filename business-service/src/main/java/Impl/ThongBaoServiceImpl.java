package Impl;

import entity.ThongBaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repository.ThongBaoRepository;
import service.ThongBaoService;

@Service
public class ThongBaoServiceImpl implements ThongBaoService {
    @Autowired
    private ThongBaoRepository thongBaoRepository;

    @Override
    public Page<ThongBaoEntity> findAll(Pageable pageable) {
        return this.thongBaoRepository.findAll(pageable);
    }

    @Override
    public ThongBaoEntity findById(Long id) {
        return this.thongBaoRepository.findById(id).get();
    }

    @Override
    public void save(ThongBaoEntity thongBaoEntity) {
        this.thongBaoRepository.save(thongBaoEntity);
    }

    @Override
    public void remove(long id) {
        ThongBaoEntity thongBaoEntity = this.findById(id);
        this.thongBaoRepository.delete(thongBaoEntity);
    }
}
