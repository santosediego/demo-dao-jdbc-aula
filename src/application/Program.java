package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
						//Interface
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		DB.closeConnection();
		
		System.out.println("\nTudo posso Naquele que me Fortalece!!");
	}
}
