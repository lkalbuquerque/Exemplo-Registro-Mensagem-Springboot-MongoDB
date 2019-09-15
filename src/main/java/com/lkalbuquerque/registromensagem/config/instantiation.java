package com.lkalbuquerque.registromensagem.config;

import com.lkalbuquerque.registromensagem.domain.Mensagem;
import com.lkalbuquerque.registromensagem.domain.Telefone;
import com.lkalbuquerque.registromensagem.dto.DonoDTO;
import com.lkalbuquerque.registromensagem.repository.MensagemRepository;
import com.lkalbuquerque.registromensagem.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class instantiation implements CommandLineRunner {

    @Autowired
    private TelefoneRepository telefoneRepository;
    @Autowired
    private MensagemRepository mensagemRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        telefoneRepository.deleteAll();
        mensagemRepository.deleteAll();

        Telefone tel1 = new Telefone(null,"19232103213","Lucas","Galaxy note 9");
        Telefone tel2 = new Telefone(null,"120320392103","Maria","Iphone 11");
        Telefone tel3 = new Telefone(null,"21312312312","João","Pixel IV");

        telefoneRepository.saveAll(Arrays.asList(tel1,tel2,tel3));

        Mensagem msg = new Mensagem(null,sdf.parse("10/09/2019"),"Oi, tudo bem ?", "Whatsapp", new DonoDTO(tel1));
        Mensagem msg2 = new Mensagem(null,sdf.parse("11/09/2019"),"Não esquece daquilo", "Messenger", new DonoDTO(tel1));
        Mensagem msg3 = new Mensagem(null,sdf.parse("10/09/2019"),"Leve a tarefa", "Whatsapp", new DonoDTO(tel2));
        Mensagem msg4 = new Mensagem(null,sdf.parse("10/09/2019"),"Foto bonita", "Instagram", new DonoDTO(tel3));


        mensagemRepository.saveAll(Arrays.asList(msg,msg2,msg3,msg4));

        tel1.getMensagens().addAll(Arrays.asList(msg,msg2));
        tel2.getMensagens().addAll(Arrays.asList(msg3));
        tel3.getMensagens().addAll(Arrays.asList(msg4));

        telefoneRepository.save(tel1);
        telefoneRepository.save(tel2);
        telefoneRepository.save(tel3);


    }
}
