package baum;

import java.util.ArrayList;

public class StudentenListe {
	private ArrayList<Student> studentenListe;
	private BinaryTree t;
	
	
	public StudentenListe() {
		studentenListe = new ArrayList<Student>();
		t = new BinaryTree();
		
	}
	public boolean AddStudent(Student to_add) {
		BinaryTreeNode to_add_node = new BinaryTreeNode();
		
		if(to_add == null)
			return false;
		if(studentenListe.contains(to_add)) {
			if(!to_add.isGeloescht()) {
				return false;
			}
			else {
				to_add.setGeloescht(false);
				to_add_node.setKey(to_add.getMatrikelnummer());
				to_add_node.setValue(studentenListe.indexOf(to_add));
				t.insert(to_add_node);
				return true;
			}
		}
				

		
		studentenListe.add(to_add);
		
		to_add_node.setKey(to_add.getMatrikelnummer());
		to_add_node.setValue(studentenListe.indexOf(to_add));
		t.insert(to_add_node);
		
		return true;
	}
	public boolean DelStudent(Student to_del) {
		
		if(to_del == null)
			return false;
		if(!studentenListe.contains(to_del))
			return false;
		if(to_del.isGeloescht())
			return false;
		
		
		if(t.delete(t.search(to_del.getMatrikelnummer())) == false)
			return false;
		to_del.setGeloescht(true);
		return true;
	}
	public Student get_student_by_key(Integer key) {
		BinaryTreeNode student_node;
		
		if(key == null)
			return null;
	
		student_node = t.search(key);
		if(student_node == null)
			return null;
		
		return studentenListe.get(student_node.getValue());
	}
	public boolean modify(Integer matrikelnummer, Integer new_matrikelnummer, String new_name, String new_adresse) {
		BinaryTreeNode old, new_node;
		
		if(matrikelnummer == null || new_matrikelnummer == null || new_name == null || new_adresse == null)
			return false;
		if((old = t.search(matrikelnummer)) == null)
			return false;
		
		new_node = new BinaryTreeNode();
		new_node.setKey(new_matrikelnummer);
		new_node.setValue(old.getValue());
		
		get_student_by_key(old.getKey()).setAdresse(new_adresse);
		get_student_by_key(old.getKey()).setMatrikelnummer(new_matrikelnummer);
		get_student_by_key(old.getKey()).setName(new_name);
		return t.modify(old, new_node);
	}
	@Override
	public String toString() { 
	    String res = "";
	    
	    for(BinaryTreeNode tmp : t.inorder()) {
	    	res += "Mat: " + tmp.getKey() + " Name: " + get_student_by_key(tmp.getKey()).getName() +"\n";
	    }
	    return res;
	} 
	
}
