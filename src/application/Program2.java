package application;

import java.util.List;
import java.util.Scanner;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("-- Test 1: department findById --");
		Department department = departmentDao.findById(2);
		System.out.println(department);
		
		System.out.println("\n-- Test 2: department findAll --");
		List<Department> list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n-- Test 3: department insert --");
		Department newDepartment = new Department(null, "Música");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted!\nID: " + newDepartment.getId());
		
		System.out.println("\n-- Test 3: department insert --");
		department = departmentDao.findById(1);
		department.setName("Tools");
		departmentDao.update(department);
		System.out.println("Update completed!");
		
		System.out.println("\n-- Test 4: department deleteById --");
		System.out.print("Enter id for delete register: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delele completed!");

		sc.close();
		DB.closeConnection();
		System.out.println("\nTudo posso Naquele que me Fortalece!!");
	}
}
