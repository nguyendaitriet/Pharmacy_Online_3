package com.tr.pharmacy.online.service.drug;

import com.tr.pharmacy.online.model.drug.DosageForm;
import com.tr.pharmacy.online.model.drug.Drug;
import com.tr.pharmacy.online.model.dto.DrugDTO;
import com.tr.pharmacy.online.repository.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DrugService implements IDrugService {

    @Autowired
    private DrugRepository drugRepository;

    @Override
    public Iterable<Drug> findAll() {
        return null;
    }

    @Override
    public List<DrugDTO> getAllDrugDTO() {
        return drugRepository.getAllDrugDTO();
    }

    @Override
    public Optional<Drug> findByIdAndDeletedFalse(Long id) {
        return drugRepository.findByIdAndDeletedFalse(id);
    }

    @Override
    public Optional<Drug> findById(Long id) {
        return drugRepository.findById(id);
    }

    @Override
    public Drug getById(Long id) {
        return null;
    }

    @Override
    public Drug save(Drug drug) {
        return drugRepository.save(drug);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public boolean isDrugExisted(Drug drug) {
        String drugName = drug.getDrugName();
        double drugContent = drug.getDrugContent();
        BigDecimal pricePerUnit = drug.getPricePerUnit();
        DosageForm dosageForm = drug.getDosageForm();
        LocalDate productionDate = drug.getProductionDate();
        LocalDate expirationDate = drug.getExpirationDate();
        return drugRepository.existsByDrugNameAndDrugContentAndPricePerUnitAndDosageFormAndProductionDateAndExpirationDateAndDeletedFalse(drugName, drugContent, pricePerUnit, dosageForm, productionDate, expirationDate);
    }

    public boolean isDrugUpdatedExisted(Drug drug) {
        long id = drug.getId();
        String drugName = drug.getDrugName();
        double drugContent = drug.getDrugContent();
        BigDecimal pricePerUnit = drug.getPricePerUnit();
        DosageForm dosageForm = drug.getDosageForm();
        LocalDate productionDate = drug.getProductionDate();
        LocalDate expirationDate = drug.getExpirationDate();
        return drugRepository.existsByDrugNameAndDrugContentAndPricePerUnitAndDosageFormAndProductionDateAndExpirationDateAndDeletedFalseAndIdIsNot(drugName, drugContent, pricePerUnit, dosageForm, productionDate, expirationDate, id);
    }

}
