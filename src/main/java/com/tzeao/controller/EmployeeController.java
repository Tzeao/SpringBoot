package com.tzeao.controller;

import com.tzeao.dao.DepartmentDao;
import com.tzeao.dao.EmployeeDao;
import com.tzeao.pojo.Department;
import com.tzeao.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employee = employeeDao.getEmployee();
        model.addAttribute("emps", employee);
        return "emp/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(Model model) {
//        跳转时携带部门信息数据过去，用于添加下拉框
        Collection<Department> department = departmentDao.getDepartment();
        model.addAttribute("dept", department);
        return "emp/add";
    }

    // 添加
    @PostMapping("/toAdd")
    public String add(Employee employee, Model model) {
        employeeDao.save(employee);//保存
        return "redirect:/emps";
    }

    // 修改页面
    @GetMapping("/emp/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model) {
// 根据id查数据
        Employee employeeBiId = employeeDao.getEmployeeBiId(id);
        Collection<Department> department = departmentDao.getDepartment();
        model.addAttribute("dept",employeeBiId).addAttribute("depts", department);
        System.out.println(1111);
        return "emp/update";
    }

//    修改
    @RequestMapping("/update")
    public String update(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

//    删除
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        employeeDao.remove(id);
        return "redirect:/emps";
    }
}
