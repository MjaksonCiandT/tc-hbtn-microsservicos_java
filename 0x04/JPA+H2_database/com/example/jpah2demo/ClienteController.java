package com.example.jpah2demo;

import com.example.demo.entities.Cliente;
import com.example.demo.entities.Endereco;
import com.example.demo.entities.Telefone;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/addClient")
    public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
        Cliente _cliente = clienteRepository.save(cliente);
        return ResponseEntity.ok().body(_cliente);
    }

    @GetMapping("/findAllClients")
    public ResponseEntity<List<Cliente>> findAllClients() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/findClientById/{id}")
    public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
        Optional<Cliente> clienteId = clienteRepository.findById(idClient);
        return ResponseEntity.ok().body(clienteId.get());
    }

    @DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long idClient){
        clienteRepository.deleteById(idClient);
    }

    @PutMapping("/updateClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){

        Optional<Cliente> clienteId = clienteRepository.findById(id);
        Cliente salvarCliente = clienteId.get();

        for(Endereco endereco : cliente.getEnderecos()){
            salvarCliente.getEnderecos().add(endereco);
            endereco.setCliente(salvarCliente);
        }
        for(Telefone telefone : cliente.getTelefones()){
            salvarCliente.getTelefones().add(telefone);
            telefone.setCliente(salvarCliente);
        }
        clienteRepository.save(salvarCliente);
    }
}
