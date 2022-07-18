package com.tr.pharmacy.online.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T getById(Long id);

    T save(T t);

    void remove(Long id);
}
