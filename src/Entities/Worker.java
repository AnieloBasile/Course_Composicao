package Entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Entities.Enums.WorkerLevel;

public class Worker {
	
	private String 		name;
	private WorkerLevel level;
	private Double      baseSalary;

	//Associations (ForenKey) ----------------------------------------------------------------------
	private Departament        departament;
	
	private List<HourContract> contracts = new ArrayList<>(); 
	//type list HourContract, não incluir no construtor, e instanciar aqui, iniciando a lista vazia
	// ---------------------------------------------------------------------------------------------
	
	
	// empty default constructor  
	public Worker() {
		
	}

	// constructor with arguments 
	// Criar sem atributo lista, e instanciar a variavel na sua criação
	public Worker(String name, WorkerLevel level, Double baseSalary, Departament departament) {
			//List<HourContract> contracts) {
		// super();  ---- this not necessary
		this.name 		  = name;
		this.level 		  = level;
		this.baseSalary   = baseSalary;
		this.departament  = departament;
		//this.contracts    = contracts;
	}

	
	// Getters and Setters -------------------------------------------------------------------------- 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	// a manipulação da lista será pelos metodos add e remove abaixo e não pelo setContracts
	/*
	public void setContracts(List<HourContract> contracts) {
		this.contracts = contracts;
	}*/
	// ----------------------------------------------------------------------------------------------

	
	// creation of methods --------------------------------------------------------------------------
	//public void <nomedo metodo(<typo do argumento, ref a quem ele vai manipular> <nome do argumento>)
	public void addContract(HourContract contract) {
		contracts.add(contract);
		
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
		
	}
	
	//não usa void porque vai retornar valor
	public double income(int year, int month) {
		
		Double   sum = baseSalary;
		Calendar cal = Calendar.getInstance();
				
		for (HourContract c : contracts) {
			
			//atribuindo a data do contrato como data do "cal" para poder fatiar
			cal.setTime(c.getInicialDate());
			              
			int c_year  = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH); // +1 porque o mes no Calendar inicia em 0
			            
			
			if (year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
	//-----------------------------------------------------------------------------------------------
}
