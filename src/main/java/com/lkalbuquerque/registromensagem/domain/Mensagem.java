package com.lkalbuquerque.registromensagem.domain;

import com.lkalbuquerque.registromensagem.dto.DonoDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;

@Document
public class Mensagem {

    @Id
    private String id;
    private Date date;
    private String texto;
    private String tipo;
    private DonoDTO dono;

    public Mensagem() {
    }

    public Mensagem(String id, Date date, String texto, String tipo, DonoDTO dono) {
        this.id = id;
        this.date = date;
        this.texto = texto;
        this.tipo = tipo;
        this.dono = dono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mensagem mensagem = (Mensagem) o;
        return Objects.equals(id, mensagem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public DonoDTO getDono() {
        return dono;
    }

    public void setDono(DonoDTO dono) {
        this.dono = dono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
