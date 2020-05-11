package com.onlinejdbcsession.jdbcfirstprogram.controller;

import com.onlinejdbcsession.jdbcfirstprogram.dao.EmployeeDao;
import com.onlinejdbcsession.jdbcfirstprogram.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    //@ResponseBody
    //Fetch all employee data
    @GetMapping(value="/employee")
    public List<Employee> getEmpData(){

          return employeeDao.getEmployeeData();
    }

    @GetMapping(value="/employee/{id}")
    public Employee getEmpData1(@PathVariable Integer id){

        return employeeDao.getEmployee(id);
    }

    @PostMapping(value="/save")
    public String saveEmployee(@RequestBody Employee e){

        String str=employeeDao.insertEmployee(e);
        return str;
    }

    @GetMapping(value="/employee/{id}/{name}")
    public String updateEmpData(@PathVariable Integer id,
                                @PathVariable String name){

        return employeeDao.updateEmployee(id,name);
    }

}
