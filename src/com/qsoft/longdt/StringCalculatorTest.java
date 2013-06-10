package com.qsoft.longdt;

import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void shouldReturn0OnEmptyString() {
		assertEquals(0, StringCalculator.add(""));
	}

	@Test
	public void shouldReturnNumberInOneNumberString() {
		assertEquals(1, StringCalculator.add("1"));
	}

	@Test
	public void shouldReturnSumWithComma() {
		assertEquals(3, StringCalculator.add("1,2"));
	}

	@Test
	public void shouldReturnSumWithSpecialComma() {
		assertEquals(6, StringCalculator.add("1,\n$#@2sdfsdf3"));
	}

	@Test
	public void shouldReturnSumWithBigNumber() {
		assertEquals(6, StringCalculator.add("1,\n$#@2sdf1001sdf3"));
	}

	@Test
	public void shouldReturnSumWithLongDelimiter() {
		assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
	}

	@Test
	public void shouldReturnSumInStep8() {
		assertEquals(6, StringCalculator.add("//[*][%]\n1*2%3"));
	}

	@Test
	public void shouldReturnSumWithSpecialDelim() {
		assertEquals(15,
				StringCalculator
						.add("//[dffsadfs324423sdfsd*][%24dfsdf]\n10*2%3"));
	}

	@Test
	public void shouldThrowNumberException() {
		try {
			StringCalculator.add("-10*2%3");
		} catch (NumberFormatException e) {
			assertThat(e.getMessage(), containsString("negatives not allowed"));
		}
	}
}
