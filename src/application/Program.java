package application;

import java.util.Date;

import model.entities.Departamento;
import model.entities.Vendedor;

public class Program {

	public static void main(String[] args) {
		Departamento departamento = new Departamento(1, "Livros"); 
		Vendedor vendedor = new Vendedor(21, "Marcio", "Marcio@Marcio.br", new Date(), 3000.0, departamento);
		
		System.out.println(vendedor);
	}

}
