package com.codegym.controller;

import entity.NgoiNhaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.NgoiNhaService;

@RestController
public class NgoiNhaController {
    @Autowired
    private NgoiNhaService ngoiNhaService;

    @PostMapping(value = "/nha/")
    public ResponseEntity<Void> taoNha(@RequestBody NgoiNhaEntity ngoiNhaEntity, UriComponentsBuilder uriComponentsBuilder){
        this.ngoiNhaService.save(ngoiNhaEntity);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/nha/{id}").buildAndExpand(ngoiNhaEntity.getId()).toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

    @GetMapping(value = "/nha/")
    public ResponseEntity<Page<NgoiNhaEntity>> tatCaNha(Pageable pageable){
        Page<NgoiNhaEntity> ngoiNhaEntities = ngoiNhaService.findAll(pageable);
        if (ngoiNhaEntities.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Page<NgoiNhaEntity>>(ngoiNhaEntities, HttpStatus.OK);
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
            return new ResponseEntity<NgoiNhaEntity>(HttpStatus.NOT_FOUND);
        }

        currentNgoiNhaEntity.setTenNha(ngoiNhaEntity.getTenNha());
        currentNgoiNhaEntity.setChuNha(ngoiNhaEntity.getChuNha());
        currentNgoiNhaEntity.setDiaChi(ngoiNhaEntity.getDiaChi());
        currentNgoiNhaEntity.setDanhGia(ngoiNhaEntity.getDanhGia());
        currentNgoiNhaEntity.setGiaTienTheoDem(ngoiNhaEntity.getGiaTienTheoDem());
        currentNgoiNhaEntity.setLoaNha(ngoiNhaEntity.getLoaNha());
        currentNgoiNhaEntity.setMoTaChung(ngoiNhaEntity.getMoTaChung());
        currentNgoiNhaEntity.setSoPhongNgu(ngoiNhaEntity.getSoPhongNgu());
        currentNgoiNhaEntity.setSoPhongTam(ngoiNhaEntity.getSoPhongTam());
        currentNgoiNhaEntity.setTinhTrang(ngoiNhaEntity.isTinhTrang());

        this.ngoiNhaService.save(currentNgoiNhaEntity);
        return new ResponseEntity<NgoiNhaEntity>(currentNgoiNhaEntity, HttpStatus.OK);
    }

}
