package br.com.mesttra.financial.service;

import org.springframework.stereotype.Service;

import br.com.mesttra.financial.entity.MonthlyExpense;
import br.com.mesttra.financial.repository.MontlyExpenseRepository;

@Service
public class MonthlyExpenseService {

	MontlyExpenseRepository montlyExpenseRepository;
	
	public MonthlyExpenseService(MontlyExpenseRepository montlyExpenseRepository) {
		this.montlyExpenseRepository = montlyExpenseRepository;
	}
	
	public MonthlyExpense cadastrar(MonthlyExpense monthlyExpense) {
		return this.montlyExpenseRepository.save(monthlyExpense);
	}
	
}
