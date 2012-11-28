import java.io.*;
import java.util.List;
import java.util.ArrayList;
public class cat2 {
	public static void main(String[] args) {
		String[] filenames = null;
		List<File> files;
		BufferedReader in = null;
		try {
			filenames = args;
			for (String filename : filenames) {
				files.add(new File(filename));
			}

			for(File file : files) {
				if(file.isDirectory()) {
					System.out.println(filename + " is a directory!");
					continue;
				}
				
				in = new BufferedReader(new FileReader(file));
				
				System.out.println(filename + ":");
				String line;
				while((line = in.readLine()) != null) {
					System.out.println(line);
				}
			}
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("Must provide a file to cat: use >java cat <file name>");
		} catch (FileNotFoundException ex) {
			System.out.println("File " + filename + " does not exist");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(in != null) {
					in.close();
				}
			}catch (IOException ex) {
				System.out.println("Unable to close " + filename);
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
}