package br.com.mesttra.financial.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.mesttra.financial.entity.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {

}
