package sql;

/**
 * Contains all queries to create, delete, and access information from the
 * Endangered Species table.
 * 
 * @author Penny Chanthavong, et al.
 */
public class SqlEndangeredSpecies {

	/**
	 * Creates the EndangeredSpecies table.
	 * 
	 * @author Penny Chanthavong 
	 */
	public static String createTable() {

		return "CREATE TABLE EndangeredSpecies ( " + "Id int not null primary key " + "GENERATED ALWAYS AS IDENTITY "
				+ "(START WITH 1, INCREMENT BY 1), " + "CommonName varchar(255), " + "ScientificName varchar(255), "
				+ "Class varchar(255), " + "Population int, " + "ESA_Conservation_Status int, " + "ThreatId int, "
				+ "EffortId int " + ")";
	}

	/**
	 * Inserts data values into the EndangeredSpecies table.
	 * 
	 * @return
	 */
	public static String insertData() {
		return "INSERT INTO EndangeredSpecies "
				+ "(CommonName, ScientificName, Class, Population, ESA_Conservation_Status, ThreatId, EffortId) VALUES "
				+ "('Canada Lynx', 'Lynx canadensis', 'Mammal', 10, 124, 0, 12345), "
				+ "('Utah Prairie Dog', 'Cynomys parvidens', 'Mammal', 100, 124, 0, 12346), "
				+ "('Black-footed Ferret', 'Mustela nigripes', 'Mammal', 10, 126, 0, 12347), "
				+ "('California Condor', 'Gymnogyps californianus', 'Bird', 100, 123, 0, 12348), "
				+ "('Mexican Spotted Owl', 'Strix occidentalis lucida', 'Bird', 10, 124, 0, 12349), "
				+ "('Southwestern Willow Flycatcher', 'Empidonax traillii extimus', 'Bird', 100, 123, 0, 12350), "
				+ "('Gunnison Sage-grouse', 'Centrocercus minimus', 'Bird', 10, 124, 0, 12351), "
				+ "('Yellow-billed Cuckoo', 'Coccyzus americanus', 'Bird', 100, 124, 0, 12352), "
				+ "('Humpback Chub', 'Gila cypha', 'Fish', 10, 124, 0, 0), "
				+ "('Colorado Pikeminnow', 'Ptychocheilus lucius', 'Fish', 100, 123, 0, 0), "
				+ "('Greenback Cutthroat Trout', 'Oncorhynchus clarkii stomias', 'Fish', 10, 124, 0, 0),"
				+ "('Lahontan Cutthroat Trout', 'Oncorhynchus clarkii henshawi', 'Fish', 100, 124, 0, 0), "
				+ "('Woundfin', 'Plagopterus argentissimus', 'Fish', 10, 123, 0, 0), "
				+ "('Bonytail', 'Gila elegans', 'Fish', 100, 123, 0, 0), "
				+ "('Virgin River Chub', 'Gila seminuda', 'Fish', 10, 123, 0, 0), "
				+ "('June Sucker', 'Chasmistes liorus', 'Fish', 100, 124, 0, 0), "
				+ "('Razorback Sucker', 'Xyrauchen texanus', 'Fish', 10, 123, 0, 0), "
				+ "('Desert Tortoise', 'Gopherus agassizii', 'Reptile', 100, 124, 0, 0), "
				+ "('Shrubby Reed-mustard', 'Schoenocrambe suffrutescens', 'Plant', 10, 123, 0, 12353), "
				+ "('Dwarf Bear-poppy', 'Arctomecon humilis', 'Plant', 100, 123, 0, 12354), "
				+ "('Navajo Sedge', 'Carex specuicola', 'Plant', 10, 124, 0, 0), "
				+ "('Jones Cycladenia', 'Cycladenia humilis var. jonesii', 'Plant', 100, 124, 0, 0), "
				+ "('Barneby Ridge-cress', 'Lepidium barnebyanum', 'Plant', 10, 123, 0, 0), "
				+ "('Kodachrome Bladderpod', 'Lesquerella tumulosa', 'Plant', 100, 123, 0, 0), "
				+ "('Clay Phacelia', 'Phacelia argillacea', 'Plant', 10, 123, 0, 0), "
				+ "('Autumn Buttercup', 'Ranunculus aestivalis', 'Plant', 100, 123, 0, 0), "
				+ "('Wright Fishhook Cactus', 'Sclerocactus wrightiae', 'Plant', 10, 123, 0, 0), "
				+ "('Last Chance Townsendia', 'Townsendia aprica', 'Plant', 100, 124, 0, 0), "
				+ "('Welshs Milkweed', 'Asclepias welshii', 'Plant', 10, 124, 0, 0) ";
	}

