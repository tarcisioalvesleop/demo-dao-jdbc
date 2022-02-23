package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	//programa não vai conhecer a implentação apenas a interface
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();
	}
}
