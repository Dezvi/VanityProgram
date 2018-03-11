package ddsi;

import java.util.ArrayList;

public class PressQuery {

        ArrayList<API> newsPapers;
    
        public PressQuery(){
            newsPapers = new ArrayList<>();
            NYT nyt = NYT.getInstance();
            
            newsPapers.add(nyt);
        }
	/**
	 * 
	 * @param word
	 */
	public void findWord(String word) {
            newsPapers.forEach((a) -> {
                if (a.apiCall(word) == -1){
                    System.err.println("Error in API call");
                }
            });
	}

	public void mostPopular(){
            if (((NYT)newsPapers.get(newsPapers.size()-1)).mostPopular() == -1){
                System.err.println("Error in API call");
            }
            
	}

}