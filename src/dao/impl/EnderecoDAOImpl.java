package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.EnderecoDAO;
import model.Conta;
import model.Endereco;
import model.util.Conexao;

public class EnderecoDAOImpl implements EnderecoDAO {
	Conexao conexao = new Conexao();

	@Override
	public int getSequence() {
		Connection conn = conexao.getConnection();
		Integer retorno = null;
		
		String sql = "SELECT S_ID_ENDERECO.NEXTVAL AS SEQUENCE FROM DUAL";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				retorno = rs.getInt("SEQUENCE");
			}
		} catch (Exception e) {
			System.out.println("Erro ao inserir a sequence" + e.getMessage());
			
		} finally {
			conexao.fecharConexao(conn);
		}
					
		return retorno;
	}

	@Override
	public void salvar(Endereco endereco) {
		Connection conn = conexao.getConnection();

		String sql = "INSERT INTO ENDERECO(ID_ENDERECO, NUMERO, RUA, COMPLEMENTO) " + "VALUES(?, ?, ?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, endereco.getId());
			ps.setInt(2, endereco.getNumero());
			ps.setString(3, endereco.getRua());
			ps.setString(4, endereco.getComplemento());
			ps.execute();
			System.out.println("ENDERECO INSERIDO COM SUCESSO");

		} catch (SQLException e) {
			System.out.println("Erro ao inserir O ENDEREÇO" + e.getMessage());

		} finally {
			conexao.fecharConexao(conn);
		}
	}

	

	@Override
	public void alterar(Endereco endereco) {
		Connection conn = conexao.getConnection();

		String sql ="UPDATE ENDERECO SET NUMERO = ? , RUA = ? , COMPLEMENTO = ? WHERE  ID_ENDERECO = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, endereco.getNumero());
			ps.setString(2, endereco.getRua());
			ps.setString(3, endereco.getComplemento());
			ps.setInt(4, endereco.getId());
			ps.executeUpdate();
		
			System.out.println("Endereço atualizada com sucesso");

		} catch (Exception e) {
			System.out.println("Erro ao atualizar endereço no banco" + e.getMessage());

		} finally {
			conexao.fecharConexao(conn);
		}

	}

	@Override
	public void remover(int id) {
		Connection conn = conexao.getConnection();

		String sql = "DELETE FROM ENDERECO WHERE ID_ENDERECO = ?" ;

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			System.out.println("Endereço deletada com sucesso");

		} catch (SQLException e) {
			System.out.println("Erro ao Deletar endereço no banco" + e.getMessage());

		} catch (Exception e) {
			System.out.println("Erro ao deletar conta no banco" + e.getMessage());

		} finally {
			conexao.fecharConexao(conn);
	}
}
	
	@Override
	public Endereco pesquisar(Integer id) {
		Connection conn = conexao.getConnection();
		Endereco endereco = new Endereco();
		
		String sql = "SELECT * FROM ENDERECO WHERE ID_ENDERECO = ? ";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				endereco.setId(rs.getInt("id_endereco"));
				endereco.setNumero(rs.getInt("numero"));
				endereco.setRua(rs.getString("rua"));
				endereco.setComplemento(rs.getString("complemento"));
				
			}
		} catch (Exception e) {
			System.out.println(" Erro ao pesquisar endereço no banco " + e.getMessage());	
				
		} finally {
			conexao.fecharConexao(conn);
		}
				
		return endereco;
	}


	@Override
	public List<Endereco> listarTodos() {
		Connection conn = conexao.getConnection();
		List<Endereco> retorno = new ArrayList<Endereco>();
	
		String sql = "SELECT * FROM ENDERECO";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Endereco endereco = new Endereco();
				endereco.setId(rs.getInt("id_endereco"));
				endereco.setNumero(rs.getInt("numero"));
				endereco.setRua(rs.getString("rua"));
				endereco.setComplemento(rs.getString("complemento"));
				retorno.add(endereco);
			}
		} catch (Exception e) {
			System.out.println(" Erro ao pesquisar endereco " + e.getMessage());	
				
		} finally {
			conexao.fecharConexao(conn);
		}	
					
		return retorno;
	}	
		
}