	/**
	 * Inserts parameterized data into the Endangered Species table.
	 * 
	 * @param commonName
	 * @param scientificName
	 * @param animalClass
	 * @param population
	 * @param iucnStatus
	 * @param esaStatus
	 * @param threatId
	 * @param effortId
	 * @return
	 * @author Penny Chanthavong
	 */
	public static String insertDataWithParams(String commonName, String scientificName, String animalClass,
			int population, int esaStatus, int threatId, int effortId) {

		return "INSERT INTO EndangeredSpecies " + "(CommonName, ScientificName, Class, Population, "
				+ "ESA_Conservation_Status, ThreatId, EffortId) VALUES ('" + commonName + "', '" + scientificName
				+ "', '" + animalClass + "', " + population + ", " + esaStatus + ", " + threatId + ", " + effortId
				+ ")";
	}

	/**
	 * Drops the EndangeredSpecies table.
	 * 
	 * @return
	 * @author Penny Chanthavong
	 */
	public static String dropTable() {
		return "DROP TABLE EndangeredSpecies";
	}

	/**
	 * @return common names from table
	 */
	public static String getAllCommonNameCol() {
		return "SELECT CommonName FROM EndangeredSpecies";
	}

	/**
	 * Returns the common name of the species.
	 * 
	 * @param id of the species given by the primary key
	 * @return
	 * @author Penny Chanthavong
	 */
	public static String getCommonName(int id) {
		return "SELECT CommonName FROM EndangeredSpecies WHERE ID = " + id;
	}

	/**
	 * Returns the scientific name of the species.
	 * 
	 * @param id
	 * @return
	 * @author Penny Chanthavong
	 */
	public static String getSciName(int id) {
		return "SELECT ScientificName FROM EndangeredSpecies WHERE ID = " + id;
	}

	/**
	 * Returns species class based on ID.
	 * 
	 * @param id
	 * @return species assigned class
	 * @author Penny Chanthavong
	 */
	public static String getSpeciesClass(int id) {
		return "SELECT Class FROM EndangeredSpecies WHERE ID = " + id;
	}

	/**
	 * Returns the species population based on ID.
	 * 
	 * @param id
	 * @return species population
	 * @author Penny Chanthavong
	 */
	public static String getPopulation(int id) {
		return "SELECT Population FROM EndangeredSpecies WHERE ID = " + id;
	}

	/**
	 * Returns the ESA conservation status based on ID.
	 * 
	 * @param id
	 * @return species specific esa status
	 * @author Penny Chanthavong
	 */
	public static String getESA(int id) {
		return "SELECT ESA_Conservation_Status FROM EndangeredSpecies WHERE ID = " + id;
	}

	/**
	 * Returns the threat ID based on ID.
	 * 
	 * @param id
	 * @return threats to selected species
	 * @author Penny Chanthavong
	 */
	public static String getThreat(int id) {
		return "SELECT ThreatId FROM EndangeredSpecies WHERE ID = " + id;
	}

	/**
	 * Returns the effort ID based on ID.
	 * 
	 * @param id
	 * @return cons efforst for selected species
	 * @author Penny Chanthavong
	 */
	public static String getEffort(int id) {
		return "SELECT EffortId FROM EndangeredSpecies WHERE ID = " + id;
	}

	/**
	 * QUERY TO DELETE A ROW FROM ENDANGEREDSPECIES TABLE
	 * 
	 * @param id
	 * @return DELETES ROW
	 */
	public static String deleteSpeciesRow(int id) {
		return "DELETE FROM EndangeredSpecies WHERE ID = " + id;
	}

	/**
	 * Updates common name based on ID.
	 * 
	 * @param ID
	 * @param updatedData
	 */
	public static String updateCommonNameColumn(int ID, String updatedData) {
		System.out.println("ID to update: " + ID);
		System.out.println("String to enter: " + updatedData);
		return "UPDATE EndangeredSpecies SET CommonName = " + "'" + updatedData + "'" + " WHERE ID = " + ID;
	}

	/**
	 * Updates the scientific name based on ID.
	 * 
	 * @param ID
	 * @param updatedData
	 */
	public static String updateScientificNameColumn(int ID, String updatedData) {
		System.out.println("ID to update: " + ID);
		System.out.println("String to enter: " + updatedData);
		return "UPDATE EndangeredSpecies SET ScientificName = " + "'" + updatedData + "'" + " WHERE ID = " + ID;
	}

