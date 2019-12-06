package br.com.resource.webapp.livraria.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.resource.webapp.livraria.entidades.Cliente;

@Repository
public interface DaoCliente extends CrudRepository<Cliente, Integer>  {

	@Query(value="select * from cliente order by id", nativeQuery=true)
	List<Cliente> buscaClienteOrdenado();
}
