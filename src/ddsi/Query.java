
package ddsi;

// We register the MySQL (MariaDB) driver
// Registramos el driver de MySQL (MariaDB)


import java.sql.Date;

public class Query {

	private Date date;

	/**
	 * 
	 * @param type
	 * @param request
     * @return 
	 */
	public void doRequest(RequestType type, String request) {
		// TODO - implement Query.doRequest
                String requestFormated[] = formatRequest(request);
                if(null != type)switch (type) {
                case PRESS:{
                    PressQuery query = new PressQuery();
                    if(requestFormated[0].contentEquals("mostPopular"))
                        query.mostPopular();
                    else if(requestFormated[0].contentEquals("findWord"))
                        query.findWord(requestFormated[1]);
                        break;
                    }
                case SOCIALNETWORK:{
                    SocialNetworkQuery query = new SocialNetworkQuery();
                    query.findWord(requestFormated[1]);
                        break;
                    }
                case REVIEW:{
                    ReviewQuery query = new ReviewQuery();
                    query.findWord(requestFormated[1]);
                        break;
                    }
                default:
                    break;
            }
	}

	/**
	 * 
	 * @param request
	 */
	private String[] formatRequest(String request) {
		// TODO - implement Query.formatRequest
                String[] word = new String[2];
                if(request.contains("mas popular") || request.contains("most popular")){
                    word[0] = "mostPopular";
                }else{
                    word[0] = "findWord";
                    word[1] = request.substring(request.lastIndexOf(" ")+1);
                }
                
                return word;
	}

}