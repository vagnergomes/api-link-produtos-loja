package loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import loja.entity.Produto;
import loja.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	

	public Produto save(Produto produto) {
		return repository.save(produto);
	}
	
	public List<Produto> getProdutos(){
		return repository.findAll();
	}
	
	public Page<Produto> getProdutosPage(Pageable pageable){
		return repository.findAll(pageable);
	}
	
	public Produto update(Produto produto) {
		Produto existingProduto = repository.findById(produto.getId_produto()).orElse(null);
		existingProduto.setNome_produto(produto.getNome_produto());
		existingProduto.setDesc_produto(produto.getDesc_produto());
		existingProduto.setValor(produto.getValor());
		existingProduto.setImg(produto.getImg());
		existingProduto.setPromocao(produto.isPromocao());
		existingProduto.setAux1(produto.getAux1());
		existingProduto.setAux2(produto.getAux2());
		existingProduto.setAux3(produto.getAux3());
		existingProduto.setAux4(produto.getAux4());
		return repository.save(existingProduto);
	}
	
	public Produto findById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public String delete(int id) {
		repository.deleteById(id);
		return "Deletado";
	}
}
