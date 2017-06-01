package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class Flow {
int idFlow;
LocalDate day;
float flow;
int idRiver;
public Flow(int idFlow, LocalDate localDate, float d) {
	this.idFlow=idFlow;
	this.day=localDate;
	this.flow=d;
}
public int getIdFlow() {
	return idFlow;
}
public void setIdFlow(int idFlow) {
	this.idFlow = idFlow;
}
public LocalDate getDay() {
	return day;
}
public void setDay(LocalDate day) {
	this.day = day;
}
public float getFlow() {
	return flow;
}
public void setFlow(float flow) {
	this.flow = flow;
}
public int getIdRiver() {
	return idRiver;
}
public void setIdRiver(int idRiver) {
	this.idRiver = idRiver;
}





}
