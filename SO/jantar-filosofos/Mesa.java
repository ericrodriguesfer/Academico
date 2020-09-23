package JantarFilosofos;

public class Mesa {
	private boolean [] garfos;

	public Mesa() {
		this.garfos = new boolean[5];
		
		for (int i = 0; i < 5; i++) {
			this.garfos[i] = true;
		}
	}

	public boolean getGarfos(int indice) {
		return this.garfos[indice];
	}

	public void setGarfos(boolean[] garfos) {
		this.garfos = garfos;
	}
	
	public void devolveGarfo (int indice) {
		if (this.getGarfos(indice) == false) {
			this.garfos[indice] = true;
		}
	}
	
	public void pegaGarfo (int indice) {
		if (this.getGarfos(indice) == true) {
			this.garfos[indice] = false;
		}
	}
}
