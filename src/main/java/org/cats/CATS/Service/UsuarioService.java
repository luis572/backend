package org.cats.CATS.Service;

import java.util.ArrayList;
import java.util.List;

import org.cats.CATS.Entities.Usuario;
import org.cats.CATS.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository per;

	public void addUser(Usuario user) {
		per.save(user);
	}

	public Usuario getUserByCedula(String cedula) {
		//List<Usuario> userss = new ArrayList<Usuario>();
		Iterable<Usuario> users =per.findAll();
		for(Usuario u: users) {
			if(u.getCedula().equals(cedula)) {
				return u;
			}
		}
		
		return null;
	}

	public List<Usuario> getAllUsuarios() {
		// TODO Auto-generated method stub
		List<Usuario> users = new ArrayList<Usuario>();
		Iterable<Usuario> usersa =per.findAll();
		for(Usuario u:usersa) {
			users.add(u);
			
		}
		return users;
	}

	public Usuario getUserByCorreo(String correo) {
		// TODO Auto-generated method stub
		Iterable<Usuario> users =per.findAll();
		for(Usuario u: users) {
			if(u.getCorreo().equals(correo)) {
				return u;
			}
		}
		
		return null;
	}
	public void updateUser(String correo,Long montoa) {
		Usuario user = null;
	
		Iterable<Usuario> users =per.findAll();
		for(Usuario u: users) {
			if(u.getCorreo().equals(correo)) {
				user=u;
			}
		}
		per.delete(user);
		Long monto = user.getMonto()+montoa;
		user.setMonto(monto);
		per.save(user);
		
	}
	
	
	
}
