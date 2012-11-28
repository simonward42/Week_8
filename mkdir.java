import java.io.*;
public class mkdir {
	public static void main(String[] args) {
		String dirname;
		try {
			dirname = args[0];
			File newdir = new File(dirname);
			if(newdir.mkdir()) {
				System.out.println("Dir " + dirname + " successfully created");
			} else {
				System.out.println("Unable to create directory " + dirname);
			}
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("Must provide a name for new dir: use >java mkdir <dir name>");
		}
	}
}