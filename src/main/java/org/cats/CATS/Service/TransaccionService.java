package org.cats.CATS.Service;

import java.util.ArrayList;
import java.util.List;

import org.cats.CATS.Entities.Transaccion;
import org.cats.CATS.Repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransaccionService {
	@Autowired
	TransaccionRepository per;

	public void addTransaccion(Transaccion tran) {
		per.save(tran);
	}

	public Transaccion getTransaccionByCorreo(String correo) {
		Iterable<Transaccion> trans =per.findAll();
		for(Transaccion u: trans) {
			if(u.getUserfrom().equals(correo)) {
				return u;
			}
		}
		return null;
	}

	public List<Transaccion> getAllTransacciones() {
		List<Transaccion> trans = new ArrayList<Transaccion>();
		Iterable<Transaccion> transi =per.findAll();
		for(Transaccion u:transi) {
			trans.add(u);
		}
		return trans;
	}

	
}
