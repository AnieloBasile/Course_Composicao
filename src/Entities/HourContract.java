package Entities;

import java.util.Date;

public class HourContract {
	
	private Date    inicialDate;
	private Double  valuePerHour;
	private Integer hour; 
	// attribute type always start with a uppercase letter
	// attribute Name always start with a lowercase letter

	// empty default constructor  
	public HourContract() {
		
	}

	//constructor with arguments
	public HourContract(Date inicialDate, Double valuePerHour, Integer hour) {
		//super();
		this.inicialDate  = inicialDate;
		this.valuePerHour = valuePerHour;
		this.hour         = hour;
	}
	public Date getInicialDate() {
		return inicialDate;
	}
	public void setInicialDate(Date inicialDate) {
		this.inicialDate = inicialDate;
	}
	public Double getValuePerHour() {
		return valuePerHour;
	}
	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}
	public Integer getHour() {
		return hour;
	}
	public void setHour(Integer hour) {
		this.hour = hour;
	}

	// creation of methods --------------------------------------------------------------------------
	public double totalValue() {
		return valuePerHour * hour;
		
	}
	
	
	
}
