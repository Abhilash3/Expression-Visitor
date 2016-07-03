package help;

import java.util.ArrayList;

import vo.visitable.IVisitable;
import vo.visitable.Parenthesis;
import vo.visitable.TreeNode;

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
		if (node.getLeftNode() == null && node.getRightNode() == null) {
			return getPrecedence(node.getRoot());
		}
		return 0;
	}

    public static int getPrecedence(String str) {
        switch (str) {
            case "(":
            case ")":
                return 3;
            case "*":
            case "/":
                return 2;
            case "+":
            case "-":
                return 1;
        }
        return 0;
    }
	
	public static boolean isOperator(String str) {
		return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
	}

	public static int getClosingParenthesis(ArrayList<String> expression,
			int startLocation) {
		int endLocation = startLocation + 1;
		for(int numOpenPara = 1; endLocation < expression.size(); endLocation++) {
			switch (expression.get(endLocation)) {
                case "(":
                    numOpenPara++;
                    break;
                case ")":
                    numOpenPara--;
                    break;
            }

			if (numOpenPara == 0) {
				break;
			}
		}
		return endLocation;
	}
}
