package baum;

public class Student {
	private Integer matrikelnummer;
	private String name;
	private String adresse;
	private boolean geloescht;
	
	public Student(Integer matrikelnummer, String name, String adresse) {
		this.matrikelnummer = matrikelnummer;
		this.name = name;
		this.adresse = adresse;
		this.geloescht = false;
	}
	
	public Integer getMatrikelnummer() {
		return matrikelnummer;
	}
	public void setMatrikelnummer(Integer matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public boolean isGeloescht() {
		return geloescht;
	}
	public void setGeloescht(boolean geloescht) {
		this.geloescht = geloescht;
	}
	
	
}
