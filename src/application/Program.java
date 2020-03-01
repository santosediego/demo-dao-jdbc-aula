package application;

import java.util.Date;
import java.util.List;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("-- Test 1: seller findById --");
						//Interface
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n-- Test 2: seller findByDepartment --");
		Department department = new Department(2, null);
		
		//Como pode retornar varias linhas de informação, listaremos;
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n-- Test 3: seller findAll --");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n-- Test 4: seller insert --");
		
		Seller newSeller = new Seller(null, "Greg", "greg@email.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		DB.closeConnection();
		System.out.println("\nTudo posso Naquele que me Fortalece!!");
	}
}
