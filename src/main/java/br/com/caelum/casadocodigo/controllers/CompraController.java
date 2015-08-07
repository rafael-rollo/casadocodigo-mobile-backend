package br.com.caelum.casadocodigo.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.caelum.casadocodigo.dao.CompraDao;
import br.com.caelum.casadocodigo.dao.UsuarioDao;
import br.com.caelum.casadocodigo.modelo.Compra;
import br.com.caelum.casadocodigo.modelo.Usuario;

@Controller
public class CompraController {

	@Autowired
	private CompraDao compraDao;
	
	@Autowired
	private UsuarioDao usuarioDao;

	@ResponseBody
	@Transactional
	@RequestMapping(
			value = "/registrarCompra", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String registraCompra(@RequestBody Compra compra) {
		
		boolean existe = usuarioDao.isUsuario(compra.getUsuario());
		System.out.println(existe);
		if(!existe)
			usuarioDao.registraUsuario(compra.getUsuario());
		
		compraDao.registraCompra(compra);
		return "Ok";
	}
	
	@ResponseBody
	@RequestMapping(
			value="/listarCompras",
			method= RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Compra> listaCompras(Usuario usuario) {
		List<Compra> compras = compraDao.listaCompras(usuario);
		return compras;
	}
}
