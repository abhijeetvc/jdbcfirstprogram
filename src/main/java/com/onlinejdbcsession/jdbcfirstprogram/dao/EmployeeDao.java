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

    @Override
    public Employee getEmployee(Integer id) {
        String sql="select * from employeetab where id=?";

        Employee emp= (Employee) jdbcTemplate.queryForObject(sql,new Object[]{id},
                new BeanPropertyRowMapper(Employee.class));

        return emp;
    }

    @Override
    public String insertEmployee(Employee e) {
        String sql="insert into employeetab values(?,?,?)";

        jdbcTemplate.update(sql,new Object[]{e.getId(),e.getName(),e.getCity()});

        return "Employee Saved Successfully";
    }

    @Override
    public String updateEmployee(Integer id, String name) {
        String sql="update employeetab set name=? where id=?";
        jdbcTemplate.update(sql,new Object[]{name,id});
        return "Employee updated";
    }
}
