package com.tr.pharmacy.online.repository;

import com.tr.pharmacy.online.model.drug.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Long> {
}
