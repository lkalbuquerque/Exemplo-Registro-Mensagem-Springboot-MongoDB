package com.lkalbuquerque.registromensagem.services;

import com.lkalbuquerque.registromensagem.domain.Mensagem;
import com.lkalbuquerque.registromensagem.domain.Telefone;
import com.lkalbuquerque.registromensagem.repository.MensagemRepository;
import com.lkalbuquerque.registromensagem.repository.TelefoneRepository;
import com.lkalbuquerque.registromensagem.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensagemService {

    @Autowired
    private MensagemRepository mensagemRepository;


    public Mensagem findById(String id){
        Optional<Mensagem> mensagem = mensagemRepository.findById(id);
        return mensagem.orElseThrow(()-> new ObjectNotFoundException("Não Encontrado"));
    }


}
