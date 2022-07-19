package com.tr.pharmacy.online.controller.api;

import com.tr.pharmacy.online.model.drug.DosageForm;
import com.tr.pharmacy.online.service.drug.IDosageFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dosageForms")
public class DosageFormAPI {

    @Autowired
    IDosageFormService dosageFormService;

    @GetMapping
    public ResponseEntity<?> getAllDosageForms () {
        Iterable<DosageForm> dosageFormList = dosageFormService.findAll();
        return new ResponseEntity<>(dosageFormList, HttpStatus.OK);
    }

}
