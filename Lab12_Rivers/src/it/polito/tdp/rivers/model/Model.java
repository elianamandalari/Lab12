package it.polito.tdp.rivers.model;

import java.time.LocalDate;
import java.util.*;

import it.polito.tdp.rivers.db.RiversDAO;
import javafx.event.Event;

public class Model {
List<River> rivers;
List<Flow> flows;
Simulator simulatore;



	public List<River> getAllRivers() {
		if(this.rivers==null){
			RiversDAO dao=new RiversDAO();
			this.rivers=dao.getAllRivers();
		}
		return this.rivers;
	}

 public List<Flow> getAllFlows (River river){
	 if(this.flows==null){
			RiversDAO dao=new RiversDAO();
			this.flows=dao.getAllFlows(river);
		}
		return this.flows;
 }

	public LocalDate getDataFirst(River river) {
		// TODO Auto-generated method stub
		return this.getAllFlows(river).get(0).getDay();
	}



	public LocalDate getDataLast(River river) {
		// TODO Auto-generated method stub
		int size=this.flows.size();
		   return this.getAllFlows(river).get(size-1).getDay();
	}



	
	public float getFlussoMedio(River river){
		List<Flow> flows=getAllFlows(river);
		float flussoMedio=0;
		
	    for(Flow f: flows)
		  flussoMedio+=f.getFlow()/(flows.size());
	    
		return flussoMedio;
	}

	public Statistiche getStatistiche(int fattoreScala,River river) {		
			float flussoMedio=this.getFlussoMedio(river);
			simulatore=new Simulator(fattoreScala,flussoMedio,river);
			simulatore.run();
			return simulatore.getStatistiche();
		}
	}

	

	
	
	
	


