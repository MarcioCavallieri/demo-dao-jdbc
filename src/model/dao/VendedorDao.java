package model.dao;

import java.util.List;
import model.entities.Departamento;
import model.entities.Vendedor;

public interface VendedorDao {
	void Inserir(Vendedor v);
 	void Atualizar(Vendedor v);
 	void DeletarPeloId(Integer id);
 	Vendedor ObterPeloId(Integer id);
 	List<Vendedor> ObterPorDepartamento(Departamento d);
 	List<Vendedor> ObterTodos();
}
