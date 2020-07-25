package application;

import java.util.Date;

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
	}

}
