package br.com.mesttra.financial.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mesttra.financial.entity.Expense;
import br.com.mesttra.financial.service.ExpenseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Add contract player",
			notes="Add player contract expenses")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Expenses added"),
			@ApiResponse(code = 500, message = "Internal Error")
	})
	public ResponseEntity<Expense> contractPlayer(@RequestBody Expense newExpense) throws URISyntaxException {
		Expense expense = this.expenseService.cadastrar(newExpense);
		
		URI uri = new URI("/expenses/" + expense.getId());
		
		return ResponseEntity.created(uri).body(expense);
	}
	
	
}
