package org.medhead.emergencysystem.apioperators.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.medhead.emergencysystem.apioperators.repository.OperatorRepository;
import org.medhead.emergencysystem.apioperators.model.Operator;

import java.util.Optional;

@Data
@Service
public class OperatorService {

    @Autowired
    private OperatorRepository operatorRepository;

    public Optional<Operator> getOperator(final Long id) { return operatorRepository.findById(id); }

    public Iterable<Operator> getOperators() { return operatorRepository.findAll(); }

    public void deleteOperator(final Long id) { operatorRepository.deleteById(id); }

    public Operator saveOperator(Operator operator) {
        Operator savedOperator = operatorRepository.save(operator);
        return savedOperator;
    }
}
