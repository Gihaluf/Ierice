package darbs;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;


public class Telefons {
	
	private String modelis;
	
	private String krasa;
	private double ekranaIzmers;
	private int atmina;
	private double cena;
	private boolean ringtons;
	
	public Telefons(String modelis, double ekranaIzmers, int atmina, double cena, String krasa, boolean ringtons) {
		this.modelis = modelis;
		this.ekranaIzmers = ekranaIzmers;
		this.atmina = atmina;
		this.cena = cena;
		this.krasa = krasa;
		this.ringtons = ringtons;
	}
	
	public String getModelis() {
		return modelis;
	}

	public void setModelis(String modelis) {
		this.modelis = modelis;
	}

	public double getEkranaIzmers() {
		return ekranaIzmers;
	}

	public void setEkranaIzmers(double ekranaIzmers) {
		this.ekranaIzmers = ekranaIzmers;
	}

	public int getAtmina() {
		return atmina;
	}

	public void setAtmina(int atmina) {
		this.atmina = atmina;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}
	public String getKrasa() {
		return krasa;
	}
	public String setKrasa() {
		return krasa;
	}
	public boolean getRingtons() {
		return ringtons;
	}
	public void setRingtons(boolean ringtons) {
		this.ringtons = ringtons;
	}
    public void ring() throws MalformedURLException, 
	UnsupportedAudioFileException, IOException, 
	LineUnavailableException{
		if(ringtons) {
			File f = new File(".//zvans//"+"zvans.wav");
			AudioInputStream ais = AudioSystem.getAudioInputStream(f.toURI().toURL());
			Clip c = AudioSystem.getClip();
			c.open(ais);
			c.start();
		}else {
			JOptionPane.showMessageDialog(null, "Nav uzstādīts ringtons!", 
					"Paziņojums", JOptionPane.ERROR_MESSAGE);
		}
	}
    public void pacelt() throws MalformedURLException, 
	UnsupportedAudioFileException, IOException, 
	LineUnavailableException{
		if(ringtons) {
			File f = new File(".//zvans//"+"pacelt.wav");
			AudioInputStream ais = AudioSystem.getAudioInputStream(f.toURI().toURL());
			Clip c = AudioSystem.getClip();
			c.open(ais);
			c.start();
		}else {
			JOptionPane.showMessageDialog(null, "Nav uzstādīts ringtons!", 
					"Paziņojums", JOptionPane.ERROR_MESSAGE);
		}
		}
    public void clash() throws MalformedURLException, 
	UnsupportedAudioFileException, IOException, 
	LineUnavailableException{
		
		File f = new File(".//zvans//"+"spele.wav");
		AudioInputStream ais = AudioSystem.getAudioInputStream(f.toURI().toURL());
		Clip c = AudioSystem.getClip();
		c.open(ais);
		c.start();
	
    }
	public String izvadit() {
		return "Modelis: "+getModelis()+
				"\nEkrāna izmērs: "+getEkranaIzmers()+" collas"+
				"\nAtmiņa: "+getAtmina()+" GB"+
				"\nCena: "+getCena()+" EUR"+
				"\nKrāsa: "+getKrasa()+
				"\nRingtons: "+((ringtons)? "Ir": "Nav");
		}
}