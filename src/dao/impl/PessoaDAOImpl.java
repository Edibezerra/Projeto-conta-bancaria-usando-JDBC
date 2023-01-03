package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ContaDAO;
import dao.EnderecoDAO;
import dao.PessoaDAO;
import model.Pessoa;
import model.util.Conexao;

public class PessoaDAOImpl implements PessoaDAO {

	Conexao conexao = new Conexao();
	EnderecoDAO enderecoDAO = new EnderecoDAOImpl();
	ContaDAO contaDAO = new ContaDAOImpl();

	@Override
	public void salvar(Pessoa pessoa) {
		Connection conn = conexao.getConnection();

		this.enderecoDAO.salvar(pessoa.getEndereco());
		this.contaDAO.salvar(pessoa.getConta());

		String sql = "INSERT INTO PESSOA( NOME, CPF, SEXO, IDADE, ID_ENDERECO, NUMERO_CONTA) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getCpf());
			ps.setString(3, pessoa.getSexo());
			ps.setInt(4, pessoa.getIdade());
			ps.setInt(5, pessoa.getEndereco().getId());
			ps.setInt(6, pessoa.getConta().getNumero());
			ps.execute();
			System.out.println("PESSOA INSERIDA COM SUCESSO");

		} catch (SQLException e) {
			System.out.println("Erro ao inserir pessoa conta no banco" + e.getMessage());

		} finally {
			conexao.fecharConexao(conn);
		}
	}

	@Override
	public void alterar(Pessoa pessoa) {
		Connection conn = conexao.getConnection();

		String sql = "UPDATE PESSOA SET NOME = ? , SEXO = ?, IDADE = ?, ID_ENDERECO = ?,"
				+ " NUMERO_CONTA = ? WHERE CPF = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getSexo());
			ps.setInt(3, pessoa.getIdade());
			ps.setInt(4, pessoa.getEndereco().getId());
			ps.setInt(5, pessoa.getConta().getNumero());
			ps.setString(6, pessoa.getCpf());
			ps.executeUpdate();

			System.out.println("PESSOA ATUALIZADA COM SUCESSO");

		} catch (SQLException e) {
			System.out.println("Erro ao inserir pessoa no banco" + e.getMessage());

		} finally {
			conexao.fecharConexao(conn);
		}
	}

	@Override
	public void remover(String cpf) {
		Connection conn = conexao.getConnection();
		Pessoa p = pesquisar(cpf);

		String sql = "DELETE FROM PESSOA WHERE CPF = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cpf);
			ps.execute();
//			enderecoDAO.remover(p.getEndereco().getId());
//			contaDAO.remover(p.getConta().getNumero());

			System.out.println("PESSOA DELETADA COM SUCESSO");

		} catch (SQLException e) {
			System.out.println("Erro ao deletar a pessoa banco" + e.getMessage());

		} finally {
			conexao.fecharConexao(conn);
		}
	}

	@Override
	public Pessoa pesquisar(String cpf) {
		Connection conn = conexao.getConnection();
		Pessoa pessoa = new Pessoa();

		String sql = "SELECT * FROM PESSOA WHERE CPF = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cpf);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				pessoa.setNome(rs.getString("NOME"));
				pessoa.setCpf(rs.getString("CPF"));
				pessoa.setSexo(rs.getString("SEXO"));
				pessoa.setIdade(rs.getInt("IDADE"));
				pessoa.setEndereco(this.enderecoDAO.pesquisar(rs.getInt("ID_ENDERECO")));
				pessoa.setConta(this.contaDAO.pesquisar(rs.getInt("NUMERO_CONTA")));
			}

		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar Pessoa" + e.getMessage());

		} finally {
			conexao.fecharConexao(conn);
		}
		return pessoa;

	}

	@Override
	public List<Pessoa> listaTodos() {
		Connection conn = conexao.getConnection();
		List<Pessoa> retorno = new ArrayList<Pessoa>();

		String sql = "SELECT * FROM PESSOA ";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(rs.getString("NOME"));
				pessoa.setCpf(rs.getString("CPF"));
				pessoa.setSexo(rs.getString("SEXO"));
				pessoa.setIdade(rs.getInt("IDADE"));
				pessoa.setEndereco(this.enderecoDAO.pesquisar(rs.getInt("ID_ENDERECO")));
				pessoa.setConta(this.contaDAO.pesquisar(rs.getInt("NUMERO_CONTA")));
				retorno.add(pessoa);

			}

		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar Pessoa" + e.getMessage());

		} finally {
			conexao.fecharConexao(conn);
		}

		return retorno;

	}

}
