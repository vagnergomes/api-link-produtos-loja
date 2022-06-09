package loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import loja.entity.Categoria;
import loja.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	

	public Categoria save(Categoria categoria) {
		return repository.save(categoria);
	}
	
	public List<Categoria> getCategorias(){
		return repository.findAll();
	}
	
	public Page<Categoria> getCategoriasPage(Pageable pageable){
		return repository.findAll(pageable);
	}
	
	public Categoria update(Categoria categoria) {
		Categoria existingCategoria = repository.findById(categoria.getId_categoria()).orElse(null);
		existingCategoria.setNome_categoria(categoria.getNome_categoria());
		existingCategoria.setDesc_categoria(categoria.getDesc_categoria());
		
		return repository.save(existingCategoria);
	}
	
	public Categoria findById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public String delete(int id) {
		repository.deleteById(id);
		return "Deletado";
	}
	
}
