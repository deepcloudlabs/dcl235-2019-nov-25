package com.example.imdb.service.business;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.imdb.service.Calculator;
import com.example.imdb.service.CalculatorQualifier;
import com.example.imdb.service.CalculatorType;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Service("complexCalc")
@CalculatorQualifier(CalculatorType.COMPLEX)
@Primary
@Scope("prototype")
public class ComplexCalculator implements Calculator {

	public ComplexCalculator() {
		System.err.println("ComplexCalculator::ComplexCalculator() is running...");
	}

	@Override
	public double pow(double x, double y) {
		System.err.println("ComplexCalculator::pow() is running...");
		return 42.;
	}

}
