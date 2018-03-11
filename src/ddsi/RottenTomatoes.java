
package ddsi;

public class RottenTomatoes extends API {

	private static RottenTomatoes instance;

	private RottenTomatoes() {
		// TODO - implement RottenTomatoes.RottenTomatoes
		throw new UnsupportedOperationException();
	}

	public static RottenTomatoes getInstance() {
		return RottenTomatoes.instance;
	}

    @Override
    protected String formatQuery(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int apiCall(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}