package br.com.mesttra.financial.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.mesttra.financial.entity.MonthlyExpense;

@Repository
public interface MontlyExpenseRepository extends CrudRepository<MonthlyExpense, Integer> {

}
