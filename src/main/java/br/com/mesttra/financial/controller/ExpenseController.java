package br.com.mesttra.financial.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mesttra.financial.entity.Expense;
import br.com.mesttra.financial.service.ExpenseService;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

	ExpenseService expenseService;
	
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService; 
	}
	
	@GetMapping
	public List<Expense> all() {
		return this.expenseService.findAll();
	}
	
	@GetMapping("/{id}")
	public Expense specific(@PathVariable("id") Long id) {
		return this.expenseService.findSpecific(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		this.expenseService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping("/{id}")
	public Expense updateDueDate(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate newDueDate, @PathVariable("id") Long id) {
		return this.expenseService.updateDueDate(newDueDate, id);
	}
	
	@PostMapping
	public void contractPlayer(@RequestBody Expense expense) {
		this.expenseService.cadastrar(expense);
	}
	
	
}
