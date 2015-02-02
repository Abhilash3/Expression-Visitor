package help;

import java.util.ArrayList;

import interfaces.IVisitable;
import vo.*;

public final class HelperFunctions {
	
	public static int getPrecedence(IVisitable visitable) {
		if (visitable instanceof TreeNode) {
			return getPrecedence((TreeNode) visitable);
		} else {
			return getPrecedence((Parenthesis) visitable);
		}
	}
	
	private static int getPrecedence(Parenthesis paren) {
		return getPrecedence(paren.getNode());
	}

	private static int getPrecedence(TreeNode node) {
		int precedence = 0;
		if (node.getLeftNode() == null && node.getRightNode() == null) {
			String str = node.getRoot();
			if (str.equals("(") || str.equals(")")) {
				precedence = 3;
			} else if (str.equals("*") || str.equals("/")) {
				precedence = 2;
			} else if (str.equals("+") || str.equals("-")) {
				precedence = 1;
			}
		}
		return precedence;
	}
	
	public static boolean isOperator(String str) {
		return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
	}

	public static int getClosingParenthesis(ArrayList<String> expression,
			int startLocation) {
		int endLocation = startLocation + 1;
		for(int numOpenPara = 1; endLocation < expression.size(); endLocation++) {
			String object = expression.get(endLocation);
			if (object.toString().equals("(")) {
				numOpenPara++;
			} else if (object.toString().equals(")")) {
				numOpenPara--;
			}
			if (numOpenPara == 0) {
				break;
			}
		}
		return endLocation;
	}

	public static int getPrecedence(String str) {
		int precedence = 0;
		if (str.equals("(") || str.equals(")")) {
			precedence = 3;
		} else if (str.equals("*") || str.equals("/")) {
			precedence = 2;
		} else if (str.equals("+") || str.equals("-")) {
			precedence = 1;
		}
		return precedence;
	}
}
