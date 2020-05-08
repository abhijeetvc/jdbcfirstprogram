package com.onlinejdbcsession.jdbcfirstprogram.controller;

import com.onlinejdbcsession.jdbcfirstprogram.dao.EmployeeDao;
import com.onlinejdbcsession.jdbcfirstprogram.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping(value="/employee")
    public List<Employee> getEmpData(){

          return employeeDao.getEmployeeData();
    }
}
