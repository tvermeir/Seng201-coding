package coding201;

import java.util.Arrays;
import java.util.List;

public class goalEvents {
	String goalString = """
			rifles a goal into the top corner
			has sent the keeper and ran it in
			has turned in the box and slotted it nicely bottom left
			has elastico'd the defender and walked it in
			has tapped it in after his teammate sweats it across the goal
			""";
	
	public List<String> getList() {
		List<String> items = Arrays. asList(goalString. split("\n"));
		return items;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
