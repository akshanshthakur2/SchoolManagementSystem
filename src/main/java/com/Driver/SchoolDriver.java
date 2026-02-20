package com.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Entity.Principal;
import com.Entity.School;
import com.Entity.Student;
import com.Service.Service;

public class SchoolDriver {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Service service=new Service();
		
		while(true) {
			System.out.println("\n ========== WELCOME ==========\n");
			System.out.println("1. Add School with Principal & Students");
	        System.out.println("2. Find School");
	        System.out.println("3. Update School Name");
	        System.out.println("4. Remove School");
	        System.out.println("5. Exit");

	        System.out.print("Enter choice: ");
	        int choice = sc.nextInt();
	        
	        switch (choice) {
			case 1:
				School school= new School();
				System.out.println("Enter School ID: ");
				int sc_id= sc.nextInt();
				sc.nextLine();
				school.setId(sc_id);
				System.out.println("Enter School Name: ");
				String sc_name= sc.nextLine();
				school.setName(sc_name);
				
				Principal principal = new Principal();
				System.out.println("Enter Principal ID: ");
				int p_id= sc.nextInt();
				sc.nextLine();
				principal.setId(p_id);
				System.out.println("Enter Principal Name: ");
				String p_name= sc.nextLine();
				principal.setName(p_name);
				
				principal.setSchool(school);
				school.setPrincipal(principal);
				
				System.out.println("Enter the no of students you want to enter: ");
				int n= sc.nextInt();
				
				List<Student> students= new ArrayList<Student>();
				
				for(int i=0; i<n; i++) {
					Student st= new Student();
					System.out.println("Enter Student ID: ");
					int s_id= sc.nextInt();
					sc.nextLine();
					st.setId(s_id);
					System.out.println("Enter Student Name: ");
					String s_name= sc.nextLine();
					st.setName(s_name);
					System.out.println("Enter Student Age: ");
					int s_age= sc.nextInt();
					sc.nextLine();
					st.setAge(s_age);
					
					st.setSchool(school);
					st.setPrincipal(principal);
					students.add(st);
				}
				
				school.setStudents(students);
				principal.setStudents(students);
				
				service.save(school);
				
				break;
				
			case 2:
				System.out.println("Enter School ID: ");
				int find_id= sc.nextInt();
				
				School sch= service.find(School.class, find_id);
				if(sch!=null) {
					System.out.println("School ID is: "+sch.getId());
					System.out.println("School Name is: "+sch.getName());
					System.out.println("School Principal is: "+sch.getPrincipal().getName());
					System.out.println("Total Students in school are: "+sch.getStudents().size());
				}else {
					System.out.println("School Not Found!");
				}
				
				break;
				
			case 3:
				System.out.println("Enter School ID: ");
				int up_id= sc.nextInt();
				sc.nextLine();
				
				School scho= service.find(School.class, up_id);
				if(scho!=null) {
					System.out.println("Enter School Name to update: ");
					String up_name= sc.nextLine();
					scho.setName(up_name);
					service.update(scho);
				}else {
					System.out.println("School not found!");
				}
				break;
				
			case 4:
				System.out.println("Enter School ID: ");
				int del_id= sc.nextInt();
				
				School schl= service.find(School.class, del_id);
				if(schl!=null) {
					service.remove(schl);
				}
				break;
				
			case 5:
				System.out.println("Exiting Application!");
				sc.close();
				System.exit(0);
				
			default:
                System.out.println("Invalid choice");
			}
		}
	}
}
