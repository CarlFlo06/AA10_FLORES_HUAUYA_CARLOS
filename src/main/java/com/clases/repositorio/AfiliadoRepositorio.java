package com.clases.repositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clases.modelo.Afiliado;
@Repository
public interface AfiliadoRepositorio extends JpaRepository<Afiliado, Long> {
	
	@Query("SELECT a FROM Afiliado a WHERE " + " CONCAT(a.numeroDocumento, a.tipoDocumento) "+" LIKE %?1%")
	public Page<Afiliado> findByNumeroDocumento(String numeroDocumento, Pageable pageable);
	//public List<Afiliado> findByNumeroDocumento(String numeroDocumento);
}
