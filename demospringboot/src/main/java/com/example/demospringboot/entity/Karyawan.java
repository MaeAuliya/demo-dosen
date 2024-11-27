package com.example.demospringboot.entity;

import org.hibernate.engine.internal.ForeignKeys;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "karyawan")
public class Karyawan {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empid;
    //next

    @Column(name = "NIK")
	private String nik;

	@Column(name = "firstname")
	private String firstname;

    @Column(name = "lastname")
	private String lastname;

	@Column(name = "password")
	private String password;

    @Column(name = "id")
	private int id;

	public Karyawan() {}

    public Karyawan(String nik, String fname, String lname) {
        this.nik = nik;
        this.firstname = fname;
        this.lastname = lname;
    }

    public void setEmpid(int id) {
        this.empid = id;
    }
    public int getEmpid() {
        return empid;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }
    public String getNik() {
        return nik;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getLastname() {
        return lastname;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
}
