package questao11;

public class Conta {
	private int numero; // número de identificação da conta
	private double saldoAtual; // saldo atual da conta
	private double saldoMinimo; // saldo mínimo da conta
	public Conta(int numero, double saldoMinimo) {
		this.numero = numero;
		this.saldoAtual = 0;
		this.saldoMinimo = saldoMinimo;
	}
	public int getNumero() {
		return numero;
	}
	public double getSaldoAtual() {
		return saldoAtual;
	}
	public double getSaldoMinimo() {
		return saldoMinimo;
	}
	public void setSaldoMinimo(double saldoMinimo) {
		this.saldoMinimo = saldoMinimo;
	}
	// realização de depósito
	public void depositar(double deposito) {
		saldoAtual += deposito;
	}
	// realização de saque
	public void sacar(double saque) throws Exception {
		// verificação de saldo futuro inferior ao saldo mínimo após saque
		if (saldoAtual - saque < saldoMinimo)
			throw new Exception("Saque leva a saldo inferior ao saldo mínimo...");
		saldoAtual -= saque; // atualização de saldo
	}
}