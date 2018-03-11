
package ddsi;


import java.sql.SQLException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public abstract class API {

	protected JSONObject data;
	protected String APIKEY;
        private boolean Table_created = false;

        
        public void storeData(){ 
            try {
                if(User.dataBase != null)
                    Table_created = User.dataBase.checkIfTableExists(this.getClass().getSimpleName());
                if(!Table_created){
                    //Se crea la tabla
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            JSONArray response = (JSONArray)((JSONObject) data.get("response")).get("docs"); 
            storeData(response);
        }
        
	private void storeData(JSONArray response) {
            Iterator it = response.iterator();
            JSONObject x = null;
            while (it.hasNext()) {
                x = (JSONObject) it.next();
                
                String query = "INSERT INTO " + this.getClass().getSimpleName() + " (snippet,score)" + " VALUES ('"+ x.get("snippet") +"'," + x.get("score") +")";
                System.out.println(query);
                
                User.dataBase.execute(query);
            }
	}
	/**
	 * 
	 * @param query
	 */
	protected abstract String formatQuery(String query);

	/**
	 * 
	 * @param query
	 */
	public abstract int apiCall(String query);

}
