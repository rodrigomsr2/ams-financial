package br.com.mesttra.financial.service;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import br.com.mesttra.financial.entity.Expense;
import br.com.mesttra.financial.exception.ResourceNotFoundException;
import br.com.mesttra.financial.repository.ExpenseRepository;

@Service
public class ExpenseService {

	ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	public List<Expense> findAll() {
		List<Expense> expenses = IterableUtils.toList(this.expenseRepository.findAll());
		
		if(CollectionUtils.isEmpty(expenses)) {
			throw new ResourceNotFoundException();
		}
		
		return expenses;
	}
	
	public void delete(Long id) {
		this.expenseRepository.delete(findSpecific(id));
	}
	
	public Expense findSpecific(Long id) {
		return this.expenseRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
	}
	
	
	public Expense cadastrar(Expense monthlyExpense) {
		return this.expenseRepository.save(monthlyExpense);
	}
	
	public Expense updateDueDate(LocalDate newDueDate, Long id) {
		Expense expense = this.findSpecific(id);
		
		expense.setDueDate(newDueDate);
		
		return expense;
	}
	
}
