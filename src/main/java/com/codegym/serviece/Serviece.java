package com.codegym.serviece;

import java.util.List;

public interface Serviece<T> {
    List <T> findAll();
    T findById(Long id);
    void save(T model);
    void remove(Long id);
}
