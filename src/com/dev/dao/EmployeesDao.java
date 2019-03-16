package com.dev.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dev.model.Employee;
import com.dev.util.HibernateUtil;

public class EmployeesDao {

	public List<Employee> getEmployeesList(){
		Session session=null;
		List<Employee> empList=null;
		try {
			session=HibernateUtil.getSession();
			String queryStr="select emp from Employee emp";
			Query query=session.createQuery(queryStr);
			empList=query.list();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null)
				session.close();
		}
		return empList;
	}
	
	public Employee getEmployeeById(Long empId) {
		Session session=null;
		Employee emp=null;
		try {
			session=HibernateUtil.getSession();
			String queryStr="select emp from Employee emp";
			Query query=session.createQuery(queryStr);
			emp=session.get(Employee.class, empId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null)
				session.close();
		}
		return emp;
	}
	
	public void insertEmployee(Employee employee) {
		Session session=null;
		Transaction transaction=null;
		try {
			session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			session.save(employee);
			System.out.println("Inserted Employee :: "+employee);
			transaction.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			if(transaction!=null)
				transaction.rollback();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
	}
	
	public void deleteEmployee(Employee employee) {
		Session session=null;
		Transaction transaction=null;
		try {
			session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			session.delete(employee);
			System.out.println("Deleted Employee :: "+employee);
			transaction.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			if(transaction!=null)
				transaction.rollback();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
	}
}
