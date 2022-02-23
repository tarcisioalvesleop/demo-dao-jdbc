package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {
	
	//Dao tem uma dependencia com o banco
	private Connection conn;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Seller obj) {
		
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName " 
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = Department.Id "
					+ "WHERE seller.Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			//passando a tabela do query resultante para objetos em java
			if(rs.next()) {
				//montando o objeto department com os dados do rs
				Department dep = instantiateDepartment(rs);
				//montando o objeto Seller com os dados do rs
				Seller obj = instantiateSeller(rs, dep);
				
				return obj;				
			}
			return null;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			//fechando os recursos rs e st
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			//a conexão manteve aberta pelo fato de outro ser executado em seguida e será fechada no program main
		}
	}

	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {//propagando a exceção rs(foi tratada onde chamou a função)
		//montando o objeto Seller com os dados do rs
		Seller obj = new Seller();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setBirthDate(rs.getDate("BirthDate"));
		obj.setDepartment(dep);
		
		return obj;
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {//propagando a exceção rs (foi tratada onde chamou)
		//montando o objeto Departmet com os dados do rs
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));//igual no banco de dados nome do departamento
		dep.setName(rs.getString("DepName"));
		
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
