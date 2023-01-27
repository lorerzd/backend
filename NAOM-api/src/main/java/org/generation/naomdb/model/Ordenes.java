package org.generation.naomdb.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ordenes")
public class Ordenes {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private int cantidad;
	@Column(name="precio_total", nullable=false)
	private BigDecimal precioTotal;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST) 
	@JoinTable( name = "ordenes_has_products", joinColumns = 
	@JoinColumn( name = "Ordenes_id", referencedColumnName = "id"), inverseJoinColumns = 
	@JoinColumn( name = "Productos_id", referencedColumnName = "id")) 
	private List<Producto> productos;
	
	@ManyToMany(fetch = FetchType.LAZY) @JoinColumn(name = "Usuario_id") 
	private Usuario usuario; 
	
	public Ordenes() {
	}

	public Ordenes(int cantidad, BigDecimal preciototal, List<Producto> productos, Usuario usuario) {
		this.cantidad = cantidad;
		this.precioTotal = preciototal;
		this.productos = productos;
		this.usuario = usuario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPreciototal() {
		return precioTotal;
	}

	public void setPreciototal(BigDecimal preciototal) {
		this.precioTotal = preciototal;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Ordenes [id=" + id + ", cantidad=" + cantidad + ", preciototal=" + precioTotal + ", productos="
				+ productos + ", usuario=" + usuario + "]";
	}
	
	
	
	
	
}
