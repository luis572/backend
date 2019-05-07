package org.cats.CATS.Entities;

public class Transaccion {
	private Usuario userTo;
	private Usuario userFrom;
	private double valorTransacion;
	public Usuario getUserTo() {
		return userTo;
	}
	public void setUserTo(Usuario userTo) {
		this.userTo = userTo;
	}
	public Usuario getUserFrom() {
		return userFrom;
	}
	public void setUserFrom(Usuario userFrom) {
		this.userFrom = userFrom;
	}
	public double getValorTransacion() {
		return valorTransacion;
	}
	public void setValorTransacion(double valorTransacion) {
		this.valorTransacion = valorTransacion;
	}
	
	
}
