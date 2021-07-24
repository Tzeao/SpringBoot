package com.tzeao.controller;

import com.tzeao.dao.EmployeeDao;
import com.tzeao.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employee = employeeDao.getEmployee();
        model.addAttribute("emps", employee);
        return "emp/list";
    }
    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        Collection<Employee> employee = employeeDao.getEmployee();
        model.addAttribute("emps", employee);
        return "emp/add";
    }
}
