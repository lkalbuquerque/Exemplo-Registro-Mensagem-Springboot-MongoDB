package com.lkalbuquerque.registromensagem.resources;

import com.lkalbuquerque.registromensagem.domain.Telefone;
import com.lkalbuquerque.registromensagem.services.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/telefone")
public class TelefoneResource {

    @Autowired
    private TelefoneService dao;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert (@RequestBody Telefone telefone){
        telefone = dao.insert(telefone);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(telefone.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Telefone> findById (@PathVariable String id){
        Telefone telefone = dao.findById(id);
        return ResponseEntity.ok().body(telefone);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Telefone>> findAll (){
        return ResponseEntity.ok().body(dao.findAll());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> update (@PathVariable String id){
        dao.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody Telefone tel, @PathVariable String id){
        tel.setId(id);
        tel = dao.update(tel);
        return ResponseEntity.noContent().build();
    }

}
