package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		//program não conhece a implementação apenas a interface
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Test 1: Department findById ===");
		Department department = departmentDao.findById(3);
		
		System.out.println(department);
		
		//findAll
		System.out.println("\n=== Test 2: Department findAll ===");
		List<Department> list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		//inserção
		System.out.println("\n===Test 3: Department Insert ===");
		Department newDep = new Department(null, "Financeiro"); 
		departmentDao.insert(newDep);
		System.out.println("INSERT! New id = " + newDep.getId());
		
		//Update
		System.out.println("\n===Test 4: seller Update ===");
		department = departmentDao.findById(7); //pegando os dados do vendedor com o id 1
		department.setName("Compras");
		departmentDao.update(department);
		System.out.println("Update completed.");		
		
		//DELETE
		System.out.println("\n===Test 5: Department Delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed.");
		
		sc.close();
	}

}
