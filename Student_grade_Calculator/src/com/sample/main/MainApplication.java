package com.sample.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainApplication {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter how many subject  and name of the subjects in the course ::");

		int totalSubject = scanner.nextInt();
		scanner.nextLine();
		
		String[]subjectName = new String[totalSubject];
		for(int i=0;i<totalSubject;i++) {
			subjectName[i] = scanner.nextLine();
		}
		
		int[]marks = new int[totalSubject];
		Map<String, String>map = new HashMap<String, String>();
		
		
		int totalMark = 0;

		for (int i = 0; i < totalSubject; i++) {
			
			System.out.println("Please enter the mark of "+subjectName[i]+" subject :::");
			

			int mark = scanner.nextInt();
			
			if(mark>=75) {
				map.put(subjectName[i],"DISTN");
			}
			
			if(mark<33) {
				map.put(subjectName[i], "#");
			}

			marks[i] = mark;
			
			totalMark += mark;
		}

		scanner.close();
		
		System.out.println();
		StringBuilder sb = new StringBuilder();
		sb.append("===========================OPEN SCORE CARD=======================================\n");
		sb.append(String.format("%1$20s", "Subject Name")+""+String.format("%1$12s", "mark obtain")+""+String.format("%1$10s", "remark")+"\n");
		
		for(int i=0;i<subjectName.length;i++) {
			
			if(map.containsKey(subjectName[i])) {
				sb.append(String.format("%1$20s", subjectName[i])+String.format("%1$12s", marks[i])+String.format("%1$10s", map.get(subjectName[i]))+"\n");
			}else {
				sb.append(String.format("%1$20s", subjectName[i])+String.format("%1$12s", marks[i])+"\n");
			}
			
		}
		sb.append("\n          Total Marks :  "+totalMark+"\n");
		sb.append("===========================END SCORE CARD===================================================");
		
		
		int average_percentage = totalMark / totalSubject;

		String grade = null;

		if (average_percentage >= 80) {
			grade = "A+";
		} else if (average_percentage >= 60 && average_percentage < 80) {
			grade = "A";
		} else if (average_percentage >= 50 && average_percentage < 60) {
			grade = "B";
		} else if (average_percentage >= 40 && average_percentage < 50) {
			grade = "C";
		} else if (average_percentage >= 33 && average_percentage < 40) {
			grade = "D";
		} else {
			grade = "E";
		}

		if (average_percentage >= 33) {
			System.out.println("You passed the exam , total_marks = " + totalMark + " and percentage = "
					+ average_percentage + "% with grade = " + grade);
		} else {
			System.out.println("you failed the exam, total_marks = " + totalMark + " and percentage = "
					+ average_percentage + "% with grade = " + grade);
		}
		
		
		System.out.println("\n\n");
		
		System.out.println("Here is the score card of the student :::\n");
		System.out.println();
		System.out.println(sb.toString());
	}

}
