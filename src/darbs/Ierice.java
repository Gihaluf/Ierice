package darbs;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Ierice {
   @SuppressWarnings("deprecation")
public static void main(String[] args) throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException{
       String izvele;
       int n;
       int izvelesID;
       String [] darbibas = {"Izveidot telefonu",
       "Apskatīt telefonus","Dzēst telefonu","Izsaukt metodes", "Apturēt"};
        String[] veidi = {"Android", "Iphone"};
		String[] atbilde = {"Jā", "Nē"};

        String[] metodes = {"Atbildēt", "Kamera", "Spēles", "Atpakaļ"};
        ArrayList<Object> telefoni = new ArrayList<>();
        do{
        izvele = (String)JOptionPane.showInputDialog(null, 
                            "Darbību Izvēle", "Izvēle", JOptionPane.QUESTION_MESSAGE,
                            null, darbibas, darbibas[0]);
        if(izvele == null) break;
        izvelesID = Arrays.asList(darbibas).indexOf(izvele);
       
        switch(izvelesID){
            case 0: 
                String modelis = (String) JOptionPane.showInputDialog(null, "Izvēlies modeli",
						"Izvēlne", JOptionPane.QUESTION_MESSAGE, null
						,veidi, veidi[0]);

                if (modelis == null)break;
				
	            double ekranaIzmers = Metodes.skaitlaParbaude("Kāds būs ekrāna izmērs?", 4.3, 10.2, "6.9");
                if(ekranaIzmers == -1) break;
                double atmina = Metodes.skaitlaParbaude("Cik liela būs telefonam atmiņa?", 32, 1024, "128");
                if(atmina == -1) atmina = 128;
	            double cena = Metodes.skaitlaParbaude("Cik maksās", 10, 10000, "630");
                if(cena == -1) break;
                String krasa = Metodes.virknesParbaude("Kādā krāsā", "balts");

                izvele = (String)JOptionPane.showInputDialog(null, "Vai būs ringtone", "Izveide",
                        JOptionPane.INFORMATION_MESSAGE, null, atbilde, atbilde[0]);
                boolean ring;
                if(izvele == "Jā")
                    ring = true;
                else 
                    ring = false;
                
                switch(modelis){
                    case "Android":
                        izvele = (String)JOptionPane.showInputDialog(null, "Vai būs google konts", "Izveide",
                            JOptionPane.INFORMATION_MESSAGE, null, atbilde, atbilde[0]);
                        boolean googleK;
                        if(izvele == "Jā")
                            googleK = true;
                        else 
                            googleK = false;

                        izvele = (String)JOptionPane.showInputDialog(null, "Vai būs NFC", "Izveide",
                            JOptionPane.INFORMATION_MESSAGE, null, atbilde, atbilde[0]);
                        boolean NFC;
                        if(izvele == "Jā")
                            NFC = true;
                        else 
                            NFC = false;
                            izvele = (String)JOptionPane.showInputDialog(null, "Vai būs fingerID", "Izveide",
                        JOptionPane.INFORMATION_MESSAGE, null, atbilde, atbilde[0]);
                        boolean FID;
                        if(izvele == "Jā")
                            FID = true;
                        else 
                            FID = false;

                        telefoni.add(new Android(googleK, NFC, FID, 
                                    modelis, ekranaIzmers,(int)atmina ,cena, krasa, ring));
					    JOptionPane.showMessageDialog(null, "Veiksmīgi izveidots telefons",
							"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "Iphone":
                        izvele = (String)JOptionPane.showInputDialog(null, "Vai būs faceID?", "Izveide",
                            JOptionPane.INFORMATION_MESSAGE, null, atbilde, atbilde[0]);
                        boolean faceID ;
                        if(izvele == "Jā")
                            faceID  = true;
                        else 
                            faceID  = false;
                        izvele = (String)JOptionPane.showInputDialog(null, "Vai būs iespēja lādēt bez vada?", "Izveide",
                            JOptionPane.INFORMATION_MESSAGE, null, atbilde, atbilde[0]);
                        boolean BezV ;
                        if(izvele == "Jā")
                            BezV  = true;
                        else 
                            BezV  = false;
                            telefoni.add(new Iphone(faceID, BezV,
                                    modelis, ekranaIzmers,(int)atmina ,cena, krasa, ring));
					    JOptionPane.showMessageDialog(null, "Veiksmīgi izveidots telefons",
							"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
                        break;
                }
                break;
            case 1:
                if(telefoni.size() > 0) { 
					String str = "Telefonu skaits: "+telefoni.size()+
							"\n_________________________________\n";
					for(int i=0; i<telefoni.size(); i++) {
						str += ((Telefons)telefoni.get(i)).izvadit()+
							"\n_________________________________\n";
					}
					
					JTextArea ta = new JTextArea (str, 10, 40);
					ta.setEditable(false);
					JScrollPane sp = new JScrollPane(ta);
					sp.setVerticalScrollBarPolicy(
							ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					JOptionPane.showMessageDialog(ta, sp, "Atzīmes",
							JOptionPane.PLAIN_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Nav ievadīts neviens telefons",
							"Kļūda", JOptionPane.ERROR_MESSAGE);
					break;
				}
                break;
            case 2:
                if(telefoni.size() > 0) { 
                        int ritID = Metodes.telefonaIzvele(telefoni);
                        
                        telefoni.remove(ritID);
                        JOptionPane.showMessageDialog(null, "Veiksmīgi izdzēsts telefons",
                                "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
                    }else {   
                        JOptionPane.showMessageDialog(null, "Nav ievadīts neviens telefons",
                                "Kļūda", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                break;
            case 3:
            	if(telefoni.size() > 0) { 
					int telID = Metodes.telefonaIzvele(telefoni);
                    
					do{
                        izvele = (String)JOptionPane.showInputDialog(null, 
                            "Darbību Izvēle", "Izvēle", JOptionPane.QUESTION_MESSAGE,
                            null, metodes, metodes[0]);
                        if(izvele == null) break;
                        switch(izvele){
                            case "Atbildēt":
                                ((Telefons)telefoni.get(telID)).ring();
                                int a = JOptionPane.showOptionDialog(
                                    null, "Vai pacelsi telefonu?", "Izvēle", 0, -1, null, atbilde, args);
                                    
                                if(a == 0) 
                                ((Telefons)telefoni.get(telID)).pacelt();
                                break;
                                
                            case "Kamera":
                            	n=5000;
                            	URL url1 = new URL("https://media0.giphy.com/media/v1.Y2lkPTc5MGI3NjExMG4za3Q2ODNteXg5MnJuY3plb3Jxdmw3dzQzNDdldjljbm1hbTI2dCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/XRXAVE3ZhLLAYHMbR2/giphy.gif");
                                Icon icon = new ImageIcon(url1);
                                JLabel label = new JLabel(icon);
                                
                                JFrame f = new JFrame("Kamera");
                                f.getContentPane().add(label);
                                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                f.pack();
                                f.setLocationRelativeTo(null);
                                f.setVisible(true);
                                timer(n);
                                f.setVisible(false);
                                break;
                            case "Spēles":
                            	n=7600;
                            	URL url2 = new URL("https://media4.giphy.com/media/v1.Y2lkPTc5MGI3NjExd2lkejRxMzY1cjFwZW9zeGhkd2pxcGJpcTg3dHFxN3VsM2VuM3RlZSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/n90VEOfcCvrDo2fMOR/giphy.gif");
                                Icon icon1 = new ImageIcon(url2);
                                JLabel label1 = new JLabel(icon1);
                                
                                JFrame f1 = new JFrame("Spēlīte");
                                ((Telefons)telefoni.get(telID)).clash();
                                f1.getContentPane().add(label1);
                                f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                f1.pack();
                                f1.setLocationRelativeTo(null);
                                f1.setVisible(true);
                                timer(n);
                                f1.setVisible(false);
                            	break;
                            case "Atpakaļ":
                                break;
                        }
                    }while(izvele != "Atpakaļ");
				}else {
					JOptionPane.showMessageDialog(null, "Nav ievadīts neviens telefons",
							"Kļūda", JOptionPane.ERROR_MESSAGE);
					break;
				}
				break;
            case 4:
                JOptionPane.showMessageDialog(null,
                    "Programma apturēta", "STOP",JOptionPane.WARNING_MESSAGE);
                break;
        }
        }while(izvelesID != 4);
   }
   static void timer(int n){
        try {
            Thread.sleep(n);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
   }
}