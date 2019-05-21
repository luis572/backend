package org.cats.CATS.Controller;

import java.util.List;

import org.cats.CATS.Entities.Transaccion;
import org.cats.CATS.Entities.Usuario;
import org.cats.CATS.Service.TransaccionService;
import org.cats.CATS.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/cats")
public class ControllerCATS {

	@Autowired
	UsuarioService ser;
	@Autowired
	TransaccionService transS;

	@CrossOrigin
	@GetMapping
	public ResponseEntity<?> getAllUsers() {
		if (ser.getAllUsuarios().size() == 0)
			return new ResponseEntity<>("HTTP 404", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(ser.getAllUsuarios(), HttpStatus.ACCEPTED);
	}

	@CrossOrigin
	@GetMapping("cedula/{cedula}")
	public ResponseEntity<?> getUserByCedula(@PathVariable("cedula") String cedula) {
		if (ser.getUserByCedula(cedula) == null)
			return new ResponseEntity<>("HTTP 404", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(ser.getUserByCedula(cedula), HttpStatus.ACCEPTED);

	}

	@CrossOrigin
	@GetMapping("correo/{correo}")
	public ResponseEntity<?> getUserByCorreo(@PathVariable("correo") String correo) {
		if (ser.getUserByCorreo(correo) == null)
			return new ResponseEntity<>("HTTP 404", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(ser.getUserByCorreo(correo), HttpStatus.ACCEPTED);

	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value = "/usuario")
	public @ResponseBody ResponseEntity<?> manejadorCreateUser(@RequestBody Usuario user) {
		try {
			System.out.println(user.toString());
			ser.addUser(user);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception ex) {

			return new ResponseEntity<>("No es posible crear el recurso", HttpStatus.FORBIDDEN);
		}

	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value = "/transaccion")
	public @ResponseBody ResponseEntity<?> manejadorCreatetransaccion(@RequestBody Transaccion trans) {
		try {
			transS.addTransaccion(trans);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception ex) {

			return new ResponseEntity<>("No es posible crear el recurso", HttpStatus.FORBIDDEN);
		}

	}

	@CrossOrigin
	@GetMapping("/all-transaccion")
	public ResponseEntity<?> getAllTransacciones() {
		if (transS.getAllTransacciones().size() == 0)
			return new ResponseEntity<>("HTTP 404", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(transS.getAllTransacciones(), HttpStatus.ACCEPTED);

	}
	@CrossOrigin
	@PutMapping("/update-monto/{user}/{monto}")
	public ResponseEntity<?> updateMonto(@PathVariable("user") String user,@PathVariable("monto") Long monto) {
		try {
			ser.updateUser(user, monto);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>("No es posible crear el recurso", HttpStatus.FORBIDDEN);
		}
		
	}
	@CrossOrigin
	@PutMapping("/update-monto-t/{user}/{monto}")
	public ResponseEntity<?> updateMontoT(@PathVariable("user") String user,@PathVariable("monto") Long monto) {
		try {
			ser.updateUserT(user, monto);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>("No es posible crear el recurso", HttpStatus.FORBIDDEN);
		}
		

	}
	

}
