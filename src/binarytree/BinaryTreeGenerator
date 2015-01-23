package binarytree;

import java.util.ArrayList;

import help.HelperFunctions;
import interfaces.IVisitable;
import vo.Parenthesis;
import vo.TreeNode;

public class BinaryTreeGenerator {
	
	public IVisitable generateBinaryTree(ArrayList<IVisitable> expression) {
		
		try {
			checkExpression(expression);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		ArrayList<Integer> precedence = new ArrayList<Integer>();
		for(int i = 0; i < expression.size(); i++) {
			precedence.add(HelperFunctions.getPrecedence(expression.get(i)));
		}
		
		for(int i = 2; i > 0; i--) {
			for(int location = precedence.indexOf(i); location != -1; location = precedence.indexOf(i)) {
				IVisitable node = new TreeNode(expression.remove(location - 1),
												expression.remove(location - 1).toString(),
												expression.remove(location - 1));
				precedence.remove(location);
				precedence.remove(location);
				
				expression.add(location - 1, node);
			}
		}
		
		return expression.remove(0);
	}
	
	private void checkExpression(ArrayList<IVisitable> expression) throws Exception {
		
		IVisitable firstOperand = expression.get(0);
		if (HelperFunctions.isOperator(firstOperand)) {
			throw new Exception();
		} else if (HelperFunctions.getPrecedence(firstOperand) == 3) {
			if (firstOperand.toString().equals(")")) {
				throw new Exception();
			} else {
				
				int endLocation = HelperFunctions.getClosingParenthesis(expression, 0);
				if (endLocation == 1) {
					throw new Exception();
				}
				
				IVisitable subTree = generateBinaryTree(new ArrayList<IVisitable>(expression.subList(1, endLocation)));
				Parenthesis paren = new Parenthesis(subTree);
				
				for(; 0 < endLocation; endLocation--) {
					expression.remove(endLocation);
				}
				expression.set(0, paren);
			}
		}
		
		for (int i = 1; i < expression.size(); i += 2) {
			IVisitable operator = expression.get(i);
			if (!HelperFunctions.isOperator(operator)) {
				throw new Exception();
			}
			IVisitable operand = expression.get(i + 1);
			if (HelperFunctions.isOperator(operand)) {
				throw new Exception();
			} else if (HelperFunctions.getPrecedence(operand) == 3) {
				if (firstOperand.toString().equals(")")) {
					throw new Exception();
				} else {
					
					int endLocation = HelperFunctions.getClosingParenthesis(expression, i + 1);
					if (endLocation == i + 2) {
						throw new Exception();
					}
					IVisitable subTree = generateBinaryTree(new ArrayList<IVisitable>(expression.subList(i + 2, endLocation)));
					Parenthesis paren = new Parenthesis(subTree);
					
					for(; i + 1 < endLocation; endLocation--) {
						expression.remove(endLocation);
					}
					expression.set(i + 1, paren);
				}
			}
		}
		
	}

}
