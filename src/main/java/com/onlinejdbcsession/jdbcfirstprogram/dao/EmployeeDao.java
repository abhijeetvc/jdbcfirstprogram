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
import java.util.Map;

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

    @Override
    public List<Map<String, Object>> getCombinedData() {

        String sql="select a.name as empName,a.city as empCity,b.name as empDepartment " +
                "from employeetab a,department b where a.dept_id=b.id";
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);

        return list;
    }

    @Override
    public List<Map<String, Object>> getCombinedData(Integer deptId) {

        String sql="select a.name as empName,a.city as empCity,b.name as empDepartment " +
                "from employeetab a,department b where a.dept_id=b.id and b.id=?";
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql,new Object[]{deptId});

        return list;
    }
}
