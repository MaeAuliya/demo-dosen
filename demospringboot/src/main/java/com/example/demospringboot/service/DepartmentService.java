package com.example.demospringboot.service;

// DepartmentService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demospringboot.entity.Department;
import com.example.demospringboot.repository.DepartmentRepository;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDeps() {
        return departmentRepository.findAll();
    }

    public Department getDepById(int id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department addDep(Department dep) {
        return departmentRepository.save(dep);
    }

    public Department updateDep(int id, Department dep) {
        dep.setId(id);
        return departmentRepository.save(dep);
    }

    public void deleteDep(int id) {
        departmentRepository.deleteById(id);
    }
}