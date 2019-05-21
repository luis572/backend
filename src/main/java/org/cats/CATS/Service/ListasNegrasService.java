package org.cats.CATS.Service;

import org.cats.CATS.Entities.ListasNegras;
import org.cats.CATS.Repository.ListasNegrasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListasNegrasService {
	@Autowired
	ListasNegrasRepository per;

	public void addLista(ListasNegras lis) {
		per.save(lis);
	}
	public ListasNegras getTransaccionByCedula(String cedula) {
		Iterable<ListasNegras> trans =per.findAll();
		for(ListasNegras u: trans) {
			if(u.getCedula().equals(cedula)) {
				return u;
			}
		}
		return null;
	}



	
}