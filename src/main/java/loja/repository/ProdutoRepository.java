package loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import loja.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
