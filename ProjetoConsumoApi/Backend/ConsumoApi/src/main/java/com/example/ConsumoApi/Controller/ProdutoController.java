package com.example.ConsumoApi.Controller;

import com.example.ConsumoApi.Model.dto.ProdutoDTO;
import com.example.ConsumoApi.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "http://localhost:3000")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public ProdutoDTO create(@RequestBody ProdutoDTO dto){
        return this.produtoService.create(dto);
    }
    @GetMapping
    public List<ProdutoDTO> findAll(){
        return this.produtoService.findAll();
    }
    @GetMapping("/{id}")
    public ProdutoDTO getById(@PathVariable("id") Long id){
        return this.produtoService.getById(id);
    }
    @PutMapping("/{id}")
    public ProdutoDTO update(@RequestBody ProdutoDTO dto, @PathVariable("id") Long id){
        return this.produtoService.updateById(dto, id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        this.produtoService.deleteById(id);
    }


}

