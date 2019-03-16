package com.dev;

import java.util.Date;
import java.util.List;

import com.dev.dao.EmployeesDao;
import com.dev.model.Employee;

public class HibernateExample {

	public static void main(String[] args) {
		EmployeesDao dao=new EmployeesDao();
		
		Employee emp=new Employee();
		emp.setName("Babu");
        emp.setDepartment("Security");
        emp.setJoinedOn(new Date());
        emp.setSalary(new Long(5250));
        
        dao.insertEmployee(emp);
        System.out.println("----------------------------------------------");
        
        List<Employee> empList=dao.getEmployeesList();
        empList.stream().forEach(System.out::println);
        System.out.println("----------------------------------------------");
        
        Employee empObj = dao.getEmployeeById(emp.getEmpId());
        System.out.println("Get Employee by ID::\n"+empObj);
        System.out.println("----------------------------------------------");

        dao.deleteEmployee(empObj);
        System.out.println("----------------------------------------------");

        empList=dao.getEmployeesList();
        empList.stream().forEach(System.out::println);
        System.out.println("----------------------------------------------");

        
	}
}
