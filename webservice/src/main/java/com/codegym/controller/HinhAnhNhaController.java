package com.codegym.controller;

import entity.HinhAnhNhaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.HinhAnhNhaService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
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
    public ResponseEntity<List<HinhAnhNhaEntity>> tatCaHinhAnhNha(){
        List<HinhAnhNhaEntity> hinhAnhNhaEntities = this.hinhAnhNhaService.findAll();

        if (hinhAnhNhaEntities.isEmpty()){
            return new ResponseEntity<List<HinhAnhNhaEntity>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<HinhAnhNhaEntity>>(hinhAnhNhaEntities, HttpStatus.OK);
    }
}
