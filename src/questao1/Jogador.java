package questao1;

public class Jogador {

	String nome;
	int numero, amarelos;
	TipoPosicao posicao;
	boolean lesao, expulsao, condicaoJogo;
	
	public Jogador(String nome, int numero, TipoPosicao posicao) {
		this.nome = nome;
		this.numero = numero;
		this.amarelos = 0;
		this.posicao = posicao;
		this.lesao = false;
		this.expulsao = false;
		this.condicaoJogo = true;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public int getAmarelos() {
		return amarelos;
	}
	
	public TipoPosicao getPosicao() {
		return posicao;
	}
	
	public boolean getLesao() {
		return lesao;
	}

	public boolean getExpulsao() {
		return expulsao;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void setAmarelos(int amarelos) {
		this.amarelos = amarelos;
		if (amarelos >= 3) {
			this.expulsao = true;
			this.amarelos = 0;
		}
	}
	
	public void setPosicao(TipoPosicao posicao) {
		this.posicao = posicao;
	}
	
	public void setLesao(boolean lesao) {
		this.lesao = lesao;
	}
	
	public void setExpulsao(boolean expulsao) {
		this.expulsao = expulsao;
		
		if(expulsao) {
			this.amarelos = 0;
		}
	}
	
	public boolean isCondicaoJogo() {
		if(amarelos >= 3) {
			expulsao = true;
		}
		if(expulsao == true || lesao == true) {
			condicaoJogo = false;
		} else {
			condicaoJogo =true;
		}
		return condicaoJogo;
		
	}

}
