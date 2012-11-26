import java.util.List;
import java.util.ArrayList;
public class Exercise2 {
	public static void main(String[] args) {
		// Some code here
		List<Integer> list;
		int newElement = 6;
		try {
		// more code here
		list.add(newElement);
		// more code here
		} catch (Exception ex) {
		ex.printStackTrace();
		} catch (NullPointerException ex) {
		ex.printStackTrace();
		}
	}
}