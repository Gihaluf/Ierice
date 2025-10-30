package darbs;

public class Android extends Telefons {
	
	private boolean googleKonts, NFC, FingerID;
	public Android(boolean googleKonts, boolean NFC, boolean FingerID,
			String modelis, double ekranaIzmers, int atmina, double cena, String krasa, boolean ringtons) {
		super(modelis, ekranaIzmers, atmina, cena, krasa, ringtons);
		this.googleKonts = googleKonts;
		this.NFC = NFC;
		this.FingerID = FingerID;
	}
	public void setNFC(boolean NFC) {
		this.NFC = NFC;
	}
	public boolean getNFC() {
		return NFC;
	}
	public void setFingerID(boolean FingerID) {
		this.FingerID = FingerID;
	}
	public boolean getFingerID() {
		return FingerID;
	}
	public void setGoogleKonts(boolean googleKonts) {
		this.googleKonts = googleKonts;
	}
	public boolean getGoogleKonts() {
		return googleKonts;
	}
	public static String andrIzvadit( ) {
		return "googleKonts: "+", NFC: "+", FingerID: ";
	}
}