package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DBException;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class VendedorDaoJDBC implements VendedorDao {
	private Connection conexao;
	
	public VendedorDaoJDBC(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public void Inserir(Vendedor v) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Atualizar(Vendedor v) {
		// TODO Auto-generated method stub

	}

	@Override
	public void DeletarPeloId(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vendedor ObterPeloId(Integer id) {
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null;
				
		try {
			preparedStatement = conexao.prepareStatement(
					"SELECT " + 
					"  V.*, " +
					"  D.nome AS departamento_nome" +
					"FROM " +
					"  vendedor AS V" +
					"INNER JOIN Departamento AS D" +
					"  ON (V.departamento_id = D.id)" +
					"WHERE" +
					"  (V.id = ?)");
			
			preparedStatement.setInt(0, id);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				Departamento dep = instanciarDeparamento(resultSet);
				Vendedor vend = instanciarVendedor(resultSet, dep);
				
				return vend;
			}
			
			return null;
		} catch (SQLException e){
			throw new DBException(e.getMessage());
		}finally {
			DB.fecharPreparedStatement(preparedStatement);
			DB.fecharResultSet(resultSet);
		}
	}

	private Vendedor instanciarVendedor(ResultSet resultSet, Departamento dep) throws SQLException {
		Vendedor vend = new Vendedor();
		vend.setId(resultSet.getInt("id"));
		vend.setNome(resultSet.getString("nome"));
		vend.setEmail(resultSet.getString("email"));
		vend.setDataNascimento(resultSet.getDate("data_nascimento"));
		vend.setSalarioBase(resultSet.getDouble("salario_base"));
		vend.setDepartamento(dep);
		
		return vend;
	}

	private Departamento instanciarDeparamento(ResultSet resultSet) throws SQLException {
		Departamento dep = new Departamento();
		dep.setId(resultSet.getInt("departamento_id"));
		dep.setNome(resultSet.getString("departamento_nome"));
		
		return dep;
	}

	@Override
	public List<Vendedor> ObterTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
