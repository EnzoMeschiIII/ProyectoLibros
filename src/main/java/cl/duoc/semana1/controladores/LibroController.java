package cl.duoc.semana1.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping
    public ResponseEntity<Libro> guardarLibro(@RequestBody Libro libro)
    {
        Libro nuevoLibro = libroService.guardarLibro(libro);
        return ResponseEntity.ok(nuevoLibro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable int id, @RequestBody Libro libro)
    {
        Optional<Libro> libroExistente = libroService.obtenerLibroPorId(id);
        if(libroExistente.isPresent())
        {
            Libro lib = libroExistente.get();
            lib.setTitulo(libro.getTitulo());
            lib.setAutor(libro.getAutor());
            lib.setFecha(libro.getFecha());
            lib.setGenero(libro.getGenero());
            Libro libroActualizado = libroService.guardarLibro(lib);
            return ResponseEntity.ok(libroActualizado);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable int id)
    {
        Optional<Libro> libroExistente = libroService.obtenerLibroPorId(id);
        if(libroExistente.isPresent())
        {
            libroService.eliminarLibro(id);
            return ResponseEntity.ok().build();
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
