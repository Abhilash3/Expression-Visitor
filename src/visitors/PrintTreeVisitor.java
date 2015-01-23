package visitors;

import interfaces.IVisitor;
import vo.Parenthesis;
import vo.TreeNode;

public class PrintTreeVisitor implements IVisitor {
	
	private int level;
	
	public PrintTreeVisitor() {
		this.level = 0;
	}

	@Override
	public void visit(TreeNode treeNode) {		
		if (treeNode.getRightNode() != null) {
			level++;
			treeNode.getRightNode().accept(this);
			level--;
		}
		
		if (level > 0) {
			for (int i = 0; i < level - 1; i++) {
				System.out.print("|\t");
			}
			System.out.print("|-------");
		}
		System.out.println(treeNode.getRoot());

		if (treeNode.getLeftNode() != null) {
			level++;
			treeNode.getLeftNode().accept(this);
			level--;
		}
	}

	@Override
	public void visit(Parenthesis parenthesis) {
		if (level > 0) {
			for (int i = 0; i < level - 1; i++) {
				System.out.print("|\t");
			}
			System.out.print("|-------");
		}
		System.out.println("(");
		level++;
		parenthesis.getNode().accept(this);
		level--;
		if (level > 0) {
			for (int i = 0; i < level - 1; i++) {
				System.out.print("|\t");
			}
			System.out.print("|-------");
		}
		System.out.println(")");
	}

}
