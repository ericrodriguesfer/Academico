package JantarFilosofos;

public class Filosofo extends Thread{
	private String nome;
	private int identificador;
	private boolean garfoMaoDireita;
	private boolean garfoMaoEsquerda;
	private boolean aindaJanta;
	private int jantando;
	private Mesa mesaJantar;

	public Filosofo() {
	}

	public Filosofo(String nome, int identificador, Mesa mesaJantar) {
		this.nome = nome;
		this.identificador = identificador;
		this.garfoMaoDireita = false;
		this.garfoMaoEsquerda = false;
		this.aindaJanta = true;
		this.jantando = 0;
		this.mesaJantar = mesaJantar;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public boolean isGarfoMaoDireita() {
		return garfoMaoDireita;
	}

	public void setGarfoMaoDireita(boolean garfoMaoDireita) {
		this.garfoMaoDireita = garfoMaoDireita;
	}

	public boolean isGarfoMaoEsquerda() {
		return garfoMaoEsquerda;
	}

	public void setGarfoMaoEsquerda(boolean garfoMaoEsquerda) {
		this.garfoMaoEsquerda = garfoMaoEsquerda;
	}

	public boolean isAindaJanta() {
		return aindaJanta;
	}

	public void setAindaJanta(boolean aindaJanta) {
		this.aindaJanta = aindaJanta;
	}

	public int getJantando() {
		return jantando;
	}

	public void setJantando(int jantando) {
		this.jantando = jantando;
	}
	
	public void pegarGarfoMaoDireita () {
		if (this.isGarfoMaoDireita() == false) {
			if (this.getIdentificador() == 1) {
				if (this.mesaJantar.getGarfos(0) == true) {
					this.setGarfoMaoDireita(true);
					this.mesaJantar.pegaGarfo(0);
				}
			} else if (this.getIdentificador() == 2) {
				if (this.mesaJantar.getGarfos(1) == true) {
					this.setGarfoMaoDireita(true);
					this.mesaJantar.pegaGarfo(1);
				}
			} else if (this.getIdentificador() == 3) {
				if (this.mesaJantar.getGarfos(2) == true) {
					this.setGarfoMaoDireita(true);
					this.mesaJantar.pegaGarfo(2);
				}
			} else if (this.getIdentificador() == 4) {
				if (this.mesaJantar.getGarfos(3) == true) {
					this.setGarfoMaoDireita(true);
					this.mesaJantar.pegaGarfo(3);
				}
			} else if (this.getIdentificador() == 5) {
				if (this.mesaJantar.getGarfos(4) == true) {
					this.setGarfoMaoDireita(true);
					this.mesaJantar.pegaGarfo(4);
				}
			}
		}
	}
	
	public void pegarGarfoMaoEsquerda () {
		if (this.isGarfoMaoEsquerda() == false) {
			if (this.getIdentificador() == 1) {
				if (this.mesaJantar.getGarfos(1) == true) {
					this.setGarfoMaoEsquerda(true);
					this.mesaJantar.pegaGarfo(1);
				}
			} else if (this.getIdentificador() == 2) {
				if (this.mesaJantar.getGarfos(2) == true) {
					this.setGarfoMaoEsquerda(true);
					this.mesaJantar.pegaGarfo(2);
				}
			} else if (this.getIdentificador() == 3) {
				if (this.mesaJantar.getGarfos(3) == true) {
					this.setGarfoMaoEsquerda(true);
					this.mesaJantar.pegaGarfo(3);
				}
			} else if (this.getIdentificador() == 4) {
				if (this.mesaJantar.getGarfos(4) == true) {
					this.setGarfoMaoEsquerda(true);
					this.mesaJantar.pegaGarfo(1);
				}
			} else if (this.getIdentificador() == 5) {
				if (this.mesaJantar.getGarfos(0) == true) {
					this.setGarfoMaoEsquerda(true);
					this.mesaJantar.pegaGarfo(0);
				}
			}
		}
	}
	
	public void soltarGarfoMaoDireita () {
		if (this.isGarfoMaoDireita() == true) {
			if (this.getIdentificador() == 1) {
				if (this.mesaJantar.getGarfos(0) == false) {
					this.setGarfoMaoDireita(false);
					this.mesaJantar.devolveGarfo(0);
				}
			} else if (this.getIdentificador() == 2) {
				if (this.mesaJantar.getGarfos(1) == false) {
					this.setGarfoMaoDireita(false);
					this.mesaJantar.devolveGarfo(1);
				}
			} else if (this.getIdentificador() == 3) {
				if (this.mesaJantar.getGarfos(2) == false) {
					this.setGarfoMaoDireita(false);
					this.mesaJantar.devolveGarfo(2);
				}
			} else if (this.getIdentificador() == 4) {
				if (this.mesaJantar.getGarfos(3) == false) {
					this.setGarfoMaoDireita(false);
					this.mesaJantar.devolveGarfo(3);
				}
			} else if (this.getIdentificador() == 5) {
				if (this.mesaJantar.getGarfos(4) == false) {
					this.setGarfoMaoDireita(false);
					this.mesaJantar.devolveGarfo(4);
				}
			}
		} 
	}
		
	public void soltarGarfoMaoEsquerda () {
		if (this.isGarfoMaoEsquerda() == true) {
			if (this.getIdentificador() == 1) {
				if (this.mesaJantar.getGarfos(1) == false) {
					this.setGarfoMaoEsquerda(false);
					this.mesaJantar.devolveGarfo(1);
				}
			} else if (this.getIdentificador() == 2) {
				if (this.mesaJantar.getGarfos(2) == false) {
					this.setGarfoMaoEsquerda(false);
					this.mesaJantar.devolveGarfo(2);
				}
			} else if (this.getIdentificador() == 3) {
				if (this.mesaJantar.getGarfos(3) == false) {
					this.setGarfoMaoEsquerda(false);
					this.mesaJantar.devolveGarfo(3);
				}
			} else if (this.getIdentificador() == 4) {
				if (this.mesaJantar.getGarfos(4) == false) {
					this.setGarfoMaoEsquerda(false);
					this.mesaJantar.devolveGarfo(4);
				}
			} else if (this.getIdentificador() == 5) {
				if (this.mesaJantar.getGarfos(0) == false) {
					this.setGarfoMaoEsquerda(false);
					this.mesaJantar.devolveGarfo(0);
				}
			}
		}
	}	
	
	public boolean podeJantar () {
		if (this.isGarfoMaoDireita() == true && this.isGarfoMaoEsquerda() == true) {
			return true;
		} else {
			if (this.isGarfoMaoDireita() == true) {
				this.soltarGarfoMaoDireita();
			}
			
			if (this.isGarfoMaoEsquerda() == true) {
				this.soltarGarfoMaoEsquerda();
			}
			
			return false;
		}
	}
	
	public void aindaPodeJantar () {
		if (this.getJantando() == 50) {
			this.setAindaJanta(false);
		}
	}
	
	public void jantando () {
		this.jantando++;
	}
	
	@Override
	public void run() {
		for (int i = 0; i <= 250; i++) {
			System.out.println(" ");
			System.out.println("###################### ITERACAO " + (i + 1) + " ######################");
			System.out.println(this.getNome() + " QUE ESTA EXECUTANDO");
			
			System.out.println(this.getNome() + " TENTANDO PEGAR O GARFO DA MAO DIREITA");
			this.pegarGarfoMaoDireita();
			
			System.out.println(this.getNome() + " TENTANDO PEGAR O GARFO DA MAO ESQUERDA");
			this.pegarGarfoMaoEsquerda();
			
			System.out.println(this.getNome() + " => " + (this.isGarfoMaoDireita() == true ? "MAO DIREITA COM GARFO" : "MAO DIREITA SEM GARFO"));
			System.out.println(this.getNome() + " => " + (this.isGarfoMaoEsquerda() == true ? "MAO ESQUERDA COM GARFO" : "MAO ESQUERDA SEM GARFO"));
			
			if (this.isAindaJanta() == true) {
				 if (this.podeJantar() == true) {
					 this.jantando();
					 
					 System.out.println(">>>> " + this.getNome() + " ESTA JANTANDO!!! <<<<");
				 } else {
					 System.out.println(this.getNome() + " NAO PODE JANTAR, NAO TINHAS OS GARFOS NA MESA");
					 System.out.println(this.getNome() + " SOLTANDO OS GARFOS NA MESA!!!");
					 
					 this.soltarGarfoMaoDireita();
					 this.soltarGarfoMaoEsquerda();
					 
					 System.out.println(">>>> " + this.getNome() + " ESTA PENSANDO!!! <<<<");
				 }
			} else {
				System.out.println(this.getNome() + " NAO PODE MAIS JANTAR!!!");
				System.out.println(">>>> " + this.getNome() + " ESTA PENSANDO!!! <<<<");
			}
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				System.out.println("ERRO!!!");
			}
			
			if (this.isAindaJanta() == true) {
				if (this.podeJantar() == true) {
					System.out.println(this.getNome() + " SOLTANDO OS GARFOS NA MESA!!!");
					
					this.soltarGarfoMaoDireita();
					this.soltarGarfoMaoEsquerda();
				}
			}
			
			this.aindaPodeJantar();
			
			System.out.println(" ");
		}
	}
}
