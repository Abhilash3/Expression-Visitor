package exception;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class ImproperQueryException extends Exception {
	
	private ArrayList<String> expression;
	private int startLocation;
	private int endLocation;

	public ImproperQueryException(ArrayList<String> expression, int location) {
		this.expression = expression;
		this.startLocation = location;
		this.endLocation = location;
	}
	
	public ImproperQueryException(ArrayList<String> expression, int startLocation, int endLocation) {
		this.expression = expression;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
	}
	
	public ArrayList<String> getExpression() {
		return expression;
	}
	
	public int getStartLocation() {
		return startLocation;
	}
	
	public int getEndLocation() {
		return endLocation;
	}
	
}
