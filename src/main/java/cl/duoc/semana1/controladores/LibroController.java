package cl.duoc.semana1.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.semana1.entidades.Libro;
import cl.duoc.semana1.servicios.LibroService;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;

    //Metodos de solicitudes http
    @GetMapping
    public List<Libro> obtenerTodosLosLibros()
    {
        return libroService.obtenerTodosLosLibros();
    }

    @GetMapping("/{id}")
    public Optional<Libro> obtenerLibroPorId(@PathVariable int id)
    {
        return libroService.obtenerLibroPorId(id);
    }

    
}
