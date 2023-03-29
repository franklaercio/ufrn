package tdd;

import java.util.ArrayList;
import java.util.List;

import banco.Conta;
import banco.OperacaoIlegalException;

public class ContaCorrente extends Conta {

	private String nome;
	
	private double saldoInicial;

	private List<Deposito> depositos = new ArrayList<>();

	public ContaCorrente(String nome) {
		super("123", 0.0);
		this.nome = nome;
		this.saldoInicial = 0.0;
	}

	public ContaCorrente(String nome, String codigo, double saldo) {
		super(codigo, saldo);
		this.nome = nome;
		this.saldoInicial = 0.0;
	}

	public ContaCorrente(String codigo, double saldo) {
		super(codigo, saldo);
		this.saldoInicial = 0.0;
	}

	public ContaCorrente(int saldo) {
		super("123", saldo);
		this.saldoInicial = 0.0;
	}

	public void creditar(Deposito deposito) throws OperacaoIlegalException {
		if (deposito.valor > 0) {
			creditar(deposito.valor);
			depositos.add(deposito);
		} else {
			throw new OperacaoIlegalException();
		}
	}

	public String extrato() {
		String extrato = "Conta de " + nome + "\n" +
				"Saldo Inicial $" + getSaldoInicial() + "\n" +
				"Saldo Final $" + getSaldo() + "\n";
				
		if(depositos.isEmpty()) {
			extrato += "Nenhuma trasacao realizada\n";
			
		} else {
			for (Deposito deposito : depositos) {
				extrato += deposito.data() + "\tDeposito\t$" + deposito.valor() + "\n";
			}
		}
				
		return extrato;		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Deposito> getDepositos() {
		return depositos;
	}

	public void setDepositos(List<Deposito> depositos) {
		this.depositos = depositos;
	}

	public double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

}
