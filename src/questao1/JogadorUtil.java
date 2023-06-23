package questao1;

import java.util.Scanner;

public class JogadorUtil {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int MAX = 15;
		int op;
		Jogador[] jogadores = new Jogador[MAX];
		Jogador[] lesionados = new Jogador[MAX];
		int indice = 0;
		int indLesionados = 0;

		do {
			System.out.println();
			System.out.println("---MENU---");
			System.out.println("--- 1. Adicionar jogador ao plantel ---");
			System.out.println("--- 2. Disponibilidade de plantel ---");
			System.out.println("--- 3. Registrar lesão ---");
			System.out.println("--- 4. Registrar cartão amarelo ---");
			System.out.println("--- 5. Registrar recuperação de lesão ---");
			System.out.println("--- 6. Registrar expulsão ---");
			System.out.println("--- 7. Encerrar ---");
			System.out.println("----------");
			System.out.println();
			
			System.out.print("Operação (1 - 6): ");
			op = scanner.nextInt();
			scanner.nextLine();
			
			switch(op) {
			case 1:
				if(indice == MAX) {
					System.out.println("Limite de 15 jogadores já foi alcançado!");
				} else {
					System.out.print("Qual o nome do jogador? ");
					String nome = scanner.nextLine();
					System.out.print("Qual o número do jogador? ");
					int numero = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Em que posição ele joga (Goleiro/Defensor/MeioCampista/Atacante)? ");
					String posicaoStr = scanner.nextLine();
					TipoPosicao posicao = TipoPosicao.valueOf(posicaoStr.toUpperCase());
					
					Jogador jogador = new Jogador(nome, numero, posicao);
					jogadores[indice] = jogador;
					indice++;
					System.out.println("Jogador adicionado ao plantel!\n");
				}
				break;
				
			case 2:
				int jogadoresDisponiveis = 0;
			    for (Jogador jogador : jogadores) {
			        if (jogador != null && jogador.isCondicaoJogo()) {
			            jogadoresDisponiveis++;
			        }
			    }
			    
			    if (jogadoresDisponiveis >= 11) {
			        System.out.println("O time possui 11 jogadores disponíveis!");
			    } else {
			        System.err.println("O time não possui 11 jogadores disponíveis!");
			    }
			    System.err.println("Quantidade de jogadores disponíveis: " + jogadoresDisponiveis);
			    break;
				
			case 3:
				System.out.println("Qual dos seguintes jogadores foi lesionado?");
				for (Jogador jogador : jogadores) {
					if (jogador != null) {
						System.out.println(jogador.getNome());
					}
				}
				
				String nomeLesionado = scanner.nextLine();
				Jogador jogadorLesionado = null;

				for (Jogador jogador : jogadores) {
					if (jogador != null && jogador.getNome().equalsIgnoreCase(nomeLesionado)) {
						jogadorLesionado = jogador;
						jogadorLesionado.setLesao(true);
						break;
					}
				}

				if (jogadorLesionado != null) {
					lesionados[indLesionados] = jogadorLesionado;
					indLesionados++;
					System.out.println("Jogador lesionado registrado!");
				} else {
					System.out.println("Jogador não encontrado.");
				}
				break;
				
			case 4:
			    System.out.println("Qual dos seguintes jogadores tomou cartão amarelo?");
			    for (Jogador jogador : jogadores) {
			        if (jogador != null) {
			            System.out.println(jogador.getNome());
			        }
			    }
			    String nomeAmarelo = scanner.nextLine();

			    for (Jogador jogador : jogadores) {
			        if (jogador != null && jogador.getNome().equalsIgnoreCase(nomeAmarelo)) {
			            jogador.setAmarelos(jogador.getAmarelos() + 1);

			            if (jogador.getAmarelos() == 3) {
			                jogador.setExpulsao(true);
			                jogador.setAmarelos(0);
			            }

			            break;
			        }
			    }
			    break;
				
			case 5:
				System.out.println("Qual dos seguintes jogadores se recuperou de lesao?");
				for (Jogador jogador : lesionados) {
					if (jogador != null) {
						System.out.println(jogador.getNome());
					}
				}
				String nomeRecuperado = scanner.nextLine();
				Jogador jogadorRecuperado = null;

				for (Jogador jogador : lesionados) {
					if (jogador != null && jogador.getNome().equalsIgnoreCase(nomeRecuperado)) {
						jogadorRecuperado = jogador;
						break;
					}
				}

				if (jogadorRecuperado != null) {
					for (int i = 0; i < indLesionados; i++) {
				        if (lesionados[i] == jogadorRecuperado) {
				            lesionados[i] = null;
				            break;
				        }
				    }
					indLesionados--;
					System.out.println("Jogador recuperado registrado!");
				} else {
					System.out.println("Jogador não encontrado.");
				}
				break;
				
			case 6:
				System.out.println("Qual dos seguintes jogadores foi expulso?");
				for (Jogador jogador : jogadores) {
					if (jogador != null) {
						System.out.println(jogador.getNome());
					}
				}
				String nomeExpulso = scanner.nextLine();
				Jogador jogadorExpulso = null;
				
				for (Jogador jogador : jogadores) {
					if (jogador != null && jogador.getNome().equalsIgnoreCase(nomeExpulso)) {
						jogadorExpulso = jogador;
						jogadorExpulso.setExpulsao(true);
						break;
					}
					
				}
				
			}
			
		}while(op != 7);
		System.out.println("Programa encerrando...");
		scanner.close();
	}

}
