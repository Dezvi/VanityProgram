
package ddsi;

// We register the MySQL (MariaDB) driver
// Registramos el driver de MySQL (MariaDB)


import java.sql.Date;

public class Query {

	private Date date;
        
        PressQuery queryPress = new PressQuery();
        SocialNetworkQuery querySocialNetwork = new SocialNetworkQuery();
        ReviewQuery queryReview = new ReviewQuery();

	/**
	 * 
	 * @param type
	 * @param request
         * @param search
	 */
	public void doRequest(RequestType type, String request, SearchType search) {
		// TODO - implement Query.doRequest
                //String requestFormated[] = formatRequest(request);
                switch (type) {
                case PRESS:
                    
                    switch(search){
                        case MOST_POPULAR_TITLES:
                            queryPress.mostPopular();
                            break;
                        case FIND_WORD_IN_TITLE:
                        case NUM_OCURRENCES_IN_TITLE:
                            queryPress.findWord(request);                            
                            break;
                    }
                    break;
                    
                case SOCIALNETWORK:
                    
                    querySocialNetwork.findWord(request);
                    break;
                case REVIEW:
                    
                    queryReview.findWord(request);
                    break;
                    
                default:
                    break;
            }
                
	}	

}
