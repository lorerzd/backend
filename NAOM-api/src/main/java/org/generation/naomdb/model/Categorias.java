package org.generation.naomdb.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categorias {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true,nullable = false)
	private Long id;
	@Column(nullable = false)
	private String tipoDeProducto;
	@OneToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "Productos_id", referencedColumnName = "id") 
	private Producto producto; 
	
	
	public Categorias() {
	}

	public String getTipoDeProducto() {
		return tipoDeProducto;
	}

	public void setTipoDeProducto(String tipoDeProducto) {
		this.tipoDeProducto = tipoDeProducto;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Categorias [id=" + id + ", tipoDeProducto=" + tipoDeProducto + ", producto=" + producto + "]";
	}
	
}
