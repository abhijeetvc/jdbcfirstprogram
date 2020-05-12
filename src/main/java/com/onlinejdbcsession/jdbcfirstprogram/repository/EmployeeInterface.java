package com.onlinejdbcsession.jdbcfirstprogram.repository;

import com.onlinejdbcsession.jdbcfirstprogram.domain.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeInterface {

    List<Employee> getEmployeeData();

    Employee getEmployee(Integer id);

    String insertEmployee(Employee e);

    String updateEmployee(Integer id,String name);

    List<Map<String,Object>> getCombinedData();

    List<Map<String,Object>> getCombinedData(Integer deptId);
}
