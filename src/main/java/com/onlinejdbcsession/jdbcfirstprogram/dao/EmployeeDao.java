package com.onlinejdbcsession.jdbcfirstprogram.dao;

import com.onlinejdbcsession.jdbcfirstprogram.domain.Employee;
import com.onlinejdbcsession.jdbcfirstprogram.repository.EmployeeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class EmployeeDao implements EmployeeInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getEmployeeData() {
        String sql="select * from employeetab";
        List<Employee> list=jdbcTemplate.query(sql,
                new BeanPropertyRowMapper(Employee.class));
        return list;
    }
}
