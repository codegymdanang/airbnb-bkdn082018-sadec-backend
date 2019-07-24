package com.codegym.controller;

import entity.HinhAnhNhaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.HinhAnhNhaService;

@RestController
public class HinhAnhNhaController {
    @Autowired
    private HinhAnhNhaService hinhAnhNhaService;

    @PostMapping(value = "/hinh_anh_nha")
    public ResponseEntity<Void> taoHinhAnhNha(@RequestBody HinhAnhNhaEntity hinhAnhNhaEntity, UriComponentsBuilder uriComponentsBuilder){
        this.hinhAnhNhaService.save(hinhAnhNhaEntity);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/hinh_anh_nha/{id}")
    public ResponseEntity<HinhAnhNhaEntity> hinhAnhNha(@PathVariable long id){
        HinhAnhNhaEntity hinhAnhNhaEntity = this.hinhAnhNhaService.findById(id);

        if (hinhAnhNhaEntity == null){
            return new ResponseEntity<HinhAnhNhaEntity>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<HinhAnhNhaEntity>(hinhAnhNhaEntity, HttpStatus.OK);
    }

    @GetMapping(value = "/hinh_anh_nha")
    public ResponseEntity<Page<HinhAnhNhaEntity>> tatCaHinhAnhNha(Pageable pageable){
        Page<HinhAnhNhaEntity> hinhAnhNhaEntities = this.hinhAnhNhaService.findAll(pageable);

        if (hinhAnhNhaEntities.isEmpty()){
            return new ResponseEntity<Page<HinhAnhNhaEntity>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Page<HinhAnhNhaEntity>>(hinhAnhNhaEntities, HttpStatus.OK);
    }
}
