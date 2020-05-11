package com.onlinejdbcsession.jdbcfirstprogram.repository;

import com.onlinejdbcsession.jdbcfirstprogram.domain.Employee;

import java.util.List;

public interface EmployeeInterface {

    List<Employee> getEmployeeData();

    Employee getEmployee(Integer id);

    String insertEmployee(Employee e);

    String updateEmployee(Integer id,String name);
}
