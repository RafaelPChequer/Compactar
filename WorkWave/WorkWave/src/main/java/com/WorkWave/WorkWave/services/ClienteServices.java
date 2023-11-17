package com.WorkWave.WorkWave.services;

import com.WorkWave.WorkWave.models.Cliente;
import com.WorkWave.WorkWave.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServices {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findById(Long id){
        Optional<Cliente> cliente = this.clienteRepository.findById(id);
        return cliente.orElseThrow(()->new RuntimeException("Cliente não encontrado!"));
    }

    public void salvarCliente(Integer id,String nome, String senha, String email, Integer telefone, String endereco) {
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setEmail(email);
        cliente.setSenha(senha);
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}