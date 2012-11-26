public class MeanAverage {
	public static void main(String[] args) {
		MeanAverage m = new MeanAverage();
		m.run();
	}
	
	public void run() {
		int[] input = new int[10];
		for(int i=0; i<10; i++) {
			System.out.println("Enter an integer:\t");
			input[i] = getUserInput();
		}
		double mean;
		for(int i=0; i<10; i++) {
			mean += input[i];
		}
		mean = mean / 10;
		System.out.println("The mean average of the numbers you entered is " + mean);
	}
	
	public int getUserInput() {
		int value;
		boolean gotValidInput = false;
		while(!gotValidInput) {
			try {
			value = Integer.parseInt(System.console.readLine());
			gotValidInput = true;
			} catch (NumberFormatException ex) {
				System.out.println("That's not a number! Please try again.");
			}
		}
		return value;
	}
}