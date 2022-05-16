package sql;

/**
 * Provides SQL statements related to the ESAConservationStatus table.
 * 
 * @author Penny Chanthavong, et al.
 */
public class SqlESAConservationStatus {

	/**
	 * Creates the ConservationStatus table.
	 * 
	 * @return string query
	 * @author Penny Chanthavong
	 */
	public static final String createTable() {
		return "CREATE TABLE ESAConservationStatus "
				+ "( " + "ID int not null primary key "
				+ "GENERATED ALWAYS AS IDENTITY " 
				+ "(START WITH 123, INCREMENT BY 1), " 
				+ "Status varchar(255) " + ")";
	}

	/**
	 * Drops the ESAConservationStatus table.
	 * 
	 * @return string query
	 * @author Penny Chanthavong
	 */
	public static String dropTable() {
		return "DROP TABLE ESAConservationStatus";
	}

	/**
	 * Inserts data values into the ESAConservationStatus table.
	 * 
	 * @return string query
	 * @author Penny Chanthavong
	 */
	public static String insertData() {
		return "INSERT INTO ESAConservationStatus " + "(Status) VALUES " + "('Endangered'), " + "('Threatened'), "
				+ "('Candidate'), " + "('Experimental Essential'), " + "('Proposed Endangered'), "
				+ "('Proposed Threatened'), " + "('Emergency Endangered'), " + "('Species of Concern') ";
	}

	/**
	 * Returns the status.
	 * 
	 * @return string query
	 * @author Penny Chanthavong
	 */
	public static String getStatus() {
		return "SELECT Status FROM ESAConservationStatus";
	}

	/**
	 * Selects and returns all data from the ConservationStatus table.
	 * 
	 * @return string query
	 * @author Penny Chanthavong
	 */
	public static String allData() {
		return "SELECT * FROM ESAConservationStatus";
	}

	/**
	 * 
	 * @param category
	 * @return CONS STATUS ID BASED ON CATEGORY SELECTED
	 */
	public static String getESAID(String category) {
		return "SELECT ID FROM ESAConservationStatus WHERE Status = " + "'" + category + "'";

	}
}