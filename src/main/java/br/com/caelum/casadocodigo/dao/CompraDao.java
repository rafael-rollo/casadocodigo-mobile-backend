package br.com.caelum.casadocodigo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.caelum.casadocodigo.modelo.Compra;
import br.com.caelum.casadocodigo.modelo.Usuario;

@Repository
public class CompraDao {

	@PersistenceContext
	EntityManager entityManager;
	
	public void registraCompra(Compra compra) {
		entityManager.persist(compra);
	}

	@SuppressWarnings("unchecked")
	public List<Compra> listaCompras(Usuario usuario) {
		
		Query query = entityManager
				.createQuery("select c from Compra as c inner join fetch c.itens "
						+ "where c.usuario = :usuarioInformado");
		query.setParameter("usuarioInformado", usuario);
		return query.getResultList();
	}

}
