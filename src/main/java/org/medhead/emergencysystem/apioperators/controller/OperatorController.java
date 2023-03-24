package org.medhead.emergencysystem.apioperators.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.medhead.emergencysystem.apioperators.model.Operator;
import org.medhead.emergencysystem.apioperators.service.OperatorService;
@RestController
public class OperatorController {

    @Autowired
    private OperatorService operatorService;

    /**
     * Create - Add a new operator
     *
     * @param operator An object operator
     * @return The operator object saved
     */
    @PostMapping("/operator")
    public Operator createOperator(@RequestBody Operator operator) {
        return operatorService.saveOperator(operator);
    }

    /**
     * Read - Get one operator
     *
     * @param id The id of the operator
     * @return A Operator object fulfilled
     */
    @GetMapping("/operator/{id}")
    public Operator getOperator(@PathVariable("id") final Long id) {
        Optional<Operator> operator = operatorService.getOperator(id);
        if (operator.isPresent()) {
            return operator.get();
        } else {
            return null;
        }
    }

    /**
     * Read - Get all operators
     *
     * @return - An Iterable object of Operator fulfilled
     */
    @GetMapping("/operators")
    public Iterable<Operator> getOperators() {
        return operatorService.getOperators();
    }

    /**
     * Update - Update an existing operator
     *
     * @param id       - The id of the operator to update
     * @param operator - The operator object updated
     * @return
     */
    @PutMapping("/operator/{id}")
    public Operator updateOperator(@PathVariable("id") final Long id, @RequestBody Operator operator) {
        Optional<Operator> o = operatorService.getOperator(id);
        if (o.isPresent()) {
            Operator currentOperator = o.get();

            String name = operator.getName();
            if (name != null) currentOperator.setName(name);

            String available = operator.getAvailable();
            if (available != null) currentOperator.setAvailable(available);

            String incidentId = operator.getIncidentId();
            if (incidentId != null) currentOperator.setIncidentId(incidentId);

            String hospitalId = operator.getHospitalId();
            if (hospitalId != null) currentOperator.setHospitalId(hospitalId);

            operatorService.saveOperator(currentOperator);
            return currentOperator;
        } else {
            return null;
        }
    }

    /**
     * Delete - Delete an operator
     *
     * @param id - The id of the operator to delete
     */
    @DeleteMapping("/operator/{id}")
    public void deleteOperator(@PathVariable("id") final Long id) {
        operatorService.deleteOperator(id);
    }

}
