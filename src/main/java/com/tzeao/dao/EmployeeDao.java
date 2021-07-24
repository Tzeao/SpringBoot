package com.tzeao.dao;

import com.tzeao.pojo.Department;
import com.tzeao.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

// 因为静态代码块是最先执行的，所有部门还没有取到值，员工就已经赋值了，所以空指针异常
@Repository
public class EmployeeDao {
    //    模拟数据库
    private static Map<Integer, Employee> employees = null;
    //    员工有部门
    @Autowired
    private  DepartmentDao departmentDao;
    //    主键自增
    private static Integer initId = 1006;

    static {
        employees = new HashMap<Integer, Employee>(); // 创建一个部门表
        employees.put(1001, new Employee(1001, "张三", "123456@qq.com", 0, new Department(101,"项目部"), new Date()));
        employees.put(1002, new Employee(1002, "李四", "456789@qq.com", 1, new Department(102,"调研部"), new Date()));
        employees.put(1003, new Employee(1003, "王五", "789123@qq.com", 1, new Department(103,"研发部"), new Date()));
        employees.put(1004, new Employee(1004, "赵六", "147258@qq.com", 0, new Department(104,"运营部"), new Date()));
        employees.put(1005, new Employee(1005, "江一", "258369@qq.com", 1, new Department(105,"公关部"), new Date()));
    }

    //    增加员工
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(), employee);
    }

    //    查询全部
    public Collection<Employee> getEmployee() {
        return employees.values();
    }

    //    id
    public Employee getEmployeeBiId(Integer id) {
        return employees.get(id);
    }
//    删除
    public void remove(Integer id){
        employees.remove(id);
    }

}
