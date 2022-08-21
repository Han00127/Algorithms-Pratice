package trees;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TreeTester {

	public static void main(String[] args) {
	
	    testWriteTree();
		testReadTree();
	    testTighten();
	    testEquals();
		

	}
	
	
	
	public static void testReadTree() {
		System.out.println("\n Read Tree");
		IntTree treeRead = new IntTree();  //overallRoot == null
		try (Scanner fileIn = new Scanner(new File("files/tree1.txt"))) {
			treeRead.readTree(fileIn);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		treeRead.printSideways();
		treeRead.printPreorder();
	}
	//     8          Code 3 branch with left and right child
	//    /  \
	//   6   10       Code 3 branch with left and right child
	//  /    / \
	// 5     9  11    Code 0 leaf
	//        \
	//         7      Code 0 leaf nod
	public static void testWriteTree() {
		IntTreeNode root = new IntTreeNode(8);
		root.left = new IntTreeNode(6);
		root.right = new IntTreeNode(10);

		root.left.left = new IntTreeNode(5);
		root.right.left = new IntTreeNode(9);
		root.right.right = new IntTreeNode(11);

		root.right.left.right = new IntTreeNode(7);
		IntTree t = new IntTree(root);

		t.printSideways();

		try (PrintWriter fileOut = new PrintWriter(new File("files/tree1.txt"))) {
			t.writeTree(fileOut);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void testTighten() {
		IntTree t2 = new IntTree();
		t2.add(8);
		t2.add(7);
		t2.add(19);
		t2.add(3);
		t2.add(9);
		t2.add(2);
		t2.add(4);
		t2.add(12);
		t2.add(5);
		t2.add(10);
		t2.add(13);
		
		System.out.println("Before tighten");
		t2.printPreorder();
		System.out.println("After tighten");
		t2.tighten();
		t2.printPreorder();	
		t2.printSideways();
	}
	
       //  8
	//    /  \
	//   6   10
	//  / \   / \
	// 5   7  9  11
	//        
	//         	
	public static void testEquals() {
		IntTree t1 = new IntTree();
		t1.add(8);
		t1.add(6);
		t1.add(10);
		t1.add(5);
		t1.add(9);
		t1.add(11);
		t1.add(7);
		
		
		IntTree t2 = new IntTree();
		t2.add(8);
		t2.add(6);
		t2.add(10);
		t2.add(5);
		t2.add(9);
		t2.add(11);
		t2.add(7);
		t2.add(-5);
		
		System.out.println(t1.equals(t2));
	}
  

}
