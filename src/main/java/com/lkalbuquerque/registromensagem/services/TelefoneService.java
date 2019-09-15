package com.lkalbuquerque.registromensagem.services;

import com.lkalbuquerque.registromensagem.domain.Telefone;
import com.lkalbuquerque.registromensagem.repository.TelefoneRepository;
import com.lkalbuquerque.registromensagem.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository telefoneRepository;



    public Telefone insert (Telefone telefone){
        return telefoneRepository.insert(telefone);
    }

    public Telefone findById(String id){
        Optional<Telefone> telefone = telefoneRepository.findById(id);
        return telefone.orElseThrow(()-> new ObjectNotFoundException("Não Encontrado"));
    }

    public List<Telefone> findAll (){
        return telefoneRepository.findAll();
    }

    public void delete (String id){
        telefoneRepository.deleteById(id);
    }

    public Telefone update (Telefone tel){
        //Telefone tel2 = findById(tel.getId());
        return telefoneRepository.save(tel);
    }

}
