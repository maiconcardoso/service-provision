package com.api.sale.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.sale.dtos.LaborDto;
import com.api.sale.entities.Labor;
import com.api.sale.services.LaborService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/labors")
public class LaborController {

    private final LaborService laborService;

    @PostMapping
    public ResponseEntity<Labor> save(@RequestBody @Valid LaborDto laborDto) {
        return new ResponseEntity<>(laborService.save(laborDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Labor>> findByClientNameAndDate(
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @RequestParam(name = "month", required = false) Integer month) {
        return ResponseEntity.status(HttpStatus.OK).body(laborService.findByClientNameAndDate("%" + name + "%", month));
    }

}
