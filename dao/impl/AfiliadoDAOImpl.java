package com.clases.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clases.modelo.Afiliado;
import com.clases.repositorio.AfiliadoRepositorio;

@Service
public class AfiliadoDAOImpl {
	
	@Autowired
	private AfiliadoRepositorio afiliadoRepositorio;
	
	public List<Afiliado> findAll(String numeroDocumento) {
		if(numeroDocumento != null) {
			return afiliadoRepositorio.findByNumeroDocumento(numeroDocumento);
		}
		return afiliadoRepositorio.findAll();
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
