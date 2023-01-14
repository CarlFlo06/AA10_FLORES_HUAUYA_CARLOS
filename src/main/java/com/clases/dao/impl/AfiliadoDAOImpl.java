package com.clases.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.clases.modelo.Afiliado;
import com.clases.repositorio.AfiliadoRepositorio;
@Service
public class AfiliadoDAOImpl {
	
	@Autowired
	private AfiliadoRepositorio afiliadoRepositorio;
		
	/*public List<Afiliado> findAll(String numeroDocumento) {
		if(numeroDocumento != null) {
			return afiliadoRepositorio.findByNumeroDocumento(numeroDocumento);
		}
		return afiliadoRepositorio.findAll();
	}*/
	public Page<Afiliado> buscarNumeroDni(String numeroDocumento, Pageable pageable) {
		if(numeroDocumento != null) {
			return afiliadoRepositorio.findByNumeroDocumento(numeroDocumento,pageable);
		}
		return afiliadoRepositorio.findAll(pageable);
	}
	public void add(Afiliado afiliado) {
		
		afiliadoRepositorio.save(afiliado);
	}
	
	public Afiliado findOne(Long id) {
		return afiliadoRepositorio.findById(id).get();
	}
	
	public void delete(Long id) {
		afiliadoRepositorio.deleteById(id);
	}


}
