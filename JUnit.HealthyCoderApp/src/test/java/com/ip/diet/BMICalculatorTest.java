package com.ip.diet;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import com.ip.diet.BMICalculator;
import com.ip.diet.Coder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class BMICalculatorTest {

	@Test
	final void testIsDietRecommendedTrue() {
		// given
		double weight = 89.0;
		double height = 1.72;

		// when
		boolean recommended = BMICalculator.isDietRecommended(weight, height);

		// then
		assertTrue(recommended);
	}

	@Test
	final void testIsDietRecommendedFalse() {
		// given
		double weight = 89.0;
		double height = 1.92;

		// when
		boolean recommended = BMICalculator.isDietRecommended(weight, height);

		// then
		assertFalse(recommended);
	}

	@Test
	final void testIsDietRecommendedException() {
		// given
		double weight = 55.0;
		double height = 0.0;

		// when
		Executable executable = () -> BMICalculator.isDietRecommended(weight, height);

		// then
		assertThrows(ArithmeticException.class, executable);
		// assertThrows(IOException.class, executable);

	}

	@Test
	final void testFindCoderWithWorstBMIWhenCoderListIsNotEmpty() {

		// given
		List<Coder> coders = new ArrayList<Coder>();
		coders.add(new Coder(1.8, 60.0));
		coders.add(new Coder(1.82, 98.0));
		coders.add(new Coder(1.82, 64.7));

		// when
		Coder coderWithWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

		// then
//		assertAll(
//				() -> assertEquals(1.85, coderWithWorstBMI.getHeight()),
//				() -> assertEquals(98.5, coderWithWorstBMI.getWeight())
//				);
		
		assertAll(
				() -> assertEquals(1.82, coderWithWorstBMI.getHeight()),
				() -> assertEquals(98.0, coderWithWorstBMI.getWeight())
				);

	}

//	@Test
//	final void testGetBMIScores() {
//		fail("Not yet implemented"); // TODO
//	}

}
