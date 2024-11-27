package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Interface
public interface DepartmentRepository
    extends JpaRepository<Department, Integer> {
}
