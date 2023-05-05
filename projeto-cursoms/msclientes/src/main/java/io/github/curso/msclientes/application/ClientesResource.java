package io.github.curso.msclientes.application;

import io.github.curso.msclientes.application.representation.ClienteSaveRequest;
import io.github.curso.msclientes.domain.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("clientes")
public class ClientesResource {

    private final ClienteService clienteService;

    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ClienteSaveRequest request) {
        Cliente cliente = request.toModel();
        clienteService.save(cliente);
        URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequest().query("cpf={cpf}").buildAndExpand(cliente.getCpf()).toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<?> dadosDoCliente(@RequestParam("cpf") String cpf) {
        Optional<Cliente> cliente = clienteService.getByCPF(cpf);
        if (cliente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }
}