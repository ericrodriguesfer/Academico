package ListaEncadeada;

public class Lista {
	private No primeiro;
	private int tamanho;
	
	public Lista () {
		this.primeiro = null;
		this.tamanho = 0;
	}
	
	public Lista (int tamanho, int valorInicial) {
		this.tamanho = tamanho;
		
		for (int i = 0; i < this.tamanho; i++) {
			No novoNo = new No(valorInicial, this.primeiro);
			this.primeiro = novoNo;
		}
	}
	
	public boolean inserirNoInicio (int valor) {
		No novoNo = new No(valor, this.primeiro);
		this.primeiro = novoNo;
		this.tamanho++;
		
		return true;
	}
	
	public boolean inserirEm (int valor, int indice) {
		if (this.tamanho == 0 || indice < 0 || indice > this.tamanho) {
			return false;
		} else {
			if (indice == 0) {
				No novoNo = new No(valor, this.primeiro);
				this.primeiro = novoNo;
				this.tamanho++;
				
				return true;
			} else {
				No anterior = this.no(indice - 1);
				
				if (anterior == null) {
					return false;
				} else {
					No novoNo = new No(valor, anterior.getProximo());
					anterior.setProximo(novoNo);
					
					this.tamanho++;
					
					return true;
				}
			}
		}
	}
	
	public boolean inserirNoMeio (int valor) {
		if (this.tamanho == 0) {
			No novoNo = new No(valor, this.primeiro);
			this.primeiro = novoNo;
			this.tamanho++;
			
			return true;
		} else {
			if ((this.tamanho % 2) == 0) {
				No noMeio = no(this.tamanho / 2);
				No novoNo = new No(valor, noMeio.getProximo());
				noMeio.setProximo(novoNo);
				this.tamanho++;
				
				return true;
			} else if ((this.tamanho % 2) == 1) {
				No noMeio = no((this.tamanho / 2) + 1);
				No novoNo = new No(valor, noMeio.getProximo());
				noMeio.setProximo(novoNo);
				this.tamanho++;
				
				return true;
			}
		}
		
		return false;
	}
	
	public boolean inserirNoFim (int valor) {
		if (this.tamanho == 0) {
			No novoNo = new No(valor, this.primeiro);
			this.primeiro = novoNo;
			this.tamanho++;
			
			return true;
		} else {
			No novoNO = new No(valor, null);
			No ultimoNo = this.no(this.tamanho - 1);
			ultimoNo.setProximo(novoNO);
			this.tamanho++;
			
			return true;
		}
	}
	
	public boolean remover (int valor) {
		if (this.tamanho == 0) {
			return false;
		}
		
		if (this.pertence(valor)) {
			if (this.indiceNo(valor) == Integer.MAX_VALUE) {
				return false;
			} else {
				if (this.indiceNo(valor) == 0) {
					No remover = this.no(this.indiceNo(valor));
					
					if (remover == null) {
						return false;
					} else {
						this.primeiro = remover.getProximo();
						this.tamanho--;
						remover = null;
						
						return true;
					}
				} else {
					No remover = this.no(this.indiceNo(valor));
					No anterior = this.no((this.indiceNo(valor)) - 1);
					
					if (remover == null || anterior == null) {
						return false;
					} else {
						anterior.setProximo(remover.getProximo());
						this.tamanho--;
						remover = null;
						
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean removerNoInicio () {
		if (this.tamanho == 0) {
			return false;
		} else {
			if (this.tamanho == 1) {
				this.primeiro = null;
				this.tamanho--;
				
				return true;
			} else {
				this.primeiro = this.primeiro.getProximo();
				this.tamanho--;
				
				return true;
			}
		}
	}
	
	public boolean removerEm (int indice) {
		if (this.tamanho == 0 || indice < 0 || indice > this.tamanho) {
			return false;
		} else {
			if (this.pertence(this.elementoEm(indice))) {
				if (indice == 0) {
					this.primeiro = this.primeiro.getProximo();
					this.tamanho--;
					
					return true;
				} else {
					No remover = this.no(indice);
					No anterior = this.no(indice - 1);
					
					if (remover == null || anterior == null) {
						return false;
					}
					
					anterior.setProximo(remover.getProximo());
					this.tamanho--;
					
					return true;
				}
			} else {
				return false;
			}
		}
	}
	
	public boolean removerNoFim () {
		if (this.tamanho == 0) {
			return false;
		} else {
			if (this.tamanho == 1) {
				this.primeiro = null;
				this.tamanho--;
				
				return true;
			} else {
				No penultimoNo = this.no(this.tamanho - 2);
				penultimoNo.setProximo(null);
				this.tamanho--;
				
				return true;
			}
		}
	}
	
	public boolean pertence (int valor) {
		if (this.tamanho == 0) {
			return false;
		}
		
		No no = this.primeiro;
		
		while (no != null) {
			if (no.getValor() == valor) {
				return true;
			}
			
			no = no.getProximo();
		}
		
		return false;
	}
	
	public int indiceNo (int valor) {
		if (this.tamanho == 0) {
			return Integer.MAX_VALUE;
		}
		
		int indice = 0;
		No no = this.primeiro;
		
		while (no != null) {
			if (no.getValor() == valor) {
				return indice;
			}
			
			indice++;
			no = no.getProximo();
		}
		
		return Integer.MAX_VALUE;
	}
	
	public No no (int indice) {
		if (this.tamanho == 0) {
			return null;
		}
		
		int indiceNo = 0;
		No no = this.primeiro;
		
		while (no != null) {
			if (indiceNo == indice) {
				return no;
			}
			
			indiceNo++;
			no = no.getProximo();
		}
		
		return null;
	}
	
	public int elementoEm (int indice) {
		if (this.tamanho == 0 || indice < 0 || indice > this.tamanho) {
			return Integer.MAX_VALUE;
		} else {
			int indiceBusca = 0;
			No no = this.primeiro;
			
			while (no != null) {
				if (indiceBusca == indice) {
					return no.getValor();
				}
				
				indiceBusca++;
				no = no.getProximo();
			}
		}
		
		return Integer.MAX_VALUE;
	}
	
	public void ordenar () {
		for (int i = 0; i < (this.tamanho - 1); i++) {
			for (int j = 0; j < (this.tamanho - 1); j++) {
				if (this.no(j + 1).getValor() < this.no(i).getValor()) {
					int copia = this.no(j + 1).getValor();
					this.no(j + 1).setValor(this.no(j).getValor());
					this.no(j).setValor(copia);
				}
			}
		}
	}
	
	public void exibirLista () {
		if (this.tamanho == 0) {
			return;
		}
		
		No no = this.primeiro;
		
		while (no != null) {
			System.out.print(no.getValor() + " ");
			
			no = no.getProximo();
		}
		
		System.out.println();
	}
	
	public void exibirIndices () {
		if (this.tamanho == 0) {
			return;
		}
		
		for (int i = 0; i < this.tamanho; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println();
	}
	
	public int tamanho () {
		return this.tamanho;
	}
}