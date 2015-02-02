package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import binarytree.BinaryTreeGenerator;
import interfaces.IVisitable;
import visitor.*;

public class Main {

	public static void main(String... args) {
		
		//String str = "10,+,(,1,+,(,1,+,(,10,-,8,),+,20,/,4,),*,2,),+,(,10,+,(,5,*,6,),),+,(,23,+,7,-,3,-,2,),*,4";
		
		System.out.println("Enter your Expression: ");
		String str = new Scanner(System.in).nextLine();
		
		ArrayList<String> expression = new ArrayList<String>(Arrays.asList(str.split(",")));
		
		IVisitable tree = new BinaryTreeGenerator().generateBinaryTree(expression);
		if (tree == null) {
			return;
		}

		tree.accept(new PrintExpVisitor());
		System.out.println("\n");
		tree.accept(new PrintTreeVisitor());
		tree.accept(new EvaluateVisitor());
		
		System.out.print("\n" + tree);
		
	}
	
}
