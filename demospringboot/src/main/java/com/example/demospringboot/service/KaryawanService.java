package com.example.demospringboot.service;

// DepartmentService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demospringboot.entity.Karyawan;
import com.example.demospringboot.repository.KaryawanRepository;

import java.util.List;

@Service
public class KaryawanService {
    @Autowired
    private KaryawanRepository karyawanRepository;

    public List<Karyawan> getAllEmps() {
        return karyawanRepository.findAll();
    }

    public Karyawan getEmpById(int id) {
        return karyawanRepository.findById(id).orElse(null);
    }

    public Karyawan addEmp(Karyawan emp) {
        return karyawanRepository.save(emp);
    }

    public Karyawan updateEmp(int id, Karyawan dep) {
        dep.setEmpid(id);
        return karyawanRepository.save(dep);
    }

    public void deleteEmp(int id) {
        karyawanRepository.deleteById(id);
    }
}