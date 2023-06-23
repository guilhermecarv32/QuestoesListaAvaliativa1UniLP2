package questao11;

import java.util.Scanner;

public class ContaUtil {

	private static Conta[] contas = new Conta[10];
	private static int contador = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int opcao;
		do {
			System.out.println("Selecione uma opção:");
			System.out.println("1 - Inserir nova conta");
			System.out.println("2 - Listar contas");
			System.out.println("3 - Encerrar programa");
			opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				try {
					inserirConta(scanner);
				} catch (RuntimeException e) {
					System.out.println("Erro: " + e.getMessage());
				}
				break;
			case 2:
				listarContas();
				break;
			case 3:
				encerrarPrograma();
				break;
			default:
				System.out.println("Opção inválida!");
			}
		} while (opcao != 3);
	}

	private static void inserirConta(Scanner scanner) {
		if (contador >= contas.length) {
			throw new RuntimeException("Não é possível adicionar mais contas. O limite de contas foi atingido.");
		}

		System.out.print("Número da conta: ");
		int numero = scanner.nextInt();

		if (contaExiste(numero)) {
			throw new RuntimeException("Já existe uma conta com esse número.");
		}

		System.out.print("Saldo mínimo: ");
		double saldoMinimo = scanner.nextDouble();

		System.out.print("Valor inicial a ser depositado: ");
		double valorInicial = scanner.nextDouble();

		Conta novaConta = new Conta(numero, saldoMinimo);
		novaConta.depositar(valorInicial);

		contas[contador] = novaConta;
		contador++;
		System.out.println("Conta adicionada com sucesso!");
	}

	private static void listarContas() {
		if (contador == 0) {
			System.out.println("Nenhuma conta cadastrada.");
			return;
		}

		for (int i = 0; i < contador; i++) {
			System.out.println("Conta " + contas[i].getNumero() + " - Saldo: " + contas[i].getSaldoAtual());
		}
	}

	private static void encerrarPrograma() {
		System.out.println("Programa encerrado.");
	}

	private static boolean contaExiste(int numero) {
		for (int i = 0; i < contador; i++) {
			if (contas[i].getNumero() == numero) {
				return true;
			}
		}
		return false;
	}
}
