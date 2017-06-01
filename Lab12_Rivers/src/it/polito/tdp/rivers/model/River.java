package it.polito.tdp.rivers.model;

import java.util.List;

public class River {
int id;
String nome;
List<Flow> flows;

public List<Flow> getFlows() {
	return flows;
}

public void setFlows(List<Flow> flows) {
	this.flows = flows;
}

public River(int id, String nome) {
	this.id=id;
	this.nome=nome;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	River other = (River) obj;
	if (id != other.id)
		return false;
	if (nome == null) {
		if (other.nome != null)
			return false;
	} else if (!nome.equals(other.nome))
		return false;
	return true;
}
@Override
public String toString() {
	return  nome;
}

}
