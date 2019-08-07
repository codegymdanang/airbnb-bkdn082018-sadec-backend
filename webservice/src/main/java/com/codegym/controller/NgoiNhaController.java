package com.codegym.controller;

import entity.NgoiNhaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.NgoiNhaService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class NgoiNhaController {
    @Autowired
    private NgoiNhaService ngoiNhaService;

    @PostMapping(value = "/nha")
    public ResponseEntity<NgoiNhaEntity> taoNha(@RequestBody NgoiNhaEntity ngoiNhaEntity, UriComponentsBuilder uriComponentsBuilder){
        NgoiNhaEntity ngoiNhaResponse = this.ngoiNhaService.save(ngoiNhaEntity);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/nha/{id}").buildAndExpand(ngoiNhaEntity.getId()).toUri());

        return new ResponseEntity<NgoiNhaEntity>(ngoiNhaEntity, HttpStatus.OK);
    }

    @GetMapping(value = "/nha")
    public ResponseEntity<List<NgoiNhaEntity>> tatCaNha(){
        List<NgoiNhaEntity> ngoiNhaEntities = ngoiNhaService.findAll();
        if (ngoiNhaEntities.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<NgoiNhaEntity>>(ngoiNhaEntities, HttpStatus.OK);
    }

    @GetMapping(value = "/nha/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NgoiNhaEntity> nha(@PathVariable long id){
        NgoiNhaEntity ngoiNhaEntity = ngoiNhaService.findById(id);
        if (ngoiNhaEntity == null){
            return new ResponseEntity<NgoiNhaEntity>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<NgoiNhaEntity>(ngoiNhaEntity, HttpStatus.OK);
    }

    @PutMapping(value = "/nha/{id}/cap_nhat")
    public ResponseEntity<NgoiNhaEntity> suaNha(@PathVariable long id, @RequestBody NgoiNhaEntity ngoiNhaEntity){
        NgoiNhaEntity currentNgoiNhaEntity = this.ngoiNhaService.findById(id);

        if (currentNgoiNhaEntity == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentNgoiNhaEntity.setTenNha(ngoiNhaEntity.getTenNha());
        currentNgoiNhaEntity.setChuNha(ngoiNhaEntity.getChuNha());
        currentNgoiNhaEntity.setDiaChi(ngoiNhaEntity.getDiaChi());
        currentNgoiNhaEntity.setDanhGia(ngoiNhaEntity.getDanhGia());
        currentNgoiNhaEntity.setGiaTienTheoDem(ngoiNhaEntity.getGiaTienTheoDem());
        currentNgoiNhaEntity.setLoaiNha(ngoiNhaEntity.getLoaiNha());
        currentNgoiNhaEntity.setMoTaChung(ngoiNhaEntity.getMoTaChung());
        currentNgoiNhaEntity.setSoPhongNgu(ngoiNhaEntity.getSoPhongNgu());
        currentNgoiNhaEntity.setSoPhongTam(ngoiNhaEntity.getSoPhongTam());
        currentNgoiNhaEntity.setTinhTrang(ngoiNhaEntity.isTinhTrang());
        currentNgoiNhaEntity.setHinhAnhNha(ngoiNhaEntity.getHinhAnhNha());

        this.ngoiNhaService.save(currentNgoiNhaEntity);
        return new ResponseEntity<>(currentNgoiNhaEntity, HttpStatus.OK);
    }

    @GetMapping(value = "/nha/findBySoPhongNgu/{soPhongNgu}")
    public ResponseEntity<List<NgoiNhaEntity>> findBySoPhongNgu(@PathVariable int soPhongNgu){
        List<NgoiNhaEntity> ngoiNhaEntities = this.ngoiNhaService.findBySoPhongNgu(soPhongNgu);

        if (ngoiNhaEntities.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ngoiNhaEntities, HttpStatus.OK);
    }

    @GetMapping(value = "/nha/findBySoPhongTam/{soPhongNgu}")
    public ResponseEntity<List<NgoiNhaEntity>> findBySoPhongTam(@PathVariable int soPhongNgu){
        List<NgoiNhaEntity> ngoiNhaEntities = this.ngoiNhaService.findBySoPhongTam(soPhongNgu);

        if (ngoiNhaEntities.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ngoiNhaEntities, HttpStatus.OK);
    }

    @GetMapping(value = "/nha/findByGiaPhongTheoDem")
    public ResponseEntity<List<NgoiNhaEntity>> findByGiaPhongTheoDem(@RequestParam int min, @RequestParam int max){
        List<NgoiNhaEntity> ngoiNhaEntities = this.ngoiNhaService.findByGiaTienTheoDemBetween(min, max);

        if (ngoiNhaEntities.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ngoiNhaEntities, HttpStatus.OK);
    }
}
