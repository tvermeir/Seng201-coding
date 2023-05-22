package coding201;

import java.util.Arrays;
import java.util.List;
/**
 * otherEvents
 * otherEvents contains a string of the possible events called in the matchRunner which do not result in a goal.
 * A list of the events can be returned.
 * @version 1.0
 * @author tve21 & bro82
 *
 */
public class otherEvents {

	String eventString = """
			has jumped in the air to attempt a bicycle, but failed to realise the ball was on the ground
			with a tremendous wind-up, has scuffed the ball and sent it just outside the far post
			has severely misjudged the location of the goal and has kicked it out for a throw in
			forgot to turn his monitor on and fired the ball backwards
			has sent the ball into the back of the net, then received a yellow card for taking his shirt off, only to realise he was offside
			has been absolutely crunched by the defender
			sticks his leg out but no penalty
			two foots a player and gets swarmed by the angry opposition supporters
			has the ball taken from his feet by a streaker
			
			""";
	/**
	 * Returns a list form of the eventString of possible events that are printed by the matchrunner.
	 * @return
	 */
	public List<String> getList() {
		List<String> items = Arrays. asList(eventString. split("\n"));
		return items;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
