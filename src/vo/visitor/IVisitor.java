package vo.visitor;

import vo.visitable.Parenthesis;
import vo.visitable.TreeNode;

public interface IVisitor {

    void visit(TreeNode treeNode);

    void visit(Parenthesis parenthesis);

}
