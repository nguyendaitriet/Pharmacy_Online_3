package com.tr.pharmacy.online.service.drug;

import com.tr.pharmacy.online.model.drug.Drug;
import com.tr.pharmacy.online.model.dto.DrugDTO;
import com.tr.pharmacy.online.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface IDrugService extends IGeneralService<Drug> {
    boolean isDrugExisted(Drug drug);

    List<DrugDTO> getAllDrugDTO();

    Optional<Drug> findByIdAndDeletedFalse(Long id);

    boolean isDrugUpdatedExisted(Drug drug);

}
