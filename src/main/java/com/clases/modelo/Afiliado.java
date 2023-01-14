package com.clases.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Afiliado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="nombres_completos")
	private String nombresCompletos;
	@Column(name="apellido_paterno")
	private String apellidoPaterno;
	@Column(name="apellido_materno")
	private String apellidoMaterno;
	@Column(name="tipo_documento")
	private String tipoDocumento;
	@Column(name="numero_documento")
	private String numeroDocumento;
	@Column(name="direccion")
	private String direccion;
	@Column(name="email")
	private String email;
	@Column(name="telefono1")
	private String telefono1;
	@Column(name="telefono2")
	private String telefono2;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombresCompletos() {
		return nombresCompletos;
	}
	public void setNombresCompletos(String nombresCompletos) {
		this.nombresCompletos = nombresCompletos;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono1() {
		return telefono1;
	}
	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}
	public String getTelefono2() {
		return telefono2;
	}
	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	@Override
	public String toString() {
		return "Afiliado [id=" + id + ", nombresCompletos=" + nombresCompletos + ", apellidoPaternos="
				+ apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", tipoDocumento=" + tipoDocumento
				+ ", numeroDocumento=" + numeroDocumento + ", direccion=" + direccion + ", email=" + email
				+ ", telefono1=" + telefono1 + ", telefono2=" + telefono2 + "]";
	}

}
