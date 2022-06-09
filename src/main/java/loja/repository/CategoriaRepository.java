package loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import loja.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
