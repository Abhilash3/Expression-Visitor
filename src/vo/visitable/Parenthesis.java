package vo.visitable;

import vo.visitor.IVisitor;

public class Parenthesis implements IVisitable {
	
	private IVisitable node;
	
	public Parenthesis(IVisitable node) {
		this.node = node;
	}

	public IVisitable getNode() {
		return node;
	}

	public void setNode(IVisitable node) {
		this.node = node;
	}
	
	@Override
	public String toString() {
		return this.node.toString();
	}

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

}
