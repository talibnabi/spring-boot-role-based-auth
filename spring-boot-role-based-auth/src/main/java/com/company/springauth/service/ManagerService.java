package com.company.springauth.service;

import com.company.springauth.model.Manager;

import java.util.List;
import java.util.Optional;

public interface ManagerService {
    List<Manager> getAll();

    void save(Manager manager);

    Manager getById(Long id);


    void delete(Long id);
}
