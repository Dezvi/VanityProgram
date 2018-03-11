
package ddsi;

public class NYT extends API {

	private static NYT instance;

	private NYT() {
		// TODO - implement NYT.NYT
		throw new UnsupportedOperationException();
	}

	public static NYT getInstance() {
		return NYT.instance;
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