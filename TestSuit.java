package PracticeFusion;

import java.util.ArrayList;
import org.junit.Assert;

public class TestSuit {
	private static ArrayList<Doctor> list;
	
	private static Doctor doc1 = new Doctor("a",1,1,"associate");
	private static Doctor doc2 = new Doctor("a",2,2,"associate");
	private static Doctor doc3 = new Doctor("a",2,2,"masters");
	private static Doctor doc4 = new Doctor("a",3,2,"bachelors");
	private static Doctor doc5 = new Doctor("a",1,3,"doctorate");
	private static Doctor doc6 = new Doctor("b",1,2,"doctorate");
	private static Doctor doc7 = new Doctor("b",1,3,"bachelors");
	
	public static void main(String[] args) {	
		
		
		assignDataToTest(); // creates 7 doctors with different qualifications and adds them to the list
		checkForSimilarSpeciality(); // (for doc6) check if the doctors with similar speciality are seperated
		checkForProperOrdering(); // (for doc1) check if the doctors are ordered according to the algorithm. The algorithm is mentioned in the readme file
		checkForFirstElement(); // check if top of list is as predicted
	}

	private static void checkForFirstElement() {
		
		ArrayList<Doctor> tempList = new ArrayList<>();
		tempList.add(doc5);
		tempList.add(doc4);
		tempList.add(doc3);
		tempList.add(doc2);
		ArrayList<Doctor> priorityList = FindDoctors.getDoctorsWithSimilarSpeciality(list, doc1);
		FindDoctors.sortPriorityDoctors(priorityList);
		
		Assert.assertEquals(tempList.get(0), priorityList.get(0));
	}

	private static void checkForProperOrdering() {
		ArrayList<Doctor> tempList = new ArrayList<>();
		tempList.add(doc5);
		tempList.add(doc4);
		tempList.add(doc3);
		tempList.add(doc2);
		ArrayList<Doctor> priorityList = FindDoctors.getDoctorsWithSimilarSpeciality(list, doc1);
		FindDoctors.sortPriorityDoctors(priorityList);
		Assert.assertEquals(tempList, priorityList);
	}

	private static void checkForSimilarSpeciality() {
		ArrayList<Doctor> tempList = new ArrayList<>();
		tempList.add(doc7);
		
		Assert.assertEquals(tempList, FindDoctors.getDoctorsWithSimilarSpeciality(list, doc6));
		
	}

	private static void assignDataToTest() {
		
		list = new ArrayList<Doctor>();
		list.add(doc1);
		list.add(doc2);
		list.add(doc3);
		list.add(doc4);
		list.add(doc5);
		list.add(doc6);
		list.add(doc7);
		

	}

	
}
