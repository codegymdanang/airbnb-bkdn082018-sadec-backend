package com.codegym.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.HinhAnhNhaEntity;
import entity.NgoiNhaEntity;
import jdk.nashorn.internal.parser.JSONParser;
import jpaRepository.NgoiNhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;
import service.HinhAnhNhaService;
import service.NgoiNhaService;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class HinhAnhNhaController {
    @Autowired
    private HinhAnhNhaService hinhAnhNhaService;

    @Autowired
    private NgoiNhaService ngoiNhaService;

    @PostMapping(value = "/upload_hinh_anh")
    public ResponseEntity<Void> uploadAnh(@RequestParam("image")MultipartFile multipartFile,
                                          @RequestParam("id") String nhaId) {
        NgoiNhaEntity nhaEntity = ngoiNhaService.findById(Integer.parseInt(nhaId));
        try {
            HinhAnhNhaEntity hinhAnhNhaEntity = new HinhAnhNhaEntity(multipartFile.getBytes(), nhaEntity);
            hinhAnhNhaService.save(hinhAnhNhaEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/hinh_anh_nha")
    public ResponseEntity<Void> taoHinhAnhNha(@RequestBody HinhAnhNhaEntity hinhAnhNhaEntity, UriComponentsBuilder uriComponentsBuilder){
//        for (HinhAnhNhaEntity hinhAnh: hinhAnhNhaEntitys) {
            this.hinhAnhNhaService.save(hinhAnhNhaEntity);
//        }
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
