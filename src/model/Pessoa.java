package model;

public class Pessoa {
	private String nome;
	private String sexo;
	private int idade;
	private String cpf;
	private Endereco endereco;
	private Conta conta;

	public Pessoa() {

	}

	public Pessoa(String nome, String sexo, int idade, String cpf) {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", sexo=" + sexo + ",idade=" + idade + ", cpf=" + cpf + ", endereco=" + endereco
				+ ", conta=" + conta + "]";

	}
}
