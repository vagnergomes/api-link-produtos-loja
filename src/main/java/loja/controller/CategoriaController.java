package loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import loja.entity.Categoria;
import loja.service.CategoriaService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
@RequestMapping("categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaService service;
	
	@CrossOrigin(origins= "http://localhost:4200")
	@PostMapping("/add")
	public ResponseEntity<Categoria> add(@RequestBody Categoria cat){
		return new ResponseEntity<Categoria>(service.save(cat), HttpStatus.OK);
	}
	
	@CrossOrigin(origins= "http://localhost:4200")
	@GetMapping("/all")
	public ResponseEntity<List<Categoria>> getCategorias(){
		return new ResponseEntity<List<Categoria>>(service.getCategorias(), HttpStatus.OK);
	}
	
	@GetMapping("/all-page")
	public ResponseEntity<?> getCategoriasPage(Pageable pageable){
		return new ResponseEntity<>(service.getCategoriasPage(pageable), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable int id){
		return new ResponseEntity<Categoria>(service.findById(id),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Categoria> update(@RequestBody Categoria categoria){
		return new ResponseEntity<Categoria>(service.update(categoria), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		return new ResponseEntity<>(delete(id), HttpStatus.OK);
	}

	
}
