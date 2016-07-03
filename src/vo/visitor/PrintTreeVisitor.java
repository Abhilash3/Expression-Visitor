package vo.visitor;

import vo.visitable.Parenthesis;
import vo.visitable.TreeNode;

public class PrintTreeVisitor implements IVisitor {
	
	private int level;
    private static String PRE = "|------ ";
    private static String LEVEL = "|\t";
    private static String OPEN = "(";
    private static String CLOSE = ")";
	
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
		
		perLevel();
		System.out.println(treeNode.getRoot());

		if (treeNode.getLeftNode() != null) {
			level++;
			treeNode.getLeftNode().accept(this);
			level--;
		}
	}

	@Override
	public void visit(Parenthesis parenthesis) {
		perLevel();
		System.out.println(OPEN);

		level++;
		parenthesis.getNode().accept(this);
		level--;

        perLevel();
		System.out.println(CLOSE);
	}

    private void perLevel() {
        if (level > 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print(LEVEL);
            }
            System.out.print(PRE);
        }
    }

}
