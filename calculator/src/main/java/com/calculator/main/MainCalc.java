/**
 * 
 */
package com.calculator.main;

import java.io.BufferedInputStream;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.lang3.StringUtils;

import com.calculator.stack.Stack;


/**
 * @author anandkamble
 *
 */
public class MainCalc {

	private Stack myStack;

	public MainCalc(){
		myStack = new Stack();
	}

	public void operation(String input) throws ScriptException{
		String currentToken, aheadToken="";
		int aheadPointer;
		char []inputCharArray = input.toCharArray();
		aheadPointer=1;
		for(int index=0;index < inputCharArray.length;index++){
			currentToken = String.valueOf(inputCharArray[index]);
			if(aheadPointer < inputCharArray.length)
				aheadToken = String.valueOf(inputCharArray[aheadPointer++]);
			if(currentToken.equals("(")){
				myStack.push(currentToken);
			}else if(currentToken.equals(")")){
				String expression ="";
				String tempCurToken = myStack.pop();
				while(!tempCurToken.equals("(")){
					expression = expression + tempCurToken;
					tempCurToken = myStack.pop();
				}
				ScriptEngineManager mgr = new ScriptEngineManager();
				ScriptEngine engine = mgr.getEngineByName("JavaScript");
				String val = String.valueOf(engine.eval(expression));
				//System.out.println(val);
				myStack.push(val);
				index++;

			}else if(currentToken.equals("^")){

				String expression = "Math.pow(" + myStack.pop() + "," + aheadToken + ")";
				ScriptEngineManager mgr = new ScriptEngineManager();
				ScriptEngine engine = mgr.getEngineByName("JavaScript");
				String val = String.valueOf(engine.eval(expression));
				//System.out.println(val);
				myStack.push(val);
				index++;

			}else if(currentToken.equals("/") || currentToken.equals("*")){

				String expression = myStack.pop() + currentToken + aheadToken;
				ScriptEngineManager mgr = new ScriptEngineManager();
				ScriptEngine engine = mgr.getEngineByName("JavaScript");
				String val = String.valueOf(engine.eval(expression));
				//System.out.println(val);
				myStack.push(val);
				index++;


			}else if(currentToken.equals("+") || currentToken.equals("-") ){
				if(aheadToken.equals("("))
					myStack.push(aheadToken);
				else{
					String expression = myStack.pop() + currentToken + aheadToken;
					ScriptEngineManager mgr = new ScriptEngineManager();
					ScriptEngine engine = mgr.getEngineByName("JavaScript");
					String val = String.valueOf(engine.eval(expression));
					//System.out.println(val);
					myStack.push(val);
					index++;
				}

			}else if(StringUtils.isNumeric(currentToken)){
				myStack.push(currentToken);
			}
		}
		//System.out.println(myStack.top());

	}

	public void printFinalResult(){
		System.out.println(myStack.top());
	}

	public static void main(String[] args) {
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		System.out.println("Enter data : ");
		String input = stdin.nextLine();
		MainCalc calc = new MainCalc();
		try {
			calc.operation(input);
			calc.printFinalResult();
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
