package cl.duoc.semana1.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.semana1.repositorio.LibroRepository;
import cl.duoc.semana1.entidades.Libro;

@Service
public class LibroService {
    
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> obtenerTodosLosLibros()
    {
        return libroRepository.findAll();
    }

    public Optional<Libro> obtenerLibroPorId(int id)
    {
        return libroRepository.findById(id);
    }

    public Libro guardarLibro(Libro libro)
    {
        return libroRepository.save(libro);
    }

    public void eliminarLibro(int id)
    {
        libroRepository.deleteById(id);
    }
}
