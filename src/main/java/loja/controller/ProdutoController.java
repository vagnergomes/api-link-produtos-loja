package loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import loja.entity.Produto;
import loja.service.ProdutoService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@PostMapping("/add")
	public ResponseEntity<Produto> add(@RequestBody Produto prod){
		return new ResponseEntity<Produto>(service.save(prod), HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Produto>> getProdutos(){
		return new ResponseEntity<List<Produto>>(service.getProdutos(), HttpStatus.OK);
	}
	
	@GetMapping("/all-page")
	public ResponseEntity<?> getProdutosPage(Pageable pageable){
		return new ResponseEntity<>(service.getProdutosPage(pageable), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable int id){
		return new ResponseEntity<Produto>(service.findById(id),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Produto> update(@RequestBody Produto prod){
		return new ResponseEntity<Produto>(service.update(prod), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		return new ResponseEntity<>(delete(id), HttpStatus.OK);
	}

	
}
