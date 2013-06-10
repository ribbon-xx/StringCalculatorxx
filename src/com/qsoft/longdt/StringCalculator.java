package com.qsoft.longdt;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public static int add(String input) {
		if (input.isEmpty()) {
			return 0;
		} else if (input.length() == 1) {
			return toInt(input);
		} else {
			int sum = 0;
			ArrayList<Integer> listInt = convertString2NumberArray(input);
			for (Integer integer : listInt) {
				sum += integer;
			}
			return sum;
		}
	}

	private static int toInt(String input) {
		return Integer.parseInt(input);
	}

	private static ArrayList<Integer> convertString2NumberArray(String input) {
		String strTmp = input;
		ArrayList<Integer> listInt = new ArrayList<Integer>();
		if (input.contains("//")) {
			strTmp = input.replace("//", "");
		}
		if (input.contains("\\")) {
			strTmp = input.replace("\\", "");
		}
		Pattern replaceDelimiter = Pattern.compile("\\[.+?\\]+");
		Matcher m1 = replaceDelimiter.matcher(strTmp);
		while (m1.find()) {
			strTmp = strTmp.replace(m1.group(), ",");
		}

		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(strTmp);
		while (m.find()) {
			int number = toInt(m.group());
			if (number < 0) {
				throw new NumberFormatException("negatives not allowed");
			}
			if (number <= 1000)
				listInt.add(number);
		}

		return listInt;
	}
}
