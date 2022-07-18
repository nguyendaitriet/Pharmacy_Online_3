package com.tr.pharmacy.online.service.drug;

import com.tr.pharmacy.online.model.drug.DosageForm;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DosageFormService implements IDosageFormService{

    @Override
    public Iterable<DosageForm> findAll() {
        return null;
    }

    @Override
    public Optional<DosageForm> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public DosageForm getById(Long id) {
        return null;
    }

    @Override
    public DosageForm save(DosageForm dosageForm) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
