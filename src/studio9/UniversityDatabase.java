package studio9;

import assignment7.Student;

import java.util.HashMap;
import java.util.Map;

public class UniversityDatabase {
	
	//TODO: Complete this class according to the studio instructions
	private final Map<String, Student> database;
	
	/**
	 * @param database
	 */
	public UniversityDatabase() {
		super();
		this.database = new HashMap<>();
	}
	
	public void addStudent(String accountName, Student student) {
		// TODO
		this.database.put(accountName, student);
	}

	public int getStudentCount() {
		// TODO
		return this.database.size();
	}

	public String lookupFullName(String accountName) {
		// TODO: Complete according to studio instructions
		if (this.database.containsKey(accountName)) {
			return this.database.get(accountName).getFullName();
		}
		else {
			return null;
		}
		
	}

	public double getTotalBearBucks() {
		// TODO
		double totalBearBucks = 0;
		for (String accountName : this.database.keySet()) {
			totalBearBucks += this.database.get(accountName).getBearBucksBalance();
		}
		return totalBearBucks;
	}
}
