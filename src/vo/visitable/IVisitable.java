package vo.visitable;

import vo.visitor.IVisitor;

public interface IVisitable {
	
	void accept (IVisitor visitor);

}
