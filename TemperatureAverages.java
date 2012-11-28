import java.util.List;
import java.util.LinkedList;
import java.io.*;
public class TemperatureAverages {
	public static void main(String[] args) {
		String filename = null;
		File file;
		BufferedReader in = null;
		int temprCount = 0; // running total of number of temperatures in the file
		double temprSum = 0;   // sum of the temperatures in the file
		double totalAvg = 0;
		List<Double> lineAvgLst = new LinkedList<Double>(); // container for line averages
		try {
			filename = args[0];
			file = new File(filename);
			in = new BufferedReader(new FileReader(file));
			String line;
			while((line = in.readLine()) != null) {
				String[] tempr_strs = line.split(",");
				int lineCount = tempr_strs.length;
				double lineSum = 0;
				for(String tempr_str : tempr_strs) {
					lineSum += Double.parseDouble(tempr_str.trim());
				}
				lineAvgLst.add(lineSum / lineCount);
				temprSum += lineSum;
				temprCount += lineCount;
			}
			System.out.println("Mean temperatures for each line in " + filename + ":");
			for(Double lineAvg : lineAvgLst) {
				System.out.println("\t" + lineAvg);
			}
			totalAvg = temprSum / temprCount;
			System.out.println("Mean temperature for whole of file " + filename + ":");
			System.out.println("\t" + totalAvg);
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("Must provide a file to read: use >java TemperatureAverages <file containing temperatures>.csv");
		} catch (FileNotFoundException ex) {
			System.out.println("File " + filename + " does not exist.");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
}