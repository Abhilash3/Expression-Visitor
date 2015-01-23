package visitors;

import interfaces.IVisitor;
import vo.Parenthesis;
import vo.TreeNode;

public class EvaluateVisitor implements IVisitor {

	@Override
	public void visit(TreeNode treeNode) {
		if (treeNode.getLeftNode() == null && treeNode.getRightNode() == null) {
			return;
		}
		
		treeNode.getLeftNode().accept(this);
		String left = treeNode.getLeftNode().toString();
		
		treeNode.getRightNode().accept(this);
		String right = treeNode.getRightNode().toString();
		
		String output = "";
		String operator = treeNode.getRoot();
		if (operator.equals("+")) {
			output = Float.toString(Float.parseFloat(left) + Float.parseFloat(right));
		} else if (operator.equals("-")) {
			output = Float.toString(Float.parseFloat(left) - Float.parseFloat(right));
		} else if (operator.equals("*")) {
			output = Float.toString(Float.parseFloat(left) * Float.parseFloat(right));
		} else if (operator.equals("/")) {
			output = Float.toString(Float.parseFloat(left) / Float.parseFloat(right));
		}
		
		treeNode.setRoot(output);
		treeNode.setLeftNode(null);
		treeNode.setRightNode(null);
	}

	@Override
	public void visit(Parenthesis parenthesis) {
		parenthesis.getNode().accept(this);
	}

	
	
}
