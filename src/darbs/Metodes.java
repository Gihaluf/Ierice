package darbs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Metodes {
    public static String virknesParbaude(String zinojums, String noklusejums) {
		String virkne;
		do {
			virkne = JOptionPane.showInputDialog(zinojums, noklusejums);
			if(virkne == null)
				return null;
		}while(!Pattern.matches("^[\\p{L} .]+$", virkne));
		return virkne;
	}
		public static double skaitlaParbaude(String zinojums, double min, double max, String noklusejums) {
			String ievade;
			Double skaitlis;
			while(true) {
				ievade = (String)JOptionPane.showInputDialog(null, zinojums, 
						"Datu ievade", JOptionPane.INFORMATION_MESSAGE, null, null, noklusejums); 
				if(ievade == null)
					return -1.0;
				try {
					skaitlis = Double.parseDouble(ievade);
					if(skaitlis < min || skaitlis > max) {
						JOptionPane.showMessageDialog(null, 
						"Norādīts nederīgs skaitlis", "Nekorekti dati",
						JOptionPane.WARNING_MESSAGE);
						continue;
					}
					
					return skaitlis;
				}catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null,
						"Netika ievadīts pareizs skaitlis", "Nekorekti dati",
						JOptionPane.WARNING_MESSAGE);
				}
			}
	}
    static int telefonaIzvele(ArrayList <Object> telefoni) {
		String[] tSaraksts = new String[telefoni.size()] ;
		for(int i=0; i<tSaraksts.length; i++) {
			tSaraksts[i] = 
				(((Telefons)telefoni.get(i)).getModelis())+" "+
				(((Telefons)telefoni.get(i)).getCena())+"EUR";
		}
		
		String izveletais = (String)JOptionPane.showInputDialog(null,
				"Izvēlies telefonu: ", "Izvēle", JOptionPane.QUESTION_MESSAGE, null,
				tSaraksts,tSaraksts[0]);
		
		return Arrays.asList(tSaraksts).indexOf(izveletais);
	}
	

}