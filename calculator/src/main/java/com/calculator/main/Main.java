/**
 * 
 */
package com.calculator.main;

import java.io.BufferedInputStream;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author anandkamble
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		System.out.println("Enter data : ");
		String input = stdin.nextLine();
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		try {
			String val = String.valueOf(engine.eval(input));
			System.out.println(val);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}
}
