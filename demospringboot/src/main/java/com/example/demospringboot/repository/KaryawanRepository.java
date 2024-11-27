package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Karyawan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Interface
public interface KaryawanRepository
    extends JpaRepository<Karyawan, Integer> {
}
