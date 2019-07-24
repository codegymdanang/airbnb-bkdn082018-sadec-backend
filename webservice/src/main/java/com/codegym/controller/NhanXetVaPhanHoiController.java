package com.codegym.controller;

import entity.NhanXetVaPhanHoiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.NhanXetVaPhanHoiService;

@RestController
public class NhanXetVaPhanHoiController {
    @Autowired
    private NhanXetVaPhanHoiService nhanXetVaPhanHoiService;

    @PostMapping(value = "/nhan_xet_va_phan_hoi")
    public ResponseEntity<NhanXetVaPhanHoiEntity> taoNhanXetVaPhanHoi(@RequestBody NhanXetVaPhanHoiEntity nhanXetVaPhanHoiEntity,
                                                                        UriComponentsBuilder uriComponentsBuilder){
        this.nhanXetVaPhanHoiService.save(nhanXetVaPhanHoiEntity);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/nhan_xet_va_phan_hoi/{id}").buildAndExpand(nhanXetVaPhanHoiEntity.getId()).toUri());

        return new ResponseEntity<NhanXetVaPhanHoiEntity>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "/nhan_xet_va_phan_hoi")
    public ResponseEntity<Page<NhanXetVaPhanHoiEntity>> tatCaNhanXetVaPhanHoi(Pageable pageable){
        Page<NhanXetVaPhanHoiEntity> nhanXetVaPhanHoiEntities = this.nhanXetVaPhanHoiService.findAll(pageable);

        if (nhanXetVaPhanHoiEntities.isEmpty()){
            return new ResponseEntity<Page<NhanXetVaPhanHoiEntity>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Page<NhanXetVaPhanHoiEntity>>(nhanXetVaPhanHoiEntities, HttpStatus.OK);
    }

    @GetMapping(value = "/nhan_xet_va_phan_hoi/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NhanXetVaPhanHoiEntity> layNhanXetVaThongBao(@PathVariable long id){
        NhanXetVaPhanHoiEntity nhanXetVaPhanHoiEntity = this.nhanXetVaPhanHoiService.findById(id);

        if (nhanXetVaPhanHoiEntity == null){
            return new ResponseEntity<NhanXetVaPhanHoiEntity>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<NhanXetVaPhanHoiEntity>(nhanXetVaPhanHoiEntity, HttpStatus.OK);
    }

    @DeleteMapping(value = "/nhan_xet_va_phan_hoi/{id}/xoa")
    public ResponseEntity<NhanXetVaPhanHoiEntity> xoaNhanXet(@PathVariable long id){
        NhanXetVaPhanHoiEntity nhanXetVaPhanHoiEntity = this.nhanXetVaPhanHoiService.findById(id);

        if (nhanXetVaPhanHoiEntity == null){
            return new ResponseEntity<NhanXetVaPhanHoiEntity>(HttpStatus.NOT_FOUND);
        }

        this.nhanXetVaPhanHoiService.remove(id);
        return new ResponseEntity<NhanXetVaPhanHoiEntity>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/nhan_xet_va_phan_hoi/{id}/sua")
    public ResponseEntity<NhanXetVaPhanHoiEntity> suaNhanXet(@PathVariable long id, @RequestBody NhanXetVaPhanHoiEntity nhanXetVaPhanHoiEntity){
        NhanXetVaPhanHoiEntity currentNhanxet = this.nhanXetVaPhanHoiService.findById(id);

        if ( currentNhanxet == null ){
            return new ResponseEntity<NhanXetVaPhanHoiEntity>(HttpStatus.NOT_FOUND);
        }

        currentNhanxet.setNgoiNha(nhanXetVaPhanHoiEntity.getNgoiNha());
        currentNhanxet.setNguoiDung(nhanXetVaPhanHoiEntity.getNguoiDung());
        currentNhanxet.setNhanXet(nhanXetVaPhanHoiEntity.getNhanXet());
        currentNhanxet.setNoiDung(nhanXetVaPhanHoiEntity.getNoiDung());

        this.nhanXetVaPhanHoiService.save(currentNhanxet);
        return new ResponseEntity<NhanXetVaPhanHoiEntity>(currentNhanxet, HttpStatus.OK);
    }
}
