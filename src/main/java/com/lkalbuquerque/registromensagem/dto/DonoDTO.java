package com.lkalbuquerque.registromensagem.dto;

import com.lkalbuquerque.registromensagem.domain.Telefone;

public class DonoDTO {

    private String id;
    private String telefone;

    public DonoDTO() {
    }
    public DonoDTO(Telefone tel){
        id = tel.getId();
        telefone = tel.getNumeroTelefone();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
