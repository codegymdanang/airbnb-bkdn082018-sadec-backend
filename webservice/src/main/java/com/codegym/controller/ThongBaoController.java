package com.codegym.controller;

import entity.ThongBaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.ThongBaoService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class ThongBaoController {
    @Autowired
    ThongBaoService thongBaoService;

    @PostMapping(value = "/thong_bao")
    public ResponseEntity<Void> taoThongBao(@RequestBody ThongBaoEntity thongBaoEntity, UriComponentsBuilder uriComponentsBuilder){
        this.thongBaoService.save(thongBaoEntity);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/thong_bao/{id}").buildAndExpand(thongBaoEntity.getId()).toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "/thong_bao")
    public ResponseEntity<List<ThongBaoEntity>> tatCaThongBao(){
        List<ThongBaoEntity> thongBaoEntities = this.thongBaoService.findAll();

        if (thongBaoEntities.isEmpty()){
            return new ResponseEntity<List<ThongBaoEntity>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<ThongBaoEntity>>(thongBaoEntities, HttpStatus.OK);
    }

    @GetMapping(value = "/thong_bao/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ThongBaoEntity> layThongBao(@PathVariable long id){
        ThongBaoEntity thongBaoEntity = this.thongBaoService.findById(id);

        if (thongBaoEntity == null){
            return new ResponseEntity<ThongBaoEntity>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ThongBaoEntity>(thongBaoEntity, HttpStatus.OK);
    }

    @DeleteMapping(value = "/thong_bao/{id}/xoa")
    public ResponseEntity<ThongBaoEntity> xoaThongBao(@PathVariable long id){
        ThongBaoEntity thongBaoEntity = this.thongBaoService.findById(id);

        if (thongBaoEntity == null){
            return new ResponseEntity<ThongBaoEntity>(HttpStatus.NOT_FOUND);
        }

        this.thongBaoService.remove(id);
        return new ResponseEntity<ThongBaoEntity>(HttpStatus.NO_CONTENT);
    }
}
