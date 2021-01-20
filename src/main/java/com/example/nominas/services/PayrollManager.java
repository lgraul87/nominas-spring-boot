package com.example.nominas.services;

import java.io.Serializable;

public interface PayrollManager extends Serializable{

	public float getSalary(String dni);

}
