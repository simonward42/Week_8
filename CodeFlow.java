/**
 *	Code flow in the following situations (using given line numbers):
 *	-- userInput is 0
 *		(lines executed) = 	1, 2, 3, 4, 5, 6, 7, 8, 9, 
 *							10 (removes 1 from intList),
 *							11 (prints 2 to screen),
 *							12 (removes 2 from intList),
 *							13 (prints 3 to screen),
 *							14 (removes 3),
 *							15 (prints 4),
 *							16 (removes 4),
 *							17 (prints 5),
 *							18 (removes 5),
 *							19 (prints 6),
 *							20 (removes 6),
 *							21 (throws IndexOutOfBoundsException),
 *							24 (catches),
 *							25 (prints StackTrace), 26, 27.
 *
 *	-- userInput is 2
 *		executes: 	1,2,3,4,5,6,7,8,9,10(-1),11(4),12(-2),13(5),14(-3),15(6),16(-4),
 *					17(throws),24,...
 *
 *	-- userInput is 4
 *		executes:	1,...,10(-1),11(6),12(-2),13(throws),24,...
 *
 * 	-- userInput is 6
 *		executes:	1,...,10(-1),11(throws),24(catches),...
 */


public class CodeFlow {
	public static void main(String[] args) {
		CodeFlow cf = new CodeFlow();
		cf.launch(0);
		cf.launch(2);
		cf.launch(4);
		cf.launch(6)
	}
	01 public void launch(int userInput) {
		02 List<Integer> intList = new ArrayList<Integer>();
		03 intList.add(1);
		04 intList.add(2);
		05 intList.add(3);
		06 intList.add(4);
		07 intList.add(5);
		08 intList.add(6);
		09 try {
			10 intList.remove(0);
			11 System.out.println(intList.get(userInput));
			12 intList.remove(0);
			13 System.out.println(intList.get(userInput));
			14 intList.remove(0);
			15 System.out.println(intList.get(userInput));
			16 intList.remove(0);
			17 System.out.println(intList.get(userInput));
			18 intList.remove(0);
			19 System.out.println(intList.get(userInput));
			20 intList.remove(0);
			21 System.out.println(intList.get(userInput));
			22 intList.remove(0);
			23 System.out.println(intList.get(userInput));
			24 } catch (IndexOutOfBoundsException ex) {
				25 ex.printStackTrace();
		26 }
	27 }
}