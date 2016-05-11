package baum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainBaum {

	public static void main(String[] args) throws IOException {
		StudentenListe studiListe = new StudentenListe();
	    InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(isr);
	    String eingabe = null;
	    String name, matrikelnummer, adresse, neue_matrikelnummer;
	    Integer ma, nma;
	    
	    
	    do {
	    	System.out.println("1. Add student\n2. Student suchen\n3. Student Löschen\n4. Modifizieren\n0. beenden\n");
	    	eingabe = br.readLine();
	    	if(eingabe.equals("1")) {
	    		System.out.println("Name");
	    		name = br.readLine();
	    		System.out.println("Matrikelnummer");
	    		matrikelnummer = br.readLine();
	    		System.out.println("Adresse");
	    		adresse = br.readLine();
	    		
	    		try {
	    		ma = Integer.valueOf(matrikelnummer);
	    		}
	    		catch (NumberFormatException e) {
	    			System.out.println("Frechdachs");
	    			return;
	    		}
	    		if(studiListe.AddStudent(new Student(ma, name, adresse )) == false)
	    			System.out.println("Fehlgeschlagen");
	    	}
	    	if(eingabe.equals("2")) {
	    		System.out.println("Matrikelnummer");
	    		matrikelnummer = br.readLine();
	    		
	    		try {
	    		ma = Integer.valueOf(matrikelnummer);
	    		}
	    		catch (NumberFormatException e) {
	    			System.out.println("Frechdachs");
	    			return;
	    		}
	    		Student to_find = studiListe.get_student_by_key(ma);
	    		if(to_find == null)
	    			System.out.println("Nicht gefunden");
	    		else
	    			System.out.println("Name: " + to_find.getName() + "\n");
	    	}
	    	if(eingabe.equals("3")) {
	    		System.out.println("Matrikelnummer");
	    		matrikelnummer = br.readLine();
	    		
	    		try {
	    		ma = Integer.valueOf(matrikelnummer);
	    		}
	    		catch (NumberFormatException e) {
	    			System.out.println("Frechdachs");
	    			return;
	    		}
	    		Student to_find = studiListe.get_student_by_key(ma);
	    		if(to_find == null)
	    			System.out.println("Nicht gefunden");
	    		else
	    			studiListe.DelStudent(to_find);
	    	}
	    	if(eingabe.equals("4")) {
	    		System.out.println("Matrikelnummer");
	    		matrikelnummer = br.readLine();
	    		System.out.println("Neue Matrikelnummer");
	    		neue_matrikelnummer = br.readLine();
	    		System.out.println("Name");
	    		name = br.readLine();
	    		System.out.println("Adresse");
	    		adresse = br.readLine();
	    		
	    		
	    		try {
	    		ma = Integer.valueOf(matrikelnummer);
	    		nma = Integer.valueOf(neue_matrikelnummer);
	    		}
	    		catch (NumberFormatException e) {
	    			System.out.println("Frechdachs");
	    			return;
	    		}
	    		if(studiListe.modify(ma, nma, name, adresse) == false)
	    			System.out.println("Fehlgeschlagen");
	    	}	    	
	    	System.out.println(studiListe);
	    	
	    } while(!eingabe.equals("0"));
	    
	   
	}

}
