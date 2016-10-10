package PracticeFusion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FindDoctors {
	
	public ArrayList<Doctor> getSimilarDoctors(Doctor selectedDoc, ArrayList<Doctor> list){
		
		ArrayList<Doctor> priorityList;		
		
		// returns the  list doctors with similar speciality of the selected doctor
		priorityList = getDoctorsWithSimilarSpeciality(list,selectedDoc);
		
		// algorithm to compare doctors with similar speciality 
		//and return the better doctor based on experience, review score and education
		sortPriorityDoctors(priorityList);
		
		// add the remaining doctor which have low proirity to end of the list
		addRemainingDoctors(priorityList,list);		
		
		return priorityList;
	}
	
	public static ArrayList<Doctor> getDoctorsWithSimilarSpeciality(ArrayList<Doctor> list,Doctor selectedDoc) {
		ArrayList<Doctor> priorityList = new ArrayList<>();
		for(Doctor doc : list){
			if(selectedDoc.getSpeciality() == doc.getSpeciality() && !doc.equals(selectedDoc)){
				priorityList.add(doc);
			}
		}
		return priorityList;
	}

	public static void sortPriorityDoctors(ArrayList<Doctor> priorityList){
		Collections.sort(priorityList, FindDoctors.sortBasedOnExpReviewEdu);
	}
	
	public static void addRemainingDoctors(ArrayList<Doctor> priorityList, ArrayList<Doctor> list){
		for(Doctor doc : list){
			if(!priorityList.contains(doc)){
				priorityList.add(doc);
			}
		}
	}

	public static Comparator<Doctor> sortBasedOnExpReviewEdu = new Comparator<Doctor>(){
		
		@Override
		public int compare(Doctor d1, Doctor d2) {
			int experience1 = d1.getYearsOfExperience();
			int experience2 = d2.getYearsOfExperience();
			int experience = experience2 - experience1; // return doctors based on experience
			
			if(experience == 0){
				int reviewScore = d2.getReviewScore() - d1.getReviewScore(); // for same experience check for review score
				
				if(reviewScore == 0){
					int educationLevel = d2.getEducationLevel() - d1.getEducationLevel(); // for same experience and review score check for education level
					return educationLevel;
				}
				return reviewScore;
			}
			return experience;
		}
		
	};
}
