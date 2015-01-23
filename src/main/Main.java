package main;

import java.util.ArrayList;
import java.util.Arrays;

import binarytree.BinaryTreeGenerator;
import interfaces.IVisitable;
import visitor.*;
import vo.TreeNode;

public class Main {

	public static void main(String... args) {
		
		System.out.println("Enter your Expression: ");
		String str = new Scanner(System.in).nextLine();
		ArrayList<String> preDefinedExpression = new ArrayList<String>(Arrays.asList(str.split(",")));
		ArrayList<IVisitable> expression = new ArrayList<IVisitable>();
		
		for(int i = 0; i < preDefinedExpression.size(); i++) {
			expression.add(new TreeNode(preDefinedExpression.get(i)));
		}
		
		IVisitable tree = new BinaryTreeGenerator().generateBinaryTree(expression);

		tree.accept(new PrintExpVisitor());
		System.out.println("\n");
		tree.accept(new PrintTreeVisitor());
		tree.accept(new EvaluateVisitor());
		
		System.out.print("\n" + tree);
		
	}
	
}
