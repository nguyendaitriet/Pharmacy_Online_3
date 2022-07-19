package com.tr.pharmacy.online.service.drug;

import com.tr.pharmacy.online.model.drug.DosageForm;
import com.tr.pharmacy.online.repository.DosageFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DosageFormService implements IDosageFormService{

    @Autowired
    DosageFormRepository dosageFormRepository;

    @Override
    public Iterable<DosageForm> findAll() {
        return dosageFormRepository.findAll();
    }

    @Override
    public Optional<DosageForm> findById(Long id) {
        return dosageFormRepository.findById(id);
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
