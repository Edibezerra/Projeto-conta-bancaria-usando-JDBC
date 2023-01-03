package controller;

import dao.ContaDAO;
import dao.impl.ContaDAOImpl;
import model.Conta;
import model.util.Conexao;

public class Principal {

	public static void main(String[] args) {

//		============Conta================

		Conexao conexao = new Conexao();
//		conn = conexao.getConnection();

		ContaDAO contaDAO = new ContaDAOImpl();
		Conta conta = new Conta();
//		
		conta.setNumero(11);
		conta.setSaldo(500.0);
		conta.setLimite(1000.0);
		contaDAO.salvar(conta);

//		conta.setNumero(6878);
//		conta.setSaldo(50.0);
//		conta.setLimite(200.0);
//		contaDAO.alterar(conta);
//		
//		contaDAO.remover(6878);

//		Conta conta1 = contaDAO.pesquisar(6878);
//		System.out.println(conta1.toString());
//		
//		List<Conta> listaConta = contaDAO.listartodos();
//		for (Conta c : listaConta) {
//			System.out.println(c.toString());
//		}
//	}
////}

//		=============Endereço==========================

//		
//		EnderecoDAO enderecoDAO = new EnderecoDAOImpl();				
//		Endereco endereco = new Endereco();
//		
//		endereco.setId(200);
//		endereco.setNumero(10);
//		endereco.setRua("Av Norte");
//		endereco.setComplemento("apt");
//		enderecoDAO.salvar(endereco);

//		endereco.setId(200);
//		endereco.setNumero(58);
//		endereco.setRua("Av 1");
//		endereco.setComplemento("CS");
//		enderecoDAO.alterar(endereco);

//		enderecoDAO.remover(85);

//		Endereco endereco2 = enderecoDAO.pesquisar(200);
//		System.out.println(endereco2.toString());
//		
//		List<Endereco> listarEndereco = enderecoDAO.listarTodos();
//		for (Endereco c : listarEndereco) {
//			System.out.println(c.toString());
//		}

//		============Pessoa=====================

//		EnderecoDAO enderecoDAO = new EnderecoDAOImpl();
//		PessoaDAO pessoaDAO = new PessoaDAOImpl();						
//		ContaDAO contaDAO = new ContaDAOImpl();
//		
//		Pessoa pessoa = new Pessoa();
//		Endereco endereco = new Endereco();
//		Conta conta = new Conta();
//		
//		endereco.setId(enderecoDAO.getSequence());
//		endereco.setNumero(90);
//		endereco.setRua("Rua da paz");
//		endereco.setComplemento("CS");
//		
//		
//		conta.setNumero(9000);
//		conta.setSaldo(400.0);
//		conta.setLimite(200.0);
//						
//		
//		pessoa.setEndereco(endereco);
//		pessoa.setConta(conta);
//		
//		pessoa.setNome("Perola");
//		pessoa.setSexo("M");
//		pessoa.setIdade(06);
//		pessoa.setEndereco(endereco2);
//		pessoa.setCpf("02369787489");
//		pessoa.getEndereco().getId();
//		pessoa.getConta().getNumero();
////				
//		pessoa.setConta(conta1);
//		System.out.println("Id do endereço: " + pessoa.getEndereco().getId());
//		System.out.println(pessoa.toString());
//		
//		pessoaDAO.salvar(pessoa);

//		=================ALTERAR======================		

//		pessoa.setNome("Ric");
//		pessoa.setCpf("0236978748");
//		pessoa.setSexo("H");
//		pessoa.setIdade(02);
//		pessoa.getEndereco().getId();
//		pessoa.getConta().getNumero();

//		pessoaDAO.salvar(pessoa);
//		pessoaDAO.alterar(pessoa);

//		pessoaDAO.remover("02369787487");
//		
//		PessoaDAO pessoaDAO = new PessoaDAOImpl();						
//		Pessoa pessoa = new Pessoa();

//		Pessoa pessoa2 = pessoaDAO.pesquisar("12345678910");
//		System.out.println(pessoa2.toString());

		// List<Pessoa> listaPessoa = pessoaDAO.listaTodos();
		// for (Pessoa c : listaPessoa) {
		// System.out.println(c.toString());

//		
//		pessoaDAO.remover("02369787489");

	}
}
