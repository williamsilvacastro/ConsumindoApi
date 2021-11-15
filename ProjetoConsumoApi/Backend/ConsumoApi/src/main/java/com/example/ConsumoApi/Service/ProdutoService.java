package com.example.ConsumoApi.Service;

import com.example.ConsumoApi.Model.dto.ProdutoDTO;
import com.example.ConsumoApi.Model.entity.Produto;
import com.example.ConsumoApi.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public ProdutoDTO create(ProdutoDTO dto){
        Produto bus = this.dtoToBusiness(dto);
        return this.businessToDTO(this.produtoRepository.save(bus));
    }

    public ProdutoDTO getById(Long id){
        if(this.produtoRepository.existsById(id)) {
            return this.businessToDTO(this.produtoRepository.getById(id));
        }
        return null;
    }

    public void deleteById(Long id){
        if(this.produtoRepository.existsById(id)){
            this.produtoRepository.deleteById(id);
        }
    }

    public ProdutoDTO updateById(ProdutoDTO dto, Long id){
        Produto bus = null;
        if(this.produtoRepository.existsById(id)){
            bus = this.produtoRepository.getById(id);
            if(dto.getNome()!=null){
                bus.setNome(dto.getNome());
            }
            if(dto.getFoto()!=null){
                bus.setFoto(dto.getFoto());
            }
            if(dto.getPreco()!=null){
                bus.setPreco(dto.getPreco());
            }
        }
        return this.businessToDTO(this.produtoRepository.save(bus));
    }

    public List<ProdutoDTO> findAll(){
        return this.ListToDTO(this.produtoRepository.findAll());
    }

    private List<ProdutoDTO> ListToDTO(List<Produto> bus){
        List<ProdutoDTO> dto = new ArrayList<>();
        for(Produto p:bus){
            dto.add(this.businessToDTO(p));
        }
        return dto;
    }

    private Produto dtoToBusiness(ProdutoDTO dto){
        Produto bus = new Produto();
        bus.setId(dto.getId());
        bus.setNome(dto.getNome());
        bus.setFoto(dto.getFoto());
        bus.setPreco(dto.getPreco());
        return bus;
    }

    private ProdutoDTO businessToDTO(Produto bus){
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(bus.getId());
        dto.setNome(bus.getNome());
        dto.setFoto(bus.getFoto());
        dto.setPreco(bus.getPreco());
        return dto;

    }
}
