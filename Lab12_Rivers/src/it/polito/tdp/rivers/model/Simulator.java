package it.polito.tdp.rivers.model;
import java.util.PriorityQueue;

import it.polito.tdp.rivers.model.Event.EventType;



public class Simulator {
	PriorityQueue<Event>  queue;
	private Statistiche statistiche;
	float Q;
	float flussoMedio;
	float C;

	public Simulator(int fattoreScala,float FlussoMedio,River river) {
		this.queue=new PriorityQueue<Event>();
		statistiche=new Statistiche();
		this.flussoMedio=FlussoMedio*24*36000;
		this.Q=fattoreScala*flussoMedio*30;
		this.C=Q/2;
		this.addEvent(river);
	}

	public void addEvent(River river){
		int count=0;
		for(Flow flow: river.getFlows()){
			queue.add(new Event(flow,EventType.FLUSSO_IN));
			count++;
		}
		    statistiche.setTotaleGiorni(count);
	}
	
	
	
	public void run() {
		while(!queue.isEmpty()) {
			Event e = queue.poll() ;
			
			switch(e.getType()) {
			case FLUSSO_IN:
			     this.calcolaSimulatore(e.getFlow());
	        }
		}
	}

	private void calcolaSimulatore(Flow flow) {
		
		float flusso_out;
		float flusso_in=flow.getFlow()*3600*24; //lo voglio in giorni(era espresso in secondi)
		float flussoMin=(float) (flussoMedio*0.8); 
		float probabilita=(float) Math.random();
		
		if(probabilita>1-0.05){
			flusso_out=10*flussoMin;
		}
		else{
			flusso_out=(float) (flussoMin+Math.random());
		}
		
		C+=flusso_in;
		
		if(C>Q){
			C=Q;
			statistiche.setOccupazioneTotale(statistiche.getOccupazioneTotale()+C);
			}
		if (C < flusso_out)
		{
			statistiche.setNumeroTotGiorniInsoddisfatti(statistiche.getNumeroTotGiorniInsoddisfatti()+1);
			C = 0;
	    }
		else {
			 	// Faccio uscire la quantità giornaliera
			 				   C -=flusso_out;
			 				statistiche.setOccupazioneTotale(statistiche.getOccupazioneTotale()+C);
			 }
			 
			
	}

	public Statistiche getStatistiche() {
		    return statistiche;
		
	}
			  
		
}
