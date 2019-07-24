package com.codegym.controller;

import entity.ThongBaoEntity;
import entity.ThuNhapThangEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.ThuNhapThangSerVice;

@RestController
public class ThuNhapThangController {
    @Autowired
    private ThuNhapThangSerVice thuNhapThangSerVice;

    @PostMapping(value = "/thu_nhap_thang")
    public ResponseEntity<Void> taoThuNhapThang(@RequestBody ThuNhapThangEntity thuNhapThangEntity, UriComponentsBuilder uriComponentsBuilder){
        this.thuNhapThangSerVice.save(thuNhapThangEntity);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/thu_nhap_thang/{id}").buildAndExpand(thuNhapThangEntity.getId()).toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "/thu_nhap_thang")
    public ResponseEntity<Page<ThuNhapThangEntity>> tatCaThuNhapThang(Pageable pageable){
        Page<ThuNhapThangEntity> thuNhapThangEntities = this.thuNhapThangSerVice.findAll(pageable);

        if (thuNhapThangEntities.isEmpty()){
            return new ResponseEntity<Page<ThuNhapThangEntity>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Page<ThuNhapThangEntity>>(thuNhapThangEntities, HttpStatus.OK);
    }

    @GetMapping(value = "/thu_nhap_thang/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ThuNhapThangEntity> layThuNhapThang(@PathVariable long id){
        ThuNhapThangEntity thuNhapThangEntity = this.thuNhapThangSerVice.findById(id);

        if (thuNhapThangEntity == null){
            return new ResponseEntity<ThuNhapThangEntity>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<ThuNhapThangEntity>(thuNhapThangEntity, HttpStatus.OK);
    }
}
