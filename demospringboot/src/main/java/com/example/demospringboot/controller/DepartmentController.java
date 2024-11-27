package com.example.demospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demospringboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demospringboot.entity.Department;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    // private DepartmentRepository departmentRepository;
    private DepartmentService departmentService;

    @GetMapping("/department")
    public String departmentPage2(Model model){
        @SuppressWarnings("unused")
        List<Department> depList;
        @SuppressWarnings("unused")
        Department depRec;
        model.addAttribute("depList", departmentService.getAllDeps());
        model.addAttribute("depInfo", new Department());
		return "department.html";
	}

    @GetMapping("/department/{id}")
    public String departmentGetRec(Model model, @PathVariable("id") int id){
        @SuppressWarnings("unused")
        List<Department> depList;
        @SuppressWarnings("unused")
        Department depRec;
        model.addAttribute("depList", departmentService.getAllDeps());
		model.addAttribute("depRec", departmentService.getDepById(id));
		return "department.html";
	}

    @PostMapping( value={"/department/submit/", "/department/submit/{id}"}, params={"add"})
    public String departmentAdd(Model model, @ModelAttribute("depInfo") Department depInfo){
        @SuppressWarnings("unused")
        Department dep = departmentService.addDep(depInfo);
        @SuppressWarnings("unused")
        List<Department> depList;
        model.addAttribute("depList", departmentService.getAllDeps());
		return "redirect:/department";
	}

    @PostMapping( value="/department/submit/{id}", params={"edit"})
    public String departmentEdit(Model model, @ModelAttribute("depInfo") Department depInfo, @PathVariable("id") int id){
        @SuppressWarnings("unused")
        Department dep = departmentService.updateDep(id,depInfo);
        @SuppressWarnings("unused")
        List<Department> depRec;
        model.addAttribute("depList", departmentService.getAllDeps());
		return "redirect:/department";
	}

    @PostMapping( value="/department/submit/{id}", params={"delete"})
    public String departmentDelete(Model model, @ModelAttribute("depInfo") Department depInfo, @PathVariable("id") int id){
        departmentService.deleteDep(id);
        @SuppressWarnings("unused")
        List<Department> depRec;
        model.addAttribute("depList", departmentService.getAllDeps());
		return "redirect:/department";
	}
}
