package com.tr.pharmacy.online.controller.api;

import com.tr.pharmacy.online.model.drug.DosageForm;
import com.tr.pharmacy.online.model.drug.Drug;
import com.tr.pharmacy.online.model.dto.DosageFormDTO;
import com.tr.pharmacy.online.model.dto.DrugDTO;
import com.tr.pharmacy.online.service.drug.IDosageFormService;
import com.tr.pharmacy.online.service.drug.IDrugService;
import com.tr.pharmacy.online.utils.AppUtils;
import com.tr.pharmacy.online.utils.ErrorMessage;
import com.tr.pharmacy.online.utils.ParsingValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/drugs")
public class DrugAPI {

    @Autowired
    private AppUtils appUtils;

    @Autowired
    private IDosageFormService dosageFormService;

    @Autowired
    private IDrugService drugService;

    @GetMapping
    public ResponseEntity<?> getAllDrugs() {
        try {
            List<DrugDTO> drugDTOList = drugService.getAllDrugDTO();

            if (drugDTOList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(drugDTOList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findDrug/{drugId}")
    public ResponseEntity<?> findDrugById(@PathVariable String drugId) {
        if (ParsingValidationUtils.isLongParsable(drugId)) {
            long validId = Long.parseLong(drugId);
            Optional<Drug> drug = drugService.findByIdAndDeletedFalse(validId);

            if (drug.isPresent()) {
                return new ResponseEntity<>(drug.get().toDrugDTOForUpdating(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Drug doesn't exist.", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewDrug(@RequestBody DrugDTO drugDTO, BindingResult bindingResult) {
        return createOrUpdateDrug("create", drugDTO, bindingResult);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateDrug(@RequestBody DrugDTO drugDTO, BindingResult bindingResult) {
        return createOrUpdateDrug("update", drugDTO, bindingResult);
    }

    private ResponseEntity<?> createOrUpdateDrug(String action, DrugDTO drugDTO, BindingResult bindingResult) {
        new DrugDTO().validate(drugDTO, bindingResult);
        new DosageFormDTO().validate(drugDTO.getDosageForm(), bindingResult);

        if (bindingResult.hasErrors()) {
            return appUtils.mapErrorToResponse(bindingResult);
        }

        long dosageFormId = Long.parseLong(drugDTO.getDosageForm().getId());
        Optional<DosageForm> dosageForm = dosageFormService.findById(dosageFormId);

        if (!dosageForm.isPresent()) {
            return new ResponseEntity<>(ErrorMessage.DOSAGE_FORM_NOT_EXIST, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        DosageForm dosageFormObject = dosageForm.get();
        Drug newDrug = drugDTO.toDrug(dosageFormObject);

        switch (action) {
            case "create": {
                if (drugService.isDrugExisted(newDrug)) {
                    return new ResponseEntity<>(ErrorMessage.DRUG_EXISTS, HttpStatus.INTERNAL_SERVER_ERROR);
                }
                break;
            }
            case "update": {
                if (drugService.isDrugUpdatedExisted(newDrug)) {
                    return new ResponseEntity<>(ErrorMessage.DRUG_EXISTS, HttpStatus.INTERNAL_SERVER_ERROR);
                }
                break;
            }
        }

        try {
            Drug newDrugSaved = drugService.save(newDrug);
            return new ResponseEntity<>(newDrugSaved.toDrugDTOForShowing(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(ErrorMessage.SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
