package br.edu.up.cadastro.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.up.cadastro.entity.Endereco;
import br.edu.up.cadastro.repository.EnderecoRepository;

@RestController
@RequestMapping("endereco")
public class EnderecoController {
	@Autowired
	private EnderecoRepository repository; 
	
	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Endereco> listAll(){
		Iterable<Endereco> list = repository.findAll();
		return list;
		
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Endereco getById(@PathVariable Integer id) {
		Endereco endereco = repository.getOne(id);
		return endereco;		
	}
	
	@PostMapping
	public Endereco add(@RequestBody @Valid Endereco endereco) {
		return repository.save(endereco);		
	}
	
	@DeleteMapping("/{id}")
	public Endereco delete(@PathVariable Integer id) {
		Endereco endereco = repository.getOne(id);
		repository.delete(endereco);	
		return endereco;
	}
}
