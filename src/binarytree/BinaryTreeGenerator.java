package binarytree;

import java.util.ArrayList;
import java.util.List;

import exception.ImproperQueryException;
import help.HelperFunctions;
import interfaces.IVisitable;
import vo.Parenthesis;
import vo.TreeNode;

public class BinaryTreeGenerator {
	
	private int _end;
	
	public IVisitable generateBinaryTree(ArrayList<String> oldExpression) {
		
		ArrayList<IVisitable> expression = new ArrayList<IVisitable>();
		
		try {
			IVisitable firstOperand = getOneOperand(oldExpression, 0);
			expression.add(firstOperand);
			for(int i = 1; i < oldExpression.size(); i = _end) {
				String operator = oldExpression.get(i);
				if (!HelperFunctions.isOperator(operator)) {
					throw new ImproperQueryException(oldExpression, i);
				}
				expression.add(new TreeNode(operator));
				IVisitable operand = getOneOperand(oldExpression, i + 1);
				expression.add(operand);
			}
		} catch (ImproperQueryException e) {
			List<String> list = e.getExpression();
			int startLocation = e.getStartLocation();
			int endLocation = e.getEndLocation();
			System.out.print("Error in Expression: " + printList(list.subList(0, startLocation)));
			System.out.print(" [" + printList(list.subList(startLocation, endLocation + 1)) + "] ");
			System.out.println(printList(list.subList(endLocation + 1, e.getExpression().size())));
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
	
	private IVisitable getOneOperand(ArrayList<String> expression, int i) throws ImproperQueryException {
		
		String operand = expression.get(i);
		IVisitable visitable = new TreeNode(operand);
		_end = i + 1;
		if (HelperFunctions.isOperator(operand)) {
			throw new ImproperQueryException(expression, i);
		} else if (HelperFunctions.getPrecedence(operand) == 3) {
			if (operand.equals(")")) {
				throw new ImproperQueryException(expression, i);
			} else {				
				int endLocation = HelperFunctions.getClosingParenthesis(expression, i);
				if (endLocation == i + 1) {
					throw new ImproperQueryException(expression, i, i + 1);
				}
				
				IVisitable subTree = generateBinaryTree(new ArrayList<String>(expression.subList(i + 1, endLocation)));
				if (subTree == null) {
					throw new ImproperQueryException(expression, i + 1, endLocation - 1);
				}
				
				visitable = new Parenthesis(subTree);
				
				_end = endLocation + 1;
			}
		}
		return visitable;
		
	}
	
	private String printList(List<String> list) {
		String output = "";
		for(int i = 0; i < list.size(); i++) {
			output += " " + list.get(i) + " ";
		}
		return output;
	}

}
