package model.dao;

import model.dao.impl.DepartamentoDaoJDBC;
import model.dao.impl.VendedorDaoJDBC;

public class DaoFabrica {
	public static VendedorDao criarVendedorDao() {
		return new VendedorDaoJDBC();
	}
	
	public static DepartamentoDao criarDepartamentoDao() {
		return new DepartamentoDaoJDBC();
	}
}