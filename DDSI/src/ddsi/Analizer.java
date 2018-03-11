package ddsi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Analizer {

	/**
	 * 
	 * @param type
	 * @param request
         * @param table
         * @return 
         * @throws java.sql.SQLException
	 */
	public int getNumOccurrencesTitles(RequestType type, String request, String table) throws SQLException {
            int ocurrences = 0;
            ResultSet result;
            
            switch(type){
                
                case PRESS:
                    
                    result = User.dataBase.query("SELECT COUNT(*) FROM "+table+" WHERE title LIKE '%"+request+"%'");
                    
                    while(result.next()){
                        ocurrences = result.getInt("count(*)");
                    }
                    break;
                    
                case SOCIALNETWORK:
                    break;
                case REVIEW:
                    break;
            }
            
            return ocurrences;
	}

	/**
	 * 
	 * @param type
         * @return 
         * @throws java.sql.SQLException
	 */
	public ArrayList<String> mostPopularsTitles(RequestType type) throws SQLException {
            ResultSet result;
            ArrayList<String> mostPop = new ArrayList<>();
            
            switch(type){
                
                case PRESS:
                    
                    result = User.dataBase.query("SELECT title FROM mostpopularNYT");
                    
                    while(result.next()){
                        mostPop.add(result.getString("title"));
                    }
                    break;
                    
                case SOCIALNETWORK:
                    break;
                case REVIEW:
                    break;
            }
            
            return mostPop;
	}

	/**
	 * 
	 * @param type
	 * @param request
         * @param table
         * @return 
         * @throws java.sql.SQLException
	 */
	public ArrayList<String> getOcurrencesTitles(RequestType type, String request, String table) throws SQLException {
            ResultSet result;
            ArrayList<String> ocurrences = new ArrayList<>();
            
            switch(type){
                
                case PRESS:
                    
                    result = User.dataBase.query("SELECT title FROM "+table+" WHERE title LIKE '%"+request+"%'");
                    
                    while(result.next()){
                        ocurrences.add(result.getString("title"));
                    }
                    break;
                    
                case SOCIALNETWORK:
                    break;
                case REVIEW:
                    break;
            }
            
            return ocurrences;
	}

}