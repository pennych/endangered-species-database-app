package main;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import sql.SqlConservationEffort;
import sql.SqlESAConservationStatus;
import sql.SqlEndangeredSpecies;
import sql.SqlRegion;
import sql.SqlThreat;

/**
 * Creates a connection to the database and has methods to query the database.
 * 
 * @author Penny Chanthavong
 *
 */
public class DBConnection {
	private static String databaseURL = "jdbc:derby:EndangeredSpeciesDB;create=true";

	/**
	 * Performs initial set up of the database and SQL tables.
	 * 
	 * @author Penny Chanthavong
	 */
	public static void setUpSQL() {
		try (Connection connection = DriverManager.getConnection(databaseURL);
				Statement statement = connection.createStatement();) {

			/*
			 * Author: Michal Dabrowski Date: 2021 Availability:
			 * https://www.baeldung.com/jdbc-check-table-exists
			 */
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[] { "TABLE" });

			if (!resultSet.next()) {
				// setup for EndangeredSpecies table
				statement.execute(SqlEndangeredSpecies.createTable());
				statement.execute(SqlEndangeredSpecies.insertData());
				// statement.execute(SqlEndangeredSpecies.dropTable());

				// setup for ESAConservationStatus table
				statement.execute(SqlESAConservationStatus.createTable());
				statement.execute(SqlESAConservationStatus.insertData());
				// statement.execute(SqlESAConservationStatus.dropTable());

				// setup for Threat table
				statement.execute(SqlThreat.createTable());
				statement.execute(SqlThreat.insertData());
				// statement.execute(SqlThreat.dropTable());

				// setup for ConservationEffort table
				statement.execute(SqlConservationEffort.createTable());
				statement.execute(SqlConservationEffort.insertData());
				// statement.execute(SqlConservationEffort.dropTable());

				// setup for Region table
				statement.execute(SqlRegion.createTable());
				statement.execute(SqlRegion.insertData());
				// statement.execute(SqlRegion.dropTable());
			}
			// printTableResultSets(statement); // used for positive testing database
			System.out.println("done");

		} catch (SQLException e) {
			System.out.println("sql state: " + e.getSQLState());
			e.printStackTrace();
		}

	}

	/**
	 * Prints table result sets to the console. Primarily used to test that data has
	 * been loaded to the database.
	 * 
	 * @param statement
	 * @throws SQLException
	 * 
	 * @author Penny Chanthavong
	 */
	@SuppressWarnings("unused")
	private static void printTableResultSets(Statement statement) throws SQLException {
		// prints data from the EndangeredSpecies table
		ResultSet results = statement.executeQuery(SqlEndangeredSpecies.allData());
		System.out.println("Endangered Species table");
		System.out.println("________________________");
		System.out.printf("%-3s %-30s %-35s %-10s %-11s %-11s %-10s %-10s%n", "ID", "Common name", "Scientific name",
				"Class", "Population", "ESA Status", "ThreatId", "EffortId");
		while (results.next()) {
			int Id = results.getInt("Id");
			String commonName = results.getString("CommonName");
			String scientificName = results.getString("ScientificName");
			String classification = results.getString("Class");
			int population = results.getInt("Population");
			int esaStatus = results.getInt("ESA_Conservation_Status");
			int threatId = results.getInt("ThreatId");
			int effortId = results.getInt("EffortId");

			System.out.printf("%-3d %-30s %-35s %-10s %-11d %-11d %-10d %-10d%n", Id, commonName, scientificName,
					classification, population, esaStatus, threatId, effortId);
		}
		System.out.println();

		// prints data from the ESAConservationStatus table
		results = statement.executeQuery(SqlESAConservationStatus.allData());
		System.out.println("ESA Categories table");
		System.out.println("____________________");
		System.out.printf("%-6s %-8s%n", "ID", "ESA Status");
		while (results.next()) {
			int Id = results.getInt("ID");
			String status = results.getString("Status");
			System.out.printf("%-6d %-8s%n", Id, status);
		}
		System.out.println();

		// prints data from the Threat table
		results = statement.executeQuery(SqlThreat.allData());
		System.out.println("Threat Types table");
		System.out.println("__________________");
		System.out.printf("%-3s %-25s%n", "ID", "Threat Description");
		while (results.next()) {
			int Id = results.getInt("ID");
			String description = results.getString("Description");
			System.out.printf("%-3d %-25s%n", Id, description);
		}
		System.out.println();

		// prints data from the ConservationEffort table
		results = statement.executeQuery(SqlConservationEffort.allData());
		System.out.println("Conservation Efforts table");
		System.out.println("__________________________");
		System.out.printf("%-7s %-13s %-16s %-25s %-14s %-25s %-20s %-8s%n", "ID", "Status", "Start Date", "Species",
				"Organization", "Website", "Conservation_Status", "Location");
		while (results.next()) {
			int id = results.getInt("cID");
			String status = results.getString("Status");
			String date = results.getString("StartDate");
			int species = results.getInt("Associated_species");
			String org = results.getString("Organization");
			String orgURL = results.getString("Website");
			int cStatus = results.getInt("ConservationStatus");
			String loc = results.getString("Location");
			System.out.printf("%-7s %-13s %-16s %-25d %-14s %-25s %-20d %-8s%n", id, status, date, species, org, orgURL,
					cStatus, loc);
		}
	}

	/**
	 * Joins two tables and returns the value from the Status column.
	 * 
	 * @param query
	 * @return string value from the Status column
	 * @author Penny Chanthavong
	 */
	public static String executeQueryGetStatusInnerJoin(String query) {
		StringBuilder sb = new StringBuilder();
		try (Connection connection = DriverManager.getConnection(databaseURL);
				Statement statement = connection.createStatement();) {
			ResultSet results = statement.executeQuery(query);
			while (results.next()) {
				String s = results.getString("Status");
				sb.append(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * Returns data based on the query and column specified.
	 * 
	 * @param query
	 * @param colName
	 * @return
	 * @author Penny Chanthavong
	 */
	public static String executeQueryReturnDataOnColumn(String query, String colName) {
		StringBuilder sb = new StringBuilder();
		try (Connection connection = DriverManager.getConnection(databaseURL);
				Statement statement = connection.createStatement();) {
			ResultSet results = statement.executeQuery(query);
			while (results.next()) {
				sb.append(results.getString(colName));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * Returns all conservation effort data.
	 * 
	 * @param query
	 * @return
	 * @author Penny Chanthavong
	 */
	public static String executeQueryReturnAllCEData(String query) {
		StringBuilder sb = new StringBuilder();
		try (Connection connection = DriverManager.getConnection(databaseURL);
				Statement statement = connection.createStatement();) {
			ResultSet results = statement.executeQuery(query);

			sb.append(String.format("%-7s %-20s %-9s %-14s %-25s %-30s %-8s%n", "ID", "Start Date", "Species",
					"Organization", "Website", "Conservation Status", "Location"));

			while (results.next()) {
				int id = results.getInt("cID");
				String date = results.getString("StartDate");
				int species = results.getInt("Associated_species");
				String org = results.getString("Organization");
				String orgURL = results.getString("Website");
				int cStatus = results.getInt("ConservationStatus");
				String loc = results.getString("Location");

				sb.append(String.format("%-7s %-20s %-9d %-14s %-25s %-30d %-8s%n", id, date, species, org, orgURL,
						cStatus, loc));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * Returns selected data from EndangeredSpecies table based on string query.
	 * 
	 * @author Penny C. & et al
	 * @param query
	 * @return common name, scientific name, ESA status, and population.
	 */
	public static String executeQueryReturnSelectedData(String query) {
		StringBuilder sb = new StringBuilder();
		try (Connection connection = DriverManager.getConnection(databaseURL);
				Statement statement = connection.createStatement();) {
			ResultSet results = statement.executeQuery(query);

			sb.append(String.format("%-15s %-33s %-33s %-11s %-11s\n", "ID", "Common name", "Scientific name",
					"ESA Status", "Population"));

			while (results.next()) {
				String id = results.getString("Id");
				String commonName = results.getString("CommonName");
				String scientificName = results.getString("ScientificName");
				int esaStatus = results.getInt("ESA_Conservation_Status");
				int population = results.getInt("Population");
				System.out.printf("%-15s %-33s %-33s %-11d %-11d\n", id, commonName, scientificName, esaStatus,
						population);

				sb.append(String.format("%-15s %-33s %-33s %-11d %-11d\n", id, commonName, scientificName, esaStatus,
						population));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * Returns all data from EndangeredSpecies table and displays in Species Query
	 * panel.
	 * 
	 * @param query
	 * @return
	 * @author Penny Chanthavong
	 */
	public static String executeQueryReturnAllEndangeredSpeciesData(String query) {
		StringBuilder sb = new StringBuilder();
		try (Connection connection = DriverManager.getConnection(databaseURL);
				Statement statement = connection.createStatement();) {
			ResultSet results = statement.executeQuery(query);

			sb.append(String.format("%-3s %-33s %-33s %-10s %-11s %-11s %-10s %-10s%n", "ID", "Common name",
					"Scientific name", "Class", "Population", "ESA Status", "ThreatId", "EffortId"));

			while (results.next()) {
				int id = results.getInt("Id");
				String commonName = results.getString("CommonName");
				String scientificName = results.getString("ScientificName");
				String classification = results.getString("Class");
				int population = results.getInt("Population");
				int esaStatus = results.getInt("ESA_Conservation_Status");
				int threatId = results.getInt("ThreatId");
				int effortId = results.getInt("EffortId");

				sb.append(String.format("%-3d %-33s %-33s %-10s %-11d %-11d %-10d %-10d%n", id, commonName,
						scientificName, classification, population, esaStatus, threatId, effortId));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * Updates a column based on the passed in string query.
	 * 
	 * @param query
	 */
	public static void updateColumnFromTable(String query) {
		try (Connection connection = DriverManager.getConnection(databaseURL);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Executes the SQL query passed to the method.
	 * 
	 * @param query
	 */
	public static void executeSQLQuery(String query) {
		try (Connection connection = DriverManager.getConnection(databaseURL);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Performs query to get ESA id from ESAConservation table.
	 * 
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public static String printESAID(String query) throws SQLException {
		StringBuilder sb = new StringBuilder();
		try (Connection connection = DriverManager.getConnection(databaseURL);
				Statement statement = connection.createStatement();) {
			ResultSet results = statement.executeQuery(query);
			while (results.next()) {
				sb.append(results.getString("ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb.toString();

	}

	/**
	 * Returns all data from Region table.
	 * 
	 * @param query
	 * @return
	 */
	public static String executeQueryReturnAllRegionData(String query) {
		StringBuilder sb = new StringBuilder();
		try (Connection connection = DriverManager.getConnection(databaseURL);
				Statement statement = connection.createStatement();) {
			ResultSet results = statement.executeQuery(query);

			sb.append(String.format("%-5s %-20s %-20s %-20s %-20s%n", "ID", "District", "Closures",
					"Endangered Species", "Threats"));

			while (results.next()) {
				int Id = results.getInt("ID");
				String district = results.getString("District");
				boolean closure = results.getBoolean("Closures");
				int species = results.getInt("Endangered_species");
				int threat = results.getInt("Threats");

				sb.append(String.format("%-5d %-20s %-20s %-20d %-20d%n", Id, district, closure, species, threat));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
