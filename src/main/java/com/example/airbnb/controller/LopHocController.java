package com.example.airbnb.controller;

import com.example.airbnb.model.LopHoc;
import com.example.airbnb.model.Response;
import com.example.airbnb.service.impl.LopHocServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@PropertySource("classpath:application.properties")
@CrossOrigin("*")
@RequestMapping("/lop-hoc")
public class LopHocController {
    @Autowired
    private LopHocServiceImpl lopHocService;

    @GetMapping
    public ResponseEntity<Iterable<LopHoc>> findAll() {
        return ResponseEntity.ok(lopHocService.findAll());
    }

    @PostMapping
    public ResponseEntity<LopHoc> insertItem(@RequestBody LopHoc lopHoc) {
        if (lopHocService.insertItem(lopHoc)) {
            return ResponseEntity.ok().build();
        }
        return new ResponseEntity<>(lopHoc, HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<LopHoc> editItem(@RequestBody LopHoc lopHoc) {
        if (lopHocService.editItem(lopHoc)) {
            return ResponseEntity.ok().build();
        }
        return new ResponseEntity<>(lopHoc, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping
    public ResponseEntity<LopHoc> deleteItem(@RequestBody LopHoc lopHoc) {
        if (lopHocService.deleteItem(lopHoc)) {
            return ResponseEntity.ok().build();
        }
        return new ResponseEntity<>(lopHoc, HttpStatus.NOT_FOUND);
    }
}
