package com.tr.pharmacy.online.service.drug;

import com.tr.pharmacy.online.model.drug.Drug;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class DrugService implements IDrugService{

    @Override
    public Iterable<Drug> findAll() {
        return null;
    }

    @Override
    public Optional<Drug> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Drug getById(Long id) {
        return null;
    }

    @Override
    public Drug save(Drug drug) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
