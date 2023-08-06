package com.example.desafio3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio3.models.Pessoa;
import com.example.desafio3.repositories.PessoaRepository;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    public List<Pessoa> findAll() {
        return repository.findAll();
    }

    public Pessoa findById(Integer id) {
        Optional<Pessoa> obj = repository.findById(id);
        return obj.get();
    }

    public Pessoa insert(Pessoa obj) {
        obj = repository.save(obj);
        return obj;
    }

    public Pessoa update(Pessoa obj, Integer id) {
        Pessoa entity = repository.getReferenceById(id);
        entity.setEmail(obj.getEmail());
        entity.setIdentidade(obj.getIdentidade());
        entity.setNome(obj.getNome());
        repository.save(entity);
        return entity;
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
