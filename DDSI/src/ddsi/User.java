
package ddsi;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class User {

	private String name;
	private String password;
	private String email;
        
        static DBConnection dataBase;

        private Analizer analizer;
        private Query query;
	/**
	 * 
	 * @param name
	 * @param password
	 * @param email
	 */
	public User(String name, String password, String email) {
                //dataBase = null;
                System.out.println("Introduzca direccion de la BD: ");
                Scanner f = new Scanner(System.in);
                String addr;
                addr = f.next();
                
		dataBase = new DBConnection(addr, 3306, "ddsi", name, password);
                analizer = new Analizer();
                query = new Query();
	}

	/**
	 * 
	 * @param name
	 * @param password
	 */
	public int signIn(String name, String password) {
		// TODO - implement User.signIn
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 * @param password
	 */
	public int logIn(String name, String password) {
		// TODO - implement User.logIn
		throw new UnsupportedOperationException();
	}

	public void signOut() {
		// TODO - implement User.signOut
		throw new UnsupportedOperationException();
	}

	public void logOut() {
		// TODO - implement User.logOut
		throw new UnsupportedOperationException();
	}
        

	/**
	 * 
	 * @param type
	 * @param request
	 */
	public ArrayList<String> doRequest(RequestType type, String request, SearchType search) throws SQLException {
            
            ArrayList<String> result = new ArrayList<>();
            
            query.doRequest(type, request, search);
            
            switch(type){
                
                case PRESS:
                    
                    switch(search){
                        case MOST_POPULAR_TITLES:
                            result = analizer.mostPopularsTitles(type);
                            break;
                        case FIND_WORD_IN_TITLE:
                            result = analizer.getOcurrencesTitles(type, request, "nyt");
                            break;
                        case NUM_OCURRENCES_IN_TITLE:
                            result.add(String.valueOf(analizer.getNumOccurrencesTitles(type, request, "nyt")));
                            break;
                    }
                    break;
                    
                case SOCIALNETWORK:
                    break;
                case REVIEW:
                    break;
            }
            
            return result;
	}

	public String[] getPastRequest() {
		// TODO - implement User.getPastRequest
		throw new UnsupportedOperationException();
	}

}