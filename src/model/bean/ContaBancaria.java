package model.bean;

public class ContaBancaria { 
	private int id;
	private String agencia ;
	private String conta;
	private String nome;
	private boolean corrente_Poupa�a;
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
	public boolean isCorrente_Poupa�a() {
		return corrente_Poupa�a;
	}
	public void setCorrente_Poupa�a(boolean corrente_Poupa�a) {
		this.corrente_Poupa�a = corrente_Poupa�a;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
}
