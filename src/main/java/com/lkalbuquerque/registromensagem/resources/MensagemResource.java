package com.lkalbuquerque.registromensagem.resources;

import com.lkalbuquerque.registromensagem.domain.Mensagem;
import com.lkalbuquerque.registromensagem.domain.Telefone;
import com.lkalbuquerque.registromensagem.services.MensagemService;
import com.lkalbuquerque.registromensagem.services.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/mensagens")
public class MensagemResource {

    @Autowired
    private MensagemService dao;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Mensagem> findById (@PathVariable String id){
        Mensagem mensagem = dao.findById(id);
        return ResponseEntity.ok().body(mensagem);
    }


}
