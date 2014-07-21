/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarm.springrestful.model.beans;

import com.sarm.springrestful.exceptions.DuplicateEmployeeException;
import com.sarm.springrestful.exceptions.EmployeeNotFoundException;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sarm
 */
@Entity
public class Department {

    @Id
    private Long id;

    @NotNull
    @Column(name = "Dept_Name")
    private String departmentName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", fetch = FetchType.EAGER)
    private List<Employee> employees;

    public int getEmployees() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Add a new Employee.
     *
     * @param employee the employee (should be unique)
     * @throws DuplicateEmployeeException If the employee number already exists
     * for this Department.
     */
    public void addEmployee(Employee employee) {
        try {
            if (getEmployee(employee.getNumber()) != null) {
                throw new DuplicateEmployeeException("Employee "
                        + employee.getNumber()
                        + " already exists for Department " + departmentName);
            }
        } catch (EmployeeNotFoundException e) {
            employees.add(employee);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Object getEmployee(String number) {
    if (employees == null)
			throw new IllegalStateException("No accounts collection");

		if (employees != null) {
			// Simple sequential search - OK as most people don't have many
			// accounts
			for (Employee employee : employees) {
				if (employee.getNumber().equals(number)) {
					return employee;
				}
			}
		}

		throw new EmployeeNotFoundException("No such employee with number '"
				+ number + "'");   }

}
