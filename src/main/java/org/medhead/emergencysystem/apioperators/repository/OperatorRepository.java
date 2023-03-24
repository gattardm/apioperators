package org.medhead.emergencysystem.apioperators.repository;

import org.medhead.emergencysystem.apioperators.model.Operator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepository extends CrudRepository<Operator, Long> {
}
