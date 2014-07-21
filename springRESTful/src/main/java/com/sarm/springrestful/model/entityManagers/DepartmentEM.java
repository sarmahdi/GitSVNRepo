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

public class DepartmentEM {
    
    @PersistenceContext
	private EntityManager entityManager;
    
    
     @Transactional(readOnly = true)
	public List<Department> findAllDepartment() {
		
            
            try {
			String query = "select department from Department department "
					+ "order by department.number";

			List<Department>  departments= (List<Department>) entityManager.createQuery(query).getResultList();
					
			return departments;
		} catch (NoResultException e) {
			return null;
		}
		
	}
        
        
	@Transactional(readOnly = true)
	public Department findDepartment(String departmentId) {
		try {
			return (Department) entityManager
					.createQuery(
							"select d from Department d where d.departmentId = :departmentId")
					.setParameter("departmentId", departmentId).getSingleResult();
		} catch (NoResultException e) {
                    return null;
//			throw new AccountNotFoundException(number);
		}
	}
}
