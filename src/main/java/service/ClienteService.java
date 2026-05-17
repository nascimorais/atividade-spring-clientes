
package service;

import model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private List<Cliente> clientes = new ArrayList<>();

    private Long nextId = 1L;

    // LISTAR
    public List<Cliente> listar() {
        return clientes;
    }

    // CRIAR
    public Cliente criar(Cliente c) {

        c.setId(nextId++);

        clientes.add(c);

        return c;
    }

    // BUSCAR POR ID
    public Cliente buscarPorId(Long id) {

        for (Cliente c : clientes) {

            if (c.getId().equals(id)) {
                return c;
            }
        }

        return null;
    }

    // REMOVER
    public boolean remover(Long id) {

        return clientes.removeIf(c -> c.getId().equals(id));
    }

    // ATUALIZAR
    public Cliente atualizar(Long id, Cliente novo) {

        Cliente clienteExistente = buscarPorId(id);

        if (clienteExistente != null) {

            clienteExistente.setNome(novo.getNome());
            clienteExistente.setEmail(novo.getEmail());
            clienteExistente.setIdade(novo.getIdade());

            return clienteExistente;
        }

        return null;
    }
}