package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.dao.DaoFabrica;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class Program {
	//TESTE commit pelo ecplipse direto
	public static void main(String[] args) {
		Departamento departamento = new Departamento(1, "Livros"); 
		Vendedor vendedor = new Vendedor(21, "Marcio", "Marcio@Marcio.br", new Date(), 3000.0, departamento);
		
		System.out.println(vendedor);
		
		VendedorDao vendDao = DaoFabrica.criarVendedorDao();
		
		System.out.println("=== Teste 1: obterPorId ===");
		vendedor = vendDao.ObterPeloId(3);
		System.out.println(vendedor);
		
		System.out.println("=== Teste 2: obterPorDepartamento ===");
		List<Vendedor> listaVendedor = new ArrayList<Vendedor>();
		
		listaVendedor = vendDao.ObterPorDepartamento(departamento);
		
		for (Vendedor v : listaVendedor) {
			System.out.println(v);
		}
	}

}
