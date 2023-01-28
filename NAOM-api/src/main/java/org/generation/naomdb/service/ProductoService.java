package org.generation.naomdb.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.generation.naomdb.model.Producto;
import org.generation.naomdb.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
	private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }//constructor
    
    public List<Producto> getAllProductos(){
    	return productoRepository.findAll();
    }//getAllProductos
    
    public Producto getProducto(Long id) {
    	return productoRepository.findById(id).orElseThrow(
    			()-> new IllegalArgumentException("El producto con el id "
    					+id+" no existe."));
    }//getProducto
    
    public Producto deleteProducto(Long id) {
    	Producto tmp=null;
    	if(productoRepository.existsById(id)) {
    		tmp=productoRepository.findById(id).get();
    		productoRepository.deleteById(id);
    	}//if
    	return tmp;
    }//deleteProducto
    
    public Producto addProducto(Producto producto) {
    	return productoRepository.save(producto);
    }//addProducto
    
    public Producto updateProducto(Long id, String nombre, String descripcion,
    		String foto, Double precio, int stock, BigDecimal rating) throws Exception{
    	Optional<Producto> tmp=productoRepository.findById(id);
    	if(tmp.isPresent()) {
    		tmp.get();
    		if(tmp.get().getNombre()!=null) tmp.get().setNombre(nombre);
    		if(tmp.get().getDescripcion()!=null) tmp.get().setDescripcion(descripcion);
    		if(tmp.get().getFoto()!=null) tmp.get().setFoto(foto);
    		if(tmp.get().getPrecio()!=0) tmp.get().setPrecio(precio.doubleValue());
    		if(tmp.get().getStock()!=0) tmp.get().setStock(stock);
    		if(tmp.get().getRating()!=null) tmp.get().setRating(rating);
    		productoRepository.save(tmp.get());
    	}else {
    		System.out.println("Update - El producto con el id" 
    				+id+" no existe");
    	}//if
    	throw new Exception("Error al cambiar el producto");
    }//updateProducto
}//class ProductoService