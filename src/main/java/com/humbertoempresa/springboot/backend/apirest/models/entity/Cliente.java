package com.humbertoempresa.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "clientes")	//esta anotacion se puede omitir cuando queremos que la tabla se llame igual que la clase entity
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(nullable = false)
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 4, max = 12, message = "el tamano tiene que estar entre 4 y 12")
	private String nombre;

	@NotEmpty(message = "No puede estar vacio")
	private String apellido;

	@NotEmpty(message = "No puede estar vacio")
	@Email(message = "Debes usar un formato de correo valido")
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	//constructores
	public Cliente() {
		
	}
	
	//getters & setters	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	//métodos
	@PrePersist			//para que la fecha de creacion se establezca justo antes de su persistencia
	public void prePersist(){
		this.createAt = new Date();
	}
}
