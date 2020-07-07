import java.util.List;
import java.util.ArrayList;

public class AMZ_Assessment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = new ArrayList<>();
		names.add("DCF");
		names.add("ABC");
		boolean test = names.get(0).contains("BC");
		System.out.println(test);
		
		System.out.println(names);
		java.util.Collections.sort(names);
		System.out.println(names);
		
		ArrayList<String> top = new ArrayList<>();
		top.add("abc");
		System.out.println(top);
		
		
		
	}
	
	public ArrayList<String> topNCompetitors(int numCompetitors, int topNCompetitors, List<String> competitors,
			int numReviews, List<String> reviews) {
// WRITE YOUR CODE HERE
// output
		ArrayList<String> topN = new ArrayList<>();

// sort competitor names
		java.util.Collections.sort(competitors);

// count number of mentions in reviews for each competitor by name
		int[] mentions = new int[numCompetitors];
		for (int i = 0; i < numCompetitors; i++) {
			for (int j = 0; j < numReviews; j++) {
				if (reviews.get(j).contains(competitors.get(i))) {
					mentions[i]++;
				}
			}
		}

// identify topN competitors by mentions
		int topNAdded = 0;
		int maxReview = 0;
		while (topNAdded < topNCompetitors) {
// identify max number of the mentions array
			for (int i = 0; i < mentions.length; i++) {
				if (mentions[i] > maxReview) {
					maxReview = mentions[i];
				}
			}
// add competitor with max number of mentions to topN list
			for (int i = 0; i < numCompetitors; i++) {
				if (maxReview == mentions[i]) {
					topN.add(competitors.get(i));
					mentions[i] = 0; // take it out of the array after adding to the topN list
					topNAdded++;
				}
			}
		}

		return topN;
	}

}
