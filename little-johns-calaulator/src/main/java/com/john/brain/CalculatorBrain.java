/**
 * 
 */
package com.john.brain;

import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author anandkamble
 *
 */
@SuppressWarnings("restriction")
public class CalculatorBrain {

	public void calculate(List<String> input){
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		int caseNum = 0;
		for (String exp : input) {
			try {
				String val = "Case #"+ caseNum++ +" "+String.valueOf(engine.eval(exp));
				System.out.println(val);
			} catch (ScriptException e) {
				String val = "Case #" + caseNum++ +" INVALID EXPRESSION";
				System.out.println(val);
			}
		}
		
	}
	
}
