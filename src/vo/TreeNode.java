package vo;

import interfaces.IVisitable;
import interfaces.IVisitor;

public class TreeNode implements IVisitable {
	
	private String root;
	private IVisitable leftNode;
	private IVisitable rightNode;

	public TreeNode(String root) {
		this.root = root;
	}
	
	public TreeNode(IVisitable leftNode, String root, IVisitable rightNode) {
		this.leftNode = leftNode;
		this.root = root;
		this.rightNode = rightNode;
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public IVisitable getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(IVisitable leftNode) {
		this.leftNode = leftNode;
	}

	public IVisitable getRightNode() {
		return rightNode;
	}

	public void setRightNode(IVisitable rightNode) {
		this.rightNode = rightNode;
	}
	
	@Override
	public String toString() {
		if (this.leftNode == null && this.rightNode == null) {
			return this.root;
		}
		return this.leftNode + " " + this.root + " " + this.rightNode;
	}

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

}
