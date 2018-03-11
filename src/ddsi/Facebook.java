
package ddsi;

public class Facebook extends API {

	private static Facebook instance;

	private Facebook() {
		// TODO - implement Facebook.Facebook
		throw new UnsupportedOperationException();
	}

	public static Facebook getInstance() {
		return Facebook.instance;
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