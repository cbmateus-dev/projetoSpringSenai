package org.senai.prjjava.controller;

import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.senai.prjjava.entity.Produto;
import org.senai.prjjava.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// http://localhost:8080/api/produtos/
@Controller // This means that this class is a Controller
@RequestMapping(path = "/api/produtos") // This means URL's start with /demo (after Application path)
@CrossOrigin("*")
public class ProdutoController {
  @Autowired
  ProdutoRepository uRepository;

  @PostMapping("/")

  public @ResponseBody Integer addUsuario(@RequestBody Produto objU) {
    uRepository.save(objU);

    return objU.getId();

  }

  @GetMapping("/")
  public @ResponseBody Iterable<Produto> buscarProdutos() {

    return uRepository.findAll();
  }
// http://localhost:8080/api/produtos/:id
  @GetMapping("/{id}")
  public @ResponseBody Optional<Produto> buscarProdutos(@PathVariable Integer id){
    return uRepository.findById(id);

  }
  @PutMapping("/")
  public @ResponseBody Produto atualizar(@RequestBody Produto objU){
    uRepository.save(objU);
    return objU;
  }

  @DeleteMapping("/{id}")
  public @ResponseBody String apagar(@PathVariable Integer id){
    uRepository.deleteById(id);
    return "Ok ao apagar produto!";
  }
}