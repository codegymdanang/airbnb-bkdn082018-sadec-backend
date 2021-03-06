package com.codegym.controller;

import entity.LichSuThueNhaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.LichSuThueNhaService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class LichSuThueNhaController {
    @Autowired
    private LichSuThueNhaService lichSuThueNhaService;

    @PostMapping(value = "/lich_su_thue_nha")
    public ResponseEntity<Void> taoLichSuThueNha(@RequestBody LichSuThueNhaEntity lichSuThueNhaEntity, UriComponentsBuilder uriComponentsBuilder){
        this.lichSuThueNhaService.save(lichSuThueNhaEntity);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/lich_su_thue_nha/{id}").buildAndExpand(lichSuThueNhaEntity.getId()).toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/lich_su_thue_nha/{id}/xoa")
    public ResponseEntity<Void> xoaLichSu(@PathVariable long id){
        LichSuThueNhaEntity lichSuThueNhaEntity = this.lichSuThueNhaService.findById(id);

        if (lichSuThueNhaEntity == null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        this.lichSuThueNhaService.remove(lichSuThueNhaEntity.getId());
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/lich_su_thue_nha")
    public ResponseEntity<List<LichSuThueNhaEntity>> tatCaLichSu(){
        List<LichSuThueNhaEntity> lichSuThueNhaEntities = this.lichSuThueNhaService.findAll();

        if (lichSuThueNhaEntities.isEmpty()){
            return new ResponseEntity<List<LichSuThueNhaEntity>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<LichSuThueNhaEntity>>(lichSuThueNhaEntities, HttpStatus.OK);
    }

    @GetMapping(value = "/lich_su_thue_nha/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LichSuThueNhaEntity> layLichSu(@PathVariable long id){
        LichSuThueNhaEntity lichSuThueNhaEntity = this.lichSuThueNhaService.findById(id);
         if (lichSuThueNhaEntity == null){
             return new ResponseEntity<LichSuThueNhaEntity>(HttpStatus.NOT_FOUND);
         }

         return new ResponseEntity<LichSuThueNhaEntity>(lichSuThueNhaEntity, HttpStatus.OK);
    }
}
