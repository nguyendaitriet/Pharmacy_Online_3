package com.tr.pharmacy.online.repository;

import com.tr.pharmacy.online.model.drug.DosageForm;
import com.tr.pharmacy.online.model.drug.Drug;
import com.tr.pharmacy.online.model.dto.DrugDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Long> {

    boolean existsByDrugNameAndDrugContentAndPricePerUnitAndDosageFormAndProductionDateAndExpirationDateAndDeletedFalse(String drugName, double drugContent, BigDecimal pricePerUnit, DosageForm dosageForm, LocalDate productionDate, LocalDate expirationDate);

    boolean existsByDrugNameAndDrugContentAndPricePerUnitAndDosageFormAndProductionDateAndExpirationDateAndDeletedFalseAndIdIsNot(String drugName, double drugContent, BigDecimal pricePerUnit, DosageForm dosageForm, LocalDate productionDate, LocalDate expirationDate, Long id);

    @Query("SELECT NEW com.tr.pharmacy.online.model.dto.DrugDTO (" +
                "d.id, " +
                "d.drugName, " +
                "d.drugContent, " +
                "d.quantity, " +
                "d.pricePerUnit, " +
                "d.expirationDate " +
            ")" +
            "FROM Drug AS d " +
            "WHERE d.deleted = FALSE ")
    List<DrugDTO> getAllDrugDTO();

    Optional<Drug> findByIdAndDeletedFalse(Long id);
}
