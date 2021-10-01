package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		
		System.out.println("==== TEST 1: Seller findbyId ====");
		Department department = departmentDao.findbyId(3);
		System.out.println(department);
		
		
		System.out.println("\n=== TEST 2: department findAll =====");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: seller insert =====");
		Department newDepartment = new Department(null, "Sports");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n=== TEST 4: seller update =====");
		department = departmentDao.findbyId(3);
		department.setName("Music");
		departmentDao.update(department);
		System.out.println("Update Completed");
		
		System.out.println("\n=== TEST 5: seller delete =====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Completed");

		sc.close();
	}
}
