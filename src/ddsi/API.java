
package ddsi;

public abstract class API {

	private JSONObject data;
	private String APIKEY;

	protected void storeData() {
		// TODO - implement API.storeData
		throw new UnsupportedOperationException();
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