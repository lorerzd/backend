package org.generation.naomdb.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.generation.naomdb.exception.ProductoNotFound;
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

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }//getAllProductos

    public List<Producto> getTipo(Long id) throws ProductoNotFound {
        return productoRepository.findTipoProducto(id).orElseThrow(() -> new ProductoNotFound("Hola"));
    }//Maquillaje

    public Producto getProducto(Long id) {
        return productoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("El producto con el id "
                        + id + " no existe."));
    }//getProducto

    public Producto deleteProducto(Long id) {
        Producto tmp = null;
        if (productoRepository.existsById(id)) {
            tmp = productoRepository.findById(id).get();
            productoRepository.deleteById(id);
        }//if
        return tmp;
    }//deleteProducto

    public Producto addProducto(Producto producto) {
        return productoRepository.save(producto);
    }//addProducto

    public Producto updateProducto(Long id,
                                   String nombre,
                                   String descripcion,
                                   String foto,
                                   Double precio,
                                   int stock,
                                   BigDecimal rating) throws Exception {
        Optional<Producto> tmp = productoRepository.findById(id);
        if (tmp.isPresent()) {
            Producto producto = tmp.get();
            tmp.get();
            if (nombre != null) producto.setNombre(nombre);
            if (descripcion != null) producto.setDescripcion(descripcion);
            if (foto != null) producto.setFoto(foto);
            if (precio != 0) producto.setPrecio(precio);
            if (stock != 0) producto.setStock(stock);
            if (rating != null) producto.setRating(rating);
            productoRepository.save(producto);
            return producto;
        } else {
            System.out.println("Update - El producto con el id"
                    + id + " no existe");
        }//if
        throw new Exception("Error al cambiar el producto");
    }//updateProducto
}//class ProductoService