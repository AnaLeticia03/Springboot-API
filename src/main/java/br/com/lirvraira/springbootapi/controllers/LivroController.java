package br.com.lirvraira.springbootapi.controllers;

import java.util.List;

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

import br.com.lirvraira.springbootapi.model.Livro;
import br.com.lirvraira.springbootapi.repository.LivroRepository;

@RestController
@RequestMapping({ "/livros" })

public class LivroController {

    @Autowired
    private LivroRepository repository;

    LivroController(LivroRepository LivroRepository) {
        this.repository = LivroRepository;
    }

    @GetMapping // retorna todoas os livros
    public List findAll() {
        return repository.findAll();
    }

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Livro> findById(@PathVariable Integer id) {
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = { "/criar" })
    public Livro create(@RequestBody Livro livro) {
        return repository.save(livro);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Livro> update(@PathVariable("id") Integer id, @RequestBody Livro livro) {
        return repository.findById(id).map(record -> {
            record.setNome(livro.getNome());
            record.setGenero(livro.getGenero());
            record.setAutor(livro.getAutor());
            record.setSinopse(livro.getSinopse());
            Livro updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = { "/delete/{id}" })
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        return repository.findById(id).map(record -> {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
