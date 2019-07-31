package Impl;

import entity.ThongBaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jpaRepository.ThongBaoRepository;
import service.ThongBaoService;

import java.util.List;

@Service
public class ThongBaoServiceImpl implements ThongBaoService {
    @Autowired
    private ThongBaoRepository thongBaoRepository;

    @Override
    public List<ThongBaoEntity> findAll() {
        return (List<ThongBaoEntity>) this.thongBaoRepository.findAll();
    }

    @Override
    public ThongBaoEntity findById(Long id) {
        return this.thongBaoRepository.findById(id).get();
    }

    @Override
    public ThongBaoEntity save(ThongBaoEntity thongBaoEntity) {
        return this.thongBaoRepository.save(thongBaoEntity);
    }

    @Override
    public void remove(long id) {
        ThongBaoEntity thongBaoEntity = this.findById(id);
        this.thongBaoRepository.delete(thongBaoEntity);
    }
}
