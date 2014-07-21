/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.springrestful.model.entityManagers;

import com.sarm.springrestful.model.beans.Department;
import com.sarm.springrestful.model.beans.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sarm
 */
public class EmployeeEM {
    
    @PersistenceContext
	private EntityManager entityManager;
    
    @Transactional(readOnly = true)
	public List<Employee> findAllEmployees(String departmentId) {
		Department department = findDepartment(departmentId);
		return new ArrayList<Employee>(department.getEmployees());
	}
        
        
    @Transactional(readOnly = true)
	public Department findDepartment(String departmentId) {
		try {
			String query = "select c from Customer c left join fetch c.accounts a "
					+ "where username = :name order by a.number";

			Department c = (Department) entityManager.createQuery(query)
					.setParameter("name", departmentId).getSingleResult();
			return c;
		} catch (NoResultException e) {
			return null;
		}

	}
}
