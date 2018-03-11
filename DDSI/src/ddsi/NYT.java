
package ddsi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class NYT extends API {

    private static NYT instance;
    public final String LINK = "https://api.nytimes.com/svc/search/v2/articlesearch.json";
    

    NYT() {
        APIKEY = "5458aa51a53f46aca077bbb434cfb197";
    }

    public static NYT getInstance() {
            if (instance == null){
                instance = new NYT();
            }
            return NYT.instance;
    }

    @Override
    protected String formatQuery(String query) {
        String q = "q="+query + "&fl=snippet";
        
        return q;
    }

    @Override
    public int apiCall(String query) {
        URL website = null;
        try {
            String link = LINK + "?api-key="+APIKEY + '&' + formatQuery(query);
            website = new URL(link);
            System.err.println(link);
            InputStream istream = website.openStream();
            Reader reader = new BufferedReader(new InputStreamReader(istream));
            JSONParser parser = new JSONParser();
            
            data = (JSONObject) parser.parse(reader);
        } catch (Exception ex) {
            System.err.println(ex.toString());
            ex.printStackTrace();
        }
        return 0;
    }
    
    public int mostPopular(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
