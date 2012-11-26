public class MeanAverage {
	public static void main(String[] args) {
		MeanAverage m = new MeanAverage();
		m.run();
	}
	
	public void run() {
		System.out.println("How many numbers do you want to enter?");
		int divisor = 0;
		while(divisor == 0) {
			divisor = getUserInput();
			if(divisor == 0) {
				System.out.println("but it can't be equal to zero!");
			}
		}
		int[] input = new int[divisor];
		for(int i=0; i<divisor; i++) {
			System.out.print("Enter an integer:\t");
			input[i] = getUserInput();
		}
		double mean = 0;
		for(int i=0; i<divisor; i++) {
			mean += input[i];
		}
		mean = mean / divisor;
		System.out.println("The mean average of the numbers you entered is " + mean);
	}
	
	public int getUserInput() {
		int value = 0;
		boolean gotValidInput = false;
		while(!gotValidInput) {
			try {
				value = Integer.parseInt(System.console().readLine());
				gotValidInput = true;
			} catch (NumberFormatException ex) {
				System.out.println("That's not a number! Please try again.");
			}
		}
		return value;
	}
}