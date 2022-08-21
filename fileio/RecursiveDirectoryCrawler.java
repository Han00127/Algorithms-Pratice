package fileio;

import java.io.File;
import java.util.Scanner;

public class RecursiveDirectoryCrawler {

	private static Scanner console;
	// constructor same with 20 question 
	public RecursiveDirectoryCrawler() {
		console = new Scanner(System.in);
	}
	
	public void displayDirectory(File dir) {
		displayDirectory(dir, 0);
		
	}
	
	public void displayDirectory(File dir, int level) {
		for(int i =0; i < level; i++) {
			System.out.print("    ");
		}
		System.out.println(dir.getName());
		if(dir.isDirectory()) {
			for(File f: dir.listFiles()) {
				displayDirectory(f, level+1);
			}
		}	
	}
	
	public static void main(String[] args) {
		RecursiveDirectoryCrawler r = new RecursiveDirectoryCrawler();
		System.out.println("Enter a directory or folder ");
		String file = console.nextLine();
		File directory = new File(file);
		if(directory.exists()){
			r.displayDirectory(directory);
		}
		
	}

}
