import java.io.*;
public class ls {
	public static void main(String[] args) {
		File currentDir = new File(".");
		String[] fileList = currentDir.list();
		for(String filename : fileList) {
			System.out.println("\t" + filename);
		}
	}
	
}