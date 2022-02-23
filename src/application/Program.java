package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		//program n�o conhece a implementa��o apenas a interface
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("===Test 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		

	}

}
