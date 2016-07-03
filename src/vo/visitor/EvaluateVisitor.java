package vo.visitor;

import vo.visitable.Parenthesis;
import vo.visitable.TreeNode;

public class EvaluateVisitor implements IVisitor {

	private enum Operator {
		PLUS("+") {
			@Override
			public String operate(String a, String b) {
				return Float.toString(Float.parseFloat(a) + Float.parseFloat(b));
			}
		},
		MINUS("-") {
			@Override
			public String operate(String a, String b) {
				return Float.toString(Float.parseFloat(a) - Float.parseFloat(b));
			}
		},
		MULTIPLY("*") {
			@Override
			public String operate(String a, String b) {
				return Float.toString(Float.parseFloat(a) * Float.parseFloat(b));
			}
		},
		DIVIDE("/") {
			@Override
			public String operate(String a, String b) {
				return Float.toString(Float.parseFloat(a) / Float.parseFloat(b));
			}
		};

		private String operator;

		Operator(String operator) {
			this.operator = operator;
		}

		public abstract String operate(String a, String b);

		public static Operator getOperator(String s) {
			for (Operator o : Operator.values()) {
				if (o.operator.equals(s))
					return o;
			}
			throw new IllegalArgumentException("Not a valid operator: "+s);
		}

	}

	@Override
	public void visit(TreeNode treeNode) {
		if (treeNode.getLeftNode() == null || treeNode.getRightNode() == null) {
			return;
		}
		
		treeNode.getLeftNode().accept(this);
		String left = treeNode.getLeftNode().toString();
		
		treeNode.getRightNode().accept(this);
		String right = treeNode.getRightNode().toString();

		String output = Operator.getOperator(treeNode.getRoot()).operate(left, right);
		
		treeNode.setRoot(output);
		treeNode.setLeftNode(null);
		treeNode.setRightNode(null);
	}

	@Override
	public void visit(Parenthesis parenthesis) {
		parenthesis.getNode().accept(this);
	}

	
	
}
