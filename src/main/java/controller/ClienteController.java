// =========================
// ClienteController.java
// =========================

package controller;

import model.Cliente;
import service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    // GET
    @GetMapping
    public List<Cliente> listar() {

        return service.listar();
    }

    // POST
    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente) {

        Cliente novo = service.criar(cliente);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(novo);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {

        boolean removido = service.remover(id);

        if (removido) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(
            @PathVariable Long id,
            @RequestBody Cliente cliente) {

        Cliente atualizado = service.atualizar(id, cliente);

        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        }

        return ResponseEntity.notFound().build();
    }
}