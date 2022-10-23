package com.api.test.controller;

import com.api.test.dto.NameDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api")
public class ApiPostController {

    @GetMapping("/name")
    public ResponseEntity<Map<String, Object>> postResponseEntityName() {
        Map<String, Object> name = new HashMap<>();
        name.put("name", "OH JU HYEON");
        return ResponseEntity.status(HttpStatus.OK).body(name);
    }

    @GetMapping("/name")
    public NameDTO postDtoName() {
        NameDTO nameDTO = new NameDTO();
        nameDTO.setName("OH JU HYEON");
        return nameDTO;
    }


}
