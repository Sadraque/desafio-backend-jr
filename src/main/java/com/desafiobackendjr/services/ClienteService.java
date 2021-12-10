package com.desafiobackendjr.services;

import com.desafiobackendjr.domain.Carro;
import com.desafiobackendjr.domain.Cliente;
import com.desafiobackendjr.domain.dto.ClienteDTO;
import com.desafiobackendjr.exception.CpfUnicoException;
import com.desafiobackendjr.exception.NotFoundException;
import com.desafiobackendjr.logging.BaseKey;
import com.desafiobackendjr.logging.Logger;
import com.desafiobackendjr.repository.ClienteRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.desafiobackendjr.logging.BaseKey.*;

import static com.desafiobackendjr.utils.TypeUtils.parseToEntity;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CarroService carroService;

    public Cliente save(ClienteDTO clienteDTO) {
        return save(parseToEntity(clienteDTO, Cliente.class));
    }

    public Cliente save(Cliente cliente) throws CpfUnicoException {
        try {
            return this.clienteRepository.save(cliente);
            
        } catch (DataIntegrityViolationException | ConstraintViolationException exception) {
            Logger.builder()
                    .add(EXCEPTION, exception.getMessage())
                    .add(CPF, cliente.getCpf())
                    .add(MESSAGE, "Já existe um Cliente cadastrado com este CPF")
                    .warning();

            throw new CpfUnicoException();
        }
    }

    public Cliente update(ClienteDTO clienteDTO, Long id) {
        Cliente cliente = findById(id);

        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setDataNascimento(clienteDTO.getDataNascimento());

        return this.clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        try {
            this.clienteRepository.deleteById(id);

        } catch (EmptyResultDataAccessException exception) {
            throw new NotFoundException("Cliente não encontrado");
        }
    }

    public void delete(Cliente cliente) {
        delete(cliente.getId());
    }

    public Page<Cliente> findAll(Pageable pageable) {
        return this.clienteRepository.findAll(pageable);
    }

    public List<Cliente> findAll() {
        return this.clienteRepository.findAll();
    }

    public Cliente findByCpf(String cpf) {
        return this.clienteRepository.findClienteByCpf(cpf)
                .orElseThrow(() -> new NotFoundException(String.format("Cliente com CPF %s não encontrado", cpf)));
    }

    public Cliente findById(Long id) {
        return this.clienteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente não econtrado"));
    }
}
