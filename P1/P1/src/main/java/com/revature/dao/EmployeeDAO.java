package com.revature.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Employee;

public interface EmployeeDAO {
	
	public abstract void createEmployee(String firstName, String lastName, String userName, String passWord, String email, int managerClass)
		throws SQLException;
	
	public abstract ArrayList<Employee> readEmpList() 
		throws SQLException;
}
