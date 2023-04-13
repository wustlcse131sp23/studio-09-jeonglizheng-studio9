package assignment7;

//TODO: Copy a working Student class from Assignment 7 over this file.

public class Student {
	
	// Instance Variables
	private String firstName;
	private String lastName;
	private int id;
	private int[] attemptedCredits;
	private int[] passingCredits;
	private double[] attemptedGrades;
	private double[] passingGrades;
	private double totalGradeQualityPoints;
	private double gradePointAverage;
	private double bearBucksBalance;
	
	// Static Variables
	public static int numOfAttemptedCourses = 0;
	public static int numOfPassedCourses = 0;
	
	/**
	 * Constructor: Create a Student object (Initialize all the instance variables)
	 * @param firstName: student first name
	 * @param lastName: student last name
	 * @param id: student ID
	 */
	public Student(String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.attemptedCredits = new int[5000];
		this.passingCredits = new int[5000];
		this.attemptedGrades = new double[5000];
		this.passingGrades = new double[5000];
		this.totalGradeQualityPoints = 0.0;
		this.gradePointAverage = 0.0;
		this.bearBucksBalance = 0.0;
	}
	
	/**
	 * getFullName: Get the full name of a Student
	 * @return the full name of a Student
	 */
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

	/**
	 * getId: Get the student ID
	 * @return the student ID
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * submitGrade: Submit the information of a new grade (with its credits), 
	 * update related instance variables
	 * @param grade: new grade
	 * @param credits: the credits of the new grade
	 */
	public void submitGrade(double grade, int credits) {
		numOfAttemptedCourses++;
		this.attemptedCredits[numOfAttemptedCourses - 1] = credits;
		this.attemptedGrades[numOfAttemptedCourses - 1] = grade;
		
		if (grade >= 1.7) {
			numOfPassedCourses++;
			this.passingCredits[numOfPassedCourses - 1] = credits;
			this.passingGrades[numOfPassedCourses - 1] = grade;
		}
		
		this.gradePointAverage = this.calculateGradePointAverage();
		
	}
	
	/**
	 * getTotalAttemptedCredits: Calculate the total attempted credits
	 * @return the total attempted credits
	 */
	public int getTotalAttemptedCredits() {
		int totalAttemptedCredits = 0;
		for (int i = 0; i < numOfAttemptedCourses; i++) {
			totalAttemptedCredits += this.attemptedCredits[i];
		}
		return totalAttemptedCredits;
	}
	
	/**
	 * getTotalPassingCredits: Calculate the total passing credits
	 * @return the total passing credits
	 */
	public int getTotalPassingCredits() {
		int totalPassingCredits = 0;
		for (int i = 0; i < numOfPassedCourses; i++) {
			totalPassingCredits += this.passingCredits[i];
		}
		return totalPassingCredits;
	}
	
	/**
	 * calculateGradePointAverage: Calculate GPA
	 * @return GPA
	 */
	public double calculateGradePointAverage() {
		totalGradeQualityPoints = 0;
		for (int i = 0; i < numOfAttemptedCourses; i++) {
			totalGradeQualityPoints += this.attemptedCredits[i] * this.attemptedGrades[i];
		}
		this.gradePointAverage = totalGradeQualityPoints / this.getTotalAttemptedCredits();
		return this.gradePointAverage;
	}
	
	/**
	 * getClassStanding: Decide the class of a student based on his/her total passing credits
	 * @return class of a student
	 */
	public String getClassStanding() {
		if (this.getTotalPassingCredits() < 30) {
			return "First Year";
		}
		else if (this.getTotalPassingCredits() >= 30 && this.getTotalPassingCredits() < 60) {
			return "Sophomore";
		}
		else if (this.getTotalPassingCredits() >= 60 && this.getTotalPassingCredits() < 90) {
			return "Junior";
		}
		else {
			return "Senior";
		}
	}
	
	/**
	 * isEligibleForPhiBetaKappa: Decide if a student is elligible for Phi Beta Kappa
	 * based on the total attempted credits and GPA
	 * @return if a student is elligible for Phi Beta Kappa
	 */
	public boolean isEligibleForPhiBetaKappa() {
		if (this.getTotalAttemptedCredits() >= 98 && this.calculateGradePointAverage() >= 3.6) {
			return true;
		}
		else if (this.getTotalAttemptedCredits() >= 75 && this.calculateGradePointAverage() >= 3.8) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * deductBearBucks: Deduct an amount from bearBucksBalance
	 * @param amount
	 * @return updated bearBucksBalance
	 */
	public double deductBearBucks(double amount) {
		if (this.bearBucksBalance - amount >= 0) {
			this.bearBucksBalance -= amount;
		}
		return this.bearBucksBalance;
		
	}
	
	/**
	 * depositBearBucks: Add an amount to bearBucksBalance
	 * @param amount
	 * @return updated bearBucksBalance
	 */
	public double depositBearBucks(double amount) {
		this.bearBucksBalance += amount;
		return this.bearBucksBalance;
	}
	
	/**
	 * getBearBucksBalance: get the newest bearBucksBalance
	 * @return getBearBucksBalance
	 */
	public double getBearBucksBalance() { 
		return this.bearBucksBalance;
	}
	
	/**
	 * cashOutBearBucks: Calculate bearBucksBalance after cashing out and the cash received
	 * @return cash received
	 */
	public double cashOutBearBucks(){
		if (this.bearBucksBalance <= 10) {
			this.bearBucksBalance = 0;
			return 0.0;
		}
		else {
			double cash = this.bearBucksBalance - 10;
			this.bearBucksBalance = 0;
			return cash;
		}
		
	}
	
	/**
	 * createLegacy: Create a piece of information for the legacy of two alumni
	 * @param firstName: first name of this parent
	 * @param otherParent: another parent
	 * @param isHyphenated: if the last name of the legacy is hyphenated
	 * @param id: student ID for the legacy
	 * @return legacy
	 */
	public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id) {
		String newLastName;
		if (isHyphenated) {
			newLastName = this.lastName + "-" + otherParent.lastName;
		}
		else {
			newLastName = this.lastName;
		}
		Student legacy = new Student(firstName, newLastName, id);
		legacy.bearBucksBalance = this.cashOutBearBucks() + otherParent.cashOutBearBucks();
		return legacy;
	}
	
	// toString for Student
	public String toString() {
		return this.getFullName() + " " + this.getId();
	}

	// Getter for firstName
	public String getFirstName() {
		return firstName;
	}

	// Setter for firstName
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// Getter for lastName
	public String getLastName() {
		return lastName;
	}

	// Setter for lastName
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// Getter for attemptedCredits
	public int[] getAttemptedCredits() {
		return attemptedCredits;
	}

	// Getter for passingCredits
	public int[] getPassingCredits() {
		return passingCredits;
	}

	// Getter for attemptedGrades
	public double[] getAttemptedGrades() {
		return attemptedGrades;
	}

	// Getter for passingGrades
	public double[] getPassingGrades() {
		return passingGrades;
	}

	// Getter for gradePointAverage
	public double getGradePointAverage() {
		return gradePointAverage;
	}

	// Getter for numOfAttemptedCourses
	public static int getNumOfAttemptedCourses() {
		return numOfAttemptedCourses;
	}

	// Getter for numOfPassedCourses
	public static int getNumOfPassedCourses() {
		return numOfPassedCourses;
	}
}
