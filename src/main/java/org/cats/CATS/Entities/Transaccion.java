package org.cats.CATS.Entities;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
@Entity
@Table(name="transaccion")
public class Transaccion {
	@Id
	private Long id;
	private String userto;
	private String userfrom;
	private double valortransacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserto() {
		return userto;
	}

	public void setUserto(String userto) {
		this.userto = userto;
	}

	public String getUserfrom() {
		return userfrom;
	}

	public void setUserfrom(String userfrom) {
		this.userfrom = userfrom;
	}

	public double getValortransacion() {
		return valortransacion;
	}

	public void setValortransacion(double valortransacion) {
		this.valortransacion = valortransacion;
	}
	
	
	
}
