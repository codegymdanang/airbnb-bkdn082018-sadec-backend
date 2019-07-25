package com.codegym.controller;

import entity.DanhGiaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.DanhGiaService;

@RestController
public class DanhGiaController {
    @Autowired
    private DanhGiaService danhGiaService;

    @PostMapping(value = "/danh_gia")
    public ResponseEntity<Void> taoDanhGia(@RequestBody DanhGiaEntity danhGiaEntity, UriComponentsBuilder uriComponentsBuilder){
        this.danhGiaService.save(danhGiaEntity);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/danh_gia/{id}").buildAndExpand(danhGiaEntity.getId()).toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "/danh_gia")
    public ResponseEntity<Page<DanhGiaEntity>> layDanhGia(Pageable pageable){
        Page<DanhGiaEntity> danhGiaEntities = this.danhGiaService.findAll(pageable);

        if (danhGiaEntities.isEmpty()){
            return new ResponseEntity<Page<DanhGiaEntity>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Page<DanhGiaEntity>>(danhGiaEntities, HttpStatus.OK);
    }

    @GetMapping(value = "/danh_gia/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DanhGiaEntity> danhGia(@PathVariable long id){
        DanhGiaEntity danhGiaEntity = this.danhGiaService.findById(id);

        if (danhGiaEntity == null){
            return new ResponseEntity<DanhGiaEntity>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<DanhGiaEntity>(danhGiaEntity, HttpStatus.OK);
    }
}
