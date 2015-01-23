package visitors;

import interfaces.IVisitor;
import vo.Parenthesis;
import vo.TreeNode;

public class PrintExpVisitor implements IVisitor {

	@Override
	public void visit(TreeNode treeNode) {
		if (treeNode.getLeftNode() != null) {
			treeNode.getLeftNode().accept(this);
			System.out.print(" ");
		}
		System.out.print(treeNode.getRoot());
		if (treeNode.getRightNode() != null) {
			System.out.print(" ");
			treeNode.getRightNode().accept(this);
		}
	}

	@Override
	public void visit(Parenthesis parenthesis) {
		System.out.print("( ");
		parenthesis.getNode().accept(this);
		System.out.print(" )");
	}
	
	

}
