package trees;


import java.io.PrintWriter;


public class IntTree {
 private IntTreeNode overallRoot;

 // post: constructs an empty tree
 public IntTree() {
     overallRoot = null;
 }

 // post: constructs an tree with the overallRoot set to root
 public IntTree(IntTreeNode root) {
	 this.overallRoot=root;
 }
 
 // pre : tree is a binary search tree
 // post: value is added to overall tree so as to preserve the binary search
 //       tree property
 public void add(int value) {
     overallRoot = add(overallRoot, value);
 }

 // post: value is added to given binary search tree so as to preserve the
 //       binary search tree property
 private IntTreeNode add(IntTreeNode root, int value) {
     if(root == null) {
    	 root = new IntTreeNode(value);
     }
     else if(value <= root.data) {
    	 root.left = add(root.left,value);
     }
     else {  // value > root.data traverse tree on right
    	 root.right = add(root.right,value);   // X = change 
     }
     return root;
 }
 // post: returns true in value is in the tree
 public boolean contains(int value) {
	 return contains(overallRoot, value);
 }
 
 private boolean contains(IntTreeNode root, int value) {
	if(root != null) {
		if(root.data == value) {
			return true;
		}
		else if (value < root.data) {
			return contains(root.left, value);
		}
		else {
			return contains(root.right,value);
		}
	}
	 return false;
 }
 // writes tree out to a file in preorder format identifying each node as "leaf" or "branch"
 public void writeTree(PrintWriter fileOut) {
	 writeTree(overallRoot, fileOut);
 }
 // Writing out to file in pre order print data first , left, right
 private void writeTree(IntTreeNode root, PrintWriter fileOut) {
	 if(root != null) {
		 // if the root is a leaf node
		 if(root.left == null && root.right == null) {
			fileOut.println("Leaf Node: " + root.data); 
		 }
		 else {
			 fileOut.println("Branch Node: " + root.data);
		 }
		 // Traverse left
		 writeTree(root.left, fileOut);
		 writeTree(root.right,fileOut);
	 }
	 

	 
 }
 // post: prints the tree contents using a preorder traversal
 public void printPreorder() {
     System.out.print("preorder:");
     printPreorder(overallRoot);
     System.out.println();
 }

 // post: prints in preorder(data left right) the tree with given root
 private void printPreorder(IntTreeNode root) {
   
 }

 // post: prints the tree contents using an inorder traversal
 public void printInorder() {
     System.out.print("inorder:");
     printInorder(overallRoot);
     System.out.println();
 }

 // post: prints in inorder(left data right) the tree with given root
 private void printInorder(IntTreeNode root) {
    
 }

 // post: prints the tree contents using a postorder traversal
 public void printPostorder() {
     System.out.print("postorder:");
     printPostorder(overallRoot);
     System.out.println();
 }

 //    prints in postorder(left, right, data) the tree with given root
 private void printPostorder(IntTreeNode root) {
  
 }

 //       prints the tree contents, one per line, following an
 //       inorder traversal and using indentation to indicate node
 //       depth; prints right to left so that it looks correct when
 //       the output is rotated; prints "empty" for an empty tree
 public void printSideways() {
     if (overallRoot == null) {
         System.out.println("empty tree");
     } else {
         printSideways(overallRoot, 0);
     }
 }

 //       prints in reversed preorder the tree with given root,
 //       indenting each line to the given level
 private void printSideways(IntTreeNode root, int level) {
    if(root != null) {
    	printSideways(root.right, level+1);
    	for(int i=0; i < level; i++) {
    		System.out.print("      ");
    	}
    	System.out.println(root.data);
    	printSideways(root.left, level + 1);
    }
 }
 
 
 
}