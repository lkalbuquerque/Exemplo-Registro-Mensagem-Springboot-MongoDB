package com.lkalbuquerque.registromensagem.service;

import com.lkalbuquerque.registromensagem.domain.Telefone;
import com.lkalbuquerque.registromensagem.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository telefoneRepository;



    public Telefone insert (Telefone telefone){
        return telefoneRepository.insert(telefone);
    }

}
