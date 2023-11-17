package com.WorkWave.WorkWave.controllers;

import com.WorkWave.WorkWave.models.Cliente;
import com.WorkWave.WorkWave.services.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteServices clienteServices;

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Cliente cliente = clienteServices.findById(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarCliente(
            @RequestParam String nome,
            @RequestParam String senha,
            @RequestParam String email,
            @RequestParam Integer telefone,
            @RequestParam String endereco) {
        clienteServices.salvarCliente(null, nome, senha, email, telefone, endereco);
        return new ResponseEntity<>("Cliente criado com sucesso", HttpStatus.CREATED);
    }

    // Adicione outros métodos conforme necessário para atualizar, excluir ou buscar clientes.

}
