package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	//programa n�o vai conhecer a implenta��o apenas a interface
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();
	}
}
