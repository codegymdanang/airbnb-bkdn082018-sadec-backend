package com.codegym.controller;

import entity.NhanXetVaPhanHoiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.NhanXetVaPhanHoiService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
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
    public ResponseEntity<List<NhanXetVaPhanHoiEntity>> tatCaNhanXetVaPhanHoi(){
        List<NhanXetVaPhanHoiEntity> nhanXetVaPhanHoiEntities = this.nhanXetVaPhanHoiService.findAll();

        if (nhanXetVaPhanHoiEntities.isEmpty()){
            return new ResponseEntity<List<NhanXetVaPhanHoiEntity>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<NhanXetVaPhanHoiEntity>>(nhanXetVaPhanHoiEntities, HttpStatus.OK);
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
