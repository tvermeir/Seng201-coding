package coding201;

import java.util.Arrays;
import java.util.List;
/**
 * Goal Events
 *This class contains a set of strings in an array list that are called whenever your team and the opposition score a goal
 *@version 1.0
 *@author tve21 & bro82
 */
public class goalEvents {
	String goalString = """
			rifles a shot into the top corner
			has sent the keeper and ran it in
			has turned in the box and slotted it nicely bottom left
			has elastico'd the defender and walked it in
			has tapped it in after his teammate sweats it across the goal
			the starboy spread's the legs of the defenders before lifting the ball over the keeper 
			has gone down in the box, Penalty and Goal for Argentina
			
			""";
	
	/* The method converts the string above into an arraylist, splitting the strings by the new line (\n) parameter*/
	public List<String> getList() {
		List<String> items = Arrays. asList(goalString. split("\n"));
		return items;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
