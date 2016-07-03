package vo.visitor;

import vo.Operator;
import vo.visitable.Parenthesis;
import vo.visitable.TreeNode;

public class EvaluateVisitor implements IVisitor {

	@Override
	public void visit(TreeNode treeNode) {
		if (treeNode.getLeftNode() == null || treeNode.getRightNode() == null) {
			return;
		}
		
		treeNode.getLeftNode().accept(this);
        treeNode.getRightNode().accept(this);

		String left = treeNode.getLeftNode().toString();
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