	/**
	 * Updates the class based on ID.
	 * 
	 * @param ID
	 * @param updatedData
	 */
	public static String updateClassColumn(int ID, String updatedData) {
		System.out.println("ID to update: " + ID);
		System.out.println("String to enter: " + updatedData);
		return "UPDATE EndangeredSpecies SET Class = " + "'" + updatedData + "'" + " WHERE ID = " + ID;
	}

	/**
	 * Updates the population based on ID.
	 * 
	 * @param ID
	 * @param updatedData
	 */
	public static String updatePopColumn(int ID, int updatedData) {
		System.out.println("ID to update: " + ID);
		System.out.println("Value to enter: " + updatedData);
		return "UPDATE EndangeredSpecies SET Population = " + updatedData + " WHERE ID = " + ID;
	}

	/**
	 * Updates the ESA based on ID.
	 * 
	 * @param ID
	 * @param updatedData
	 */
	public static String updateESAColumn(int ID, int updatedData) {
		System.out.println("ID to update: " + ID);
		System.out.println("Value to enter: " + updatedData);
		return "UPDATE EndangeredSpecies SET ESA_Conservation_Status = " + updatedData + " WHERE ID = " + ID;
	}

	/**
	 * Updates the threat ID.
	 * 
	 * @param ID
	 * @param updatedData
	 */
	public static String updateThreatIDColumn(int ID, int updatedData) {
		System.out.println("ID to update: " + ID);
		System.out.println("Value to enter: " + updatedData);
		return "UPDATE EndangeredSpecies SET ThreatId = " + updatedData + " WHERE ID = " + ID;
	}

	/**
	 * Updates the conservation effort ID.
	 * 
	 * @param ID
	 * @param updatedData
	 */
	public static String updateEffortIDColumn(int ID, int updatedData) {
		System.out.println("ID to update: " + ID);
		System.out.println("Value to enter: " + updatedData);
		return "UPDATE EndangeredSpecies SET EffortId = " + updatedData + " WHERE ID = " + ID;
	}

	/**
	 * Queries species by class.
	 * 
	 * @param s
	 * @return ALL SPECIES FROM A SELECTED CLASS
	 * @author Penny Chanthavong
	 */
	public static String returnSpeciesByClass(String s) {
		return "SELECT * FROM EndangeredSpecies WHERE Class = " + "'" + s + "'";
	}

	/**
	 * Queries specified species from EndangeredSpecies table.
	 * 
	 * @param s
	 * @return 
	 * @author Penny Chanthavong
	 */
	public static String returnSpecifiedSpecies(String s) {
		return "SELECT CommonName, Population FROM EndangeredSpecies WHERE Class = " + "'" + s + "'";
	}

	/**
	 * Queries common name, scientific name, ESA conservation status based on ESA_Conservation_Status.
	 * 
	 * @param selectedStatus
	 * @return 
	 * @author Penny Chanthavong
	 */
	public static String returnSpecifiedStatus(int selectedStatus) {
		return "SELECT CommonName, ScientificName, ESA_Conservation_Status, Population FROM EndangeredSpecies WHERE ESA_Conservation_Status = "
				+ selectedStatus + "";
	}

	/**
	 * Queries all species ordered by ascending order.
	 * 
	 * @return All species ordered by lowest population numbers
	 */
	public static String sortByPopulation() {
		return "SELECT CommonName, ScientificName, Population FROM EndangeredSpecies ORDER BY Population";
	}

	/**
	 * Queries database and returns common name, scientific name, population ordered by population.
	 * 
	 * @return All species, specific columns, ordered by lowest population numbers
	 */
	public static String sortRetPartialByPopulation() {
		return "SELECT CommonName, ScientificName, Population FROM EndangeredSpecies ORDER BY Population";
	}

	/**
	 * @return ALL SORT BY ID
	 */
	public static String orderById() {
		return "SELECT * From EndangeredSpecies ORDER BY ID ASC";
	}

	/**
	 * @return ALL SORT BY NAME
	 */
	public static String orderByName() {
		return "SELECT * From EndangeredSpecies ORDER BY CommonName ASC";
	}

	/**
	 * @return ALL ORDERD BY POP
	 */
	public static String orderByPopulation() {
		return "SELECT * FROM EndangeredSpecies ORDER BY Population ASC";
	}

	/**
	 * Selects and returns all data from the EndangeredSpecies table.
	 */
	public static String allData() {
		return "SELECT * FROM EndangeredSpecies";

	}

}