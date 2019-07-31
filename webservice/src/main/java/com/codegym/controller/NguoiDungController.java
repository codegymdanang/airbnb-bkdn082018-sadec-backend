package com.codegym.controller;

import entity.NguoiDungEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.NguoiDungService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class NguoiDungController {
    @Autowired
    private NguoiDungService nguoiDungService;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping(value = "/nguoi_dung")
    public ResponseEntity<Void> taoNguoiDung(@RequestBody NguoiDungEntity nguoiDungEntity, UriComponentsBuilder uriComponentsBuilder){
        NguoiDungEntity nguoiDung = nguoiDungService.findByTenNguoiDung(nguoiDungEntity.getTenNguoiDung());

        nguoiDungEntity.setMatKhau(passwordEncoder.encode(nguoiDungEntity.getMatKhau()));
        this.nguoiDungService.save(nguoiDungEntity);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/nguoi_dung/{id}").buildAndExpand(nguoiDungEntity.getId()).toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "/nguoi_dung", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NguoiDungEntity> nguoiDung(@RequestParam("name") String tenNguoiDung){
        NguoiDungEntity nguoiDungEntity = this.nguoiDungService.findByTenNguoiDung(tenNguoiDung);
        if (nguoiDungEntity == null){
            return new ResponseEntity<NguoiDungEntity>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<NguoiDungEntity>(nguoiDungEntity, HttpStatus.OK);
    }

    @GetMapping(value = "/nguoi_dung/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NguoiDungEntity> nguoiDung(@PathVariable long id){
        NguoiDungEntity nguoiDungEntity = this.nguoiDungService.findById(id);
        if (nguoiDungEntity == null){
            return new ResponseEntity<NguoiDungEntity>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<NguoiDungEntity>(nguoiDungEntity, HttpStatus.OK);
    }

    @PutMapping(value = "/nguoi_dung/{id}/cap_nhat")
    public ResponseEntity<NguoiDungEntity> suaNguoiDung(@PathVariable long id, @RequestBody NguoiDungEntity nguoiDungEntity){
        NguoiDungEntity currentnguoiDungEntity = this.nguoiDungService.findById(id);

        if (currentnguoiDungEntity == null){
            return new ResponseEntity<NguoiDungEntity>(HttpStatus.NOT_FOUND);
        }

        currentnguoiDungEntity.setDiaChi(nguoiDungEntity.getDiaChi());
        currentnguoiDungEntity.setEmail(nguoiDungEntity.getEmail());
        currentnguoiDungEntity.setHoTen(nguoiDungEntity.getHoTen());
        currentnguoiDungEntity.setMatKhau(nguoiDungEntity.getMatKhau());
        currentnguoiDungEntity.setSoDienThoai(nguoiDungEntity.getSoDienThoai());
        currentnguoiDungEntity.setTenNguoiDung(nguoiDungEntity.getTenNguoiDung());

        this.nguoiDungService.save(currentnguoiDungEntity);
        return new ResponseEntity<NguoiDungEntity>(currentnguoiDungEntity, HttpStatus.OK);

    }
}
