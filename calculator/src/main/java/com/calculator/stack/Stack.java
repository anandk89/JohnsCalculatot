/**
 * 
 */
package com.calculator.stack;

import java.util.ArrayList;

/**
 * @author anand.kamble
 *
 */
public class Stack {

	@SuppressWarnings("rawtypes")
	private ArrayList list;

	public Stack(){
		list = new ArrayList<String>();
	}

	@SuppressWarnings("unchecked")
	public void push(String op){
		list.add(op);
	}

	public String pop(){
		if(!list.isEmpty()){
			Object lastElement = list.get(list.size()-1);
			list.remove(lastElement);
			return lastElement.toString();
		}
		return "";
	}
	
	public String top(){
		Object lastElement = list.get(list.size()-1);
		return lastElement.toString();
	}

	public boolean isStackEmpty(){
		return list.isEmpty();
	}
}
