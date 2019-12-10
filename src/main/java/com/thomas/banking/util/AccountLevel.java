package com.thomas.banking.util;

public enum AccountLevel {
	
	BASIC(1.06),
	PREMIUM(1.08);
	private double apy;
	
	AccountLevel(double apy){
		this.apy = apy;
	}
	
	public double getApy(){
		return apy;
	}	
	
}
