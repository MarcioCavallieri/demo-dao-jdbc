package model.dao;

import java.util.List;

import model.entities.Departamento;

public interface DepartamentoDao {
 	void Inserir(Departamento d);
 	void Atualizar(Departamento d);
 	void DeletarPeloId(Integer id);
 	Departamento ObterPeloId(Integer id);
 	List<Departamento> ObterTodos();
}
