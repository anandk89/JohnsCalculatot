/**
 * 
 */
package com.john.brain;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author anandkamble
 *
 */
public class MainClass {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		System.out.println("Enter data : ");
		List<String> list = new ArrayList<String>();
		while (stdin.hasNext()){
			String input = stdin.nextLine();
			if(input.equals("END"))
				break;
			list.add(input);
		}
		CalculatorBrain cb = new CalculatorBrain();
		cb.calculate(list);
		
	}
}
