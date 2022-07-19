package com.tr.pharmacy.online.repository;

import com.tr.pharmacy.online.model.drug.DosageForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DosageFormRepository extends JpaRepository<DosageForm, Long> {


}
