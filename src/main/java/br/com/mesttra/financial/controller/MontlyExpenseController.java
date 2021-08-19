package br.com.mesttra.financial.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mesttra.financial.entity.MonthlyExpense;
import br.com.mesttra.financial.service.MonthlyExpenseService;

@RestController
@RequestMapping("/montlyExpense")
public class MontlyExpenseController {

	MonthlyExpenseService monthlyExpenseService;
	
	public MontlyExpenseController(MonthlyExpenseService monthlyExpenseService) {
		this.monthlyExpenseService = monthlyExpenseService; 
	}
	
	
	@PostMapping
	public void contractPlayer(@RequestBody MonthlyExpense monthlyExpense) {
		this.monthlyExpenseService.cadastrar(monthlyExpense);
	}
	
	
}
