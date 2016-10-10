package PracticeFusion;

public class Doctor {
	private String speciality;
	private int reviewScore;
	private int yearsOfExperience;
	private String education;
	private int educationLevel;
	
	// qualifications to consider for relevant doctors in the future
	private String areaOfResearch; 
	private String jobTitle;
	
	public Doctor(String speciality, int reviewScore, int yearsOfExperience, String education){
		this.speciality = speciality;
		this.reviewScore = reviewScore;
		this.yearsOfExperience = yearsOfExperience;
		this.education = education;
		this.educationLevel = setEducationLevel(education);
	}
	
	private static int setEducationLevel(String education){
		int level = 0;
		if(education.equalsIgnoreCase("associate")){
			level = 1;
		}
		if(education.equalsIgnoreCase("bachelors")){
			level = 2;
		}
		if(education.equalsIgnoreCase("masters")){
			level = 3;
		}
		if(education.equalsIgnoreCase("doctorate")){
			level = 4;
		}
		return level;
	}
	
	public String getSpeciality(){
		return speciality;
	}
	public int getReviewScore(){
		return reviewScore;
	}
	public int getYearsOfExperience(){
		return yearsOfExperience;
	}
	public String getEducation(){
		return education;
	}
	public int getEducationLevel(){
		return educationLevel;
	}	
	
	public String toString(){
		return "speciality:"+speciality + " reviewScore:"+reviewScore+" experience:"+yearsOfExperience+" education:"+education;
	}
}


