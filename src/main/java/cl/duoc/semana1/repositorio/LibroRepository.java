package cl.duoc.semana1.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duoc.semana1.entidades.Libro;

public interface LibroRepository extends JpaRepository<Libro,Integer>{
    
}
