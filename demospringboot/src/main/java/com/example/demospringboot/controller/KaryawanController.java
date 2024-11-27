package com.example.demospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demospringboot.service.DepartmentService;
import com.example.demospringboot.service.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demospringboot.entity.Department;
import com.example.demospringboot.entity.Karyawan;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class KaryawanController {

    @Autowired
    private KaryawanService karyawanService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/karyawan")
    //@ResponseBody
	public String karyawanPage(Model model){
        @SuppressWarnings("unused")
        List<Karyawan> empList;
        @SuppressWarnings("unused")
        List<Department> depList;
        model.addAttribute("empList", karyawanService.getAllEmps());
        model.addAttribute("depList", departmentService.getAllDeps());
        model.addAttribute("empInfo", new Karyawan());
		return "karyawan.html";
	}

    @GetMapping("/karyawan/{id}")
    public String karyawanGetRec(Model model, @PathVariable("id") int id){
        @SuppressWarnings("unused")
        List<Karyawan> empList;
        @SuppressWarnings("unused")
        Karyawan empRec;
        @SuppressWarnings("unused")
        List<Department> depList;
        model.addAttribute("empList", karyawanService.getAllEmps());
        model.addAttribute("depList", departmentService.getAllDeps());
		model.addAttribute("empRec", karyawanService.getEmpById(id));
		return "karyawan.html";
	}

    @PostMapping( value={"/karyawan/submit/", "/karyawan/submit/{id}"}, params={"add"})
    public String karyawanAdd(Model model, @ModelAttribute("empInfo") Karyawan empInfo){
        empInfo.setEmpid(0);
        @SuppressWarnings("unused")
        Karyawan emp = karyawanService.addEmp(empInfo);
        @SuppressWarnings("unused")
        List<Karyawan> empList;
        model.addAttribute("empList", karyawanService.getAllEmps());
        return "redirect:/karyawan";
    }

    @PostMapping( value="/karyawan/submit/{id}", params={"edit"})
    public String karyawanEdit(Model model, @ModelAttribute("empInfo") Karyawan empInfo, @PathVariable("id") int id){
        @SuppressWarnings("unused")
        Karyawan emp = karyawanService.updateEmp(id,empInfo);
        @SuppressWarnings("unused")
        List<Karyawan> empRec;
        model.addAttribute("empList", karyawanService.getAllEmps());
		return "redirect:/karyawan";
	}

    @PostMapping( value="/karyawan/submit/{id}", params={"delete"})
    public String karyawanDelete(Model model, @ModelAttribute("empInfo") Karyawan empInfo, @PathVariable("id") int id){
        karyawanService.deleteEmp(id);
        @SuppressWarnings("unused")
        List<Karyawan> empRec;
        model.addAttribute("empList", karyawanService.getAllEmps());
		return "redirect:/karyawan";
	}
}
