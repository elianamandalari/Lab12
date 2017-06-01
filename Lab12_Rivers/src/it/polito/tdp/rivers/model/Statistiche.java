package it.polito.tdp.rivers.model;

public class Statistiche {
	
	private int numeroTotGiorniInsoddisfatti=0;
	private float occupazione;
    private int count;
	public Statistiche() {
		// TODO Auto-generated constructor stub
	}


	public int getNumeroTotGiorniInsoddisfatti() {
		return numeroTotGiorniInsoddisfatti;
	}


	public void setNumeroTotGiorniInsoddisfatti(int numeroTotGiorniInsoddisfatti) {
		this.numeroTotGiorniInsoddisfatti= numeroTotGiorniInsoddisfatti;
	}


	


	public void clear() {
		this.numeroTotGiorniInsoddisfatti=0;
	   this.occupazione=0;
	   this.count=0;
		
	}
   public void setOccupazioneTotale(float occupazione){
	   this.occupazione=occupazione;
   }

	public float getOccupazioneTotale() {
		// TODO Auto-generated method stub
		return occupazione;
	}


	public void setTotaleGiorni(int count) {
		// TODO Auto-generated method stub
		this.count=count;
	}
	public int getTotaleGiorni() {
		// TODO Auto-generated method stub
		return this.count;
	}
	
}
