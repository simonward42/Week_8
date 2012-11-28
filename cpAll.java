import java.io.*;
public class cpAll {
	public static void main(String[] args) {
		String[] filenames = args;
		if(filenames.length != 2) {
			System.out.println("Please provide two file names: >java cp <src_file> <dest_file>");
			return;
		}
		String src_name, dst_name;
		src_name = filenames[0];
		dst_name = filenames[1];
		File src, dst;
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			src = new File(src_name);
			dst = new File(dst_name);
			if(src.isDirectory() || dst.isDirectory()) {
				System.out.println("Cannot copy to or from a directory: please provide two files");
				return;
			}
			if(!src.exists()) {
				System.out.println("Source " + src_name +" does not exist.");
				return;
			} else { // We're okay to copy - just need to check if dst exists...
				if(dst.exists()) {
					System.out.println("Destination " + dst_name + " already exists, do you want to overwrite?");
					boolean goodChoice = false;
					do {
						System.out.println("<enter y or n>");
						String choice = System.console().readLine();
						switch(choice) {
							case "n" :
								return; // get out if no overwrite
							case "y":
								goodChoice = true;
								break; // break and carry on
							default:
								System.out.println(choice + " not an option, please try again.");
						} 
					} while(!goodChoice);
				}
				// Now to perform the copy
				in = new BufferedReader(new FileReader(src));
				out = new PrintWriter(dst);
				String line;
				while((line = in.readLine()) != null) {
					out.println(line);
				}
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Cannot read from " + src_name + " or write to " + dst_name + ".");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(in != null) in.close();
				if(out != null) out.close();
			} catch (IOException ex) {
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}		
	}
	
}