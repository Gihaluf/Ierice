package darbs;

public class Iphone extends Telefons {

	
	private boolean faceID, bezvaduLade;
	
	public Iphone(boolean faceID, boolean bezvaduLade,
			String modelis, double ekranaIzmers, int atmina, double cena, String krasa, boolean ringtons) {
		super(modelis, ekranaIzmers, atmina, cena, krasa, ringtons);
		this.faceID = faceID;
		this.bezvaduLade = bezvaduLade;
	}
	public void setFaceID(boolean faceID) {
		this.faceID = faceID;
	}
	public boolean getFaceID() {
		return faceID;
	}
	public void setBezvaduLade(boolean bezvaduLade) {
		this.bezvaduLade = bezvaduLade;
	}
	public boolean getBezvaduLade() {
		return bezvaduLade;
	}
	
	
}