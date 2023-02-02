package org.generation.naomdb.controller;

import org.generation.naomdb.exception.ProductoNotFound;
import org.generation.naomdb.helper.TokenHelper;
import org.generation.naomdb.model.Producto;
import org.generation.naomdb.repository.ProductoRepository;
import org.generation.naomdb.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {
    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }//constructor

    @GetMapping //http://localhost:8080/api/productos
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }//getAllProductos

    @GetMapping(path = "/all/{tipo}")
    public List<Producto> getTipoProductos(@PathVariable("tipo") Long id) throws ProductoNotFound {
        return productoService.getTipo(id);
    }

    @GetMapping(path = "{prodId}") //http://localhost:8080/api/productos/1
    public Producto getProducto(@PathVariable("prodId") Long id) {
        return productoService.getProducto(id);
    }//getProducto

    @DeleteMapping(path = "{prodId}")
    public Producto deleteProducto(HttpServletRequest request,
                                   @PathVariable("prodId") Long id) throws ServletException {
        String token = TokenHelper.getTokenFromHeader(request);
        if(TokenHelper.getUserRole(token).equals("admin")){
            return productoService.deleteProducto(id);
        }
        throw new ServletException("Not an admin");
    }//deleteProducto

    @PostMapping
    public Producto addProducto(HttpServletRequest request,
                                @RequestBody Producto producto) throws ServletException {
        String token = TokenHelper.getTokenFromHeader(request);
        if(TokenHelper.getUserRole(token).equals("admin")){
            return productoService.addProducto(producto);
        }
        throw new ServletException("Not an admin");
    }//addProducto

    @PutMapping(path = "{prodId}")
    public Producto updateProducto(HttpServletRequest request,
                                   @PathVariable("prodId") Long id,
                                   @RequestParam(required = false) String nombre,
                                   @RequestParam(required = false) String descripcion,
                                   @RequestParam(required = false) String foto,
                                   @RequestParam(required = false) Double precio,
                                   @RequestParam(required = false) int stock,
                                   @RequestParam(required = false) BigDecimal rating) throws Exception {

        String token = TokenHelper.getTokenFromHeader(request);
        if(TokenHelper.getUserRole(token).equals("admin")){
            return productoService.updateProducto(
                    id,
                    nombre,
                    descripcion,
                    foto,
                    precio,
                    stock,
                    rating);
        }
        throw new ServletException("Not an admin");
    }//updateProducto
}//class ProductoController
