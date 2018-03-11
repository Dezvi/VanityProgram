package ddsi;

import java.util.HashMap;

public class DataCache {

	private HashMap<String, Boolean> table;
	private static DataCache instance;

	public DataCache() {
		// TODO - implement DataCache.DataCache
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public void add(String id) {
		// TODO - implement DataCache.add
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public boolean check(String id) {
		// TODO - implement DataCache.check
		throw new UnsupportedOperationException();
	}

	public static DataCache getInstance() {
		return DataCache.instance;
	}

}