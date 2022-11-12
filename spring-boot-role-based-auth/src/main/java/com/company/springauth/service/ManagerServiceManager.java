package com.company.springauth.service;

import com.company.springauth.model.Manager;
import com.company.springauth.repository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ManagerServiceManager implements ManagerService {

    private final ManagerRepository managerRepository;

    @Override
    public List<Manager> getAll() {
        log.info("Get all manager.");
        return managerRepository.findAll();
    }

    @Override
    public void save(Manager manager) {
        log.info("Save manager.");
        managerRepository.save(manager);
    }

    @Override
    public Manager getById(Long id) {
        log.info("Get manager by id.");
        return managerRepository.findById(id).orElseThrow();
    }


    @Override
    public void delete(Long id) {
        log.info("Delete manager.");
        managerRepository.deleteById(id);
    }
}
