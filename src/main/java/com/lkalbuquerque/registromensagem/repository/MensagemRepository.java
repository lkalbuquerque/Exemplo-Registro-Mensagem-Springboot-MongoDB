package com.lkalbuquerque.registromensagem.repository;

import com.lkalbuquerque.registromensagem.domain.Mensagem;
import com.lkalbuquerque.registromensagem.domain.Telefone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensagemRepository extends MongoRepository<Mensagem,String> {

}
