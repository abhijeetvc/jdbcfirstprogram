package com.onlinejdbcsession.jdbcfirstprogram.controller;

import com.onlinejdbcsession.jdbcfirstprogram.dao.EmployeeDao;
import com.onlinejdbcsession.jdbcfirstprogram.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping(value="/getcombinedata/{deptId}")
    public List<Map<String,Object>> getEmpAndDepartmentById(@PathVariable Integer deptId){

         return employeeDao.getCombinedData(deptId);

    }
}
