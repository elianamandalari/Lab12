package it.polito.tdp.rivers.model;

import it.polito.tdp.rivers.model.Event.EventType;

public class Event implements Comparable<Event> {
	
	
	public enum EventType {FLUSSO_IN } ;	
    private EventType type ;
    private Flow flow;
   
  
	public Event(EventType type,Flow flow) {
	    this.type=type;
		this.flow=flow;
	
	}


	public Event(Flow flow, EventType type) {
		this.flow=flow;
		this.type=type;
	}


	public EventType getType() {
		return type;
	}


	public void setType(EventType type) {
		this.type = type;
	}


	public Flow getFlow() {
		return flow;
	}


	public void setFlow(Flow flow) {
		this.flow = flow;
	}


	@Override
	public int compareTo(Event other) {
		if(this.flow.getDay().isAfter(other.getFlow().getDay()))
		    return 1;
		else{
			if(this.flow.getDay().isBefore(other.getFlow().getDay()))
				return -1;
			else
				return 0;
		}
	}



	

	
}
