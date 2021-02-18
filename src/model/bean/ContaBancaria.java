package model.bean;

public class ContaBancaria { 
	private int id;
	private String agencia ;
	private String conta;
	private String nome;
	private boolean corrente_Poupaça;
	private double saldo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAgencia() {
		return agencia;
	}
	
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isCorrente_Poupaça() {
		return corrente_Poupaça;
	}
	public void setCorrente_Poupaça(boolean corrente_Poupaça) {
		this.corrente_Poupaça = corrente_Poupaça;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
}
