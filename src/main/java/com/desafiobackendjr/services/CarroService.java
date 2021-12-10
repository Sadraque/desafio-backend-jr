package com.desafiobackendjr.services;

import com.desafiobackendjr.domain.Carro;
import com.desafiobackendjr.domain.dto.CarroDTO;
import com.desafiobackendjr.exception.CpfUnicoException;
import com.desafiobackendjr.exception.NotFoundException;
import com.desafiobackendjr.exception.PreConditionFailedException;
import com.desafiobackendjr.logging.Logger;
import com.desafiobackendjr.repository.CarroRepository;
import com.desafiobackendjr.repository.CarroRepository;
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
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public Carro save(CarroDTO carroDTO) {
        return save(parseToEntity(carroDTO, Carro.class));
    }

    public Carro save(Carro carro) {
        return this.carroRepository.save(carro);
    }

    public Carro update(CarroDTO carroDTO, Long id) {
        Carro carro = findById(id);

        carro.setMarca(carroDTO.getMarca());
        carro.setModelo(carroDTO.getModelo());

        return this.carroRepository.save(carro);
    }

    public void delete(Long id) {
        try {
            this.carroRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exception) {
            throw new NotFoundException("Carro não encontrado");

        } catch (DataIntegrityViolationException | ConstraintViolationException exception) {
            throw new PreConditionFailedException("Carro esta em uso");
         }
    }

    public void delete(Carro carro) {
        try {
            delete(carro.getId());
        } catch (EmptyResultDataAccessException exception) {
            throw new NotFoundException("Carro não encontrado");
        }
    }

    public Page<Carro> findAll(Pageable pageable) {
        return this.carroRepository.findAll(pageable);
    }

    public List<Carro> findAll() {
        return this.carroRepository.findAll();
    }

    public Carro findById(Long id) {
        return this.carroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Carro não econtrado"));
    }
}
