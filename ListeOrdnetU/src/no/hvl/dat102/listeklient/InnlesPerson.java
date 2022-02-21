package no.hvl.dat102.listeklient;

import javax.swing.JOptionPane;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.tabell.TabellOrdnetListe;

public class InnlesPerson {

	public static void main(String[] args) {
		
		OrdnetListeADT<Person> listeK = new KjedetOrdnetListe<Person>();
		OrdnetListeADT<Person> listeT = new TabellOrdnetListe<Person>();
		
		for(int i = 0; i < 6; i++) {
			String fornavn = JOptionPane.showInputDialog("Fornavn");
			String etternavn = JOptionPane.showInputDialog("Etternavn");
			int foedselsaar = Integer.parseInt(JOptionPane.showInputDialog("Fødselsår"));
			
			listeK.leggTil(new Person(fornavn, etternavn, foedselsaar));
			listeT.leggTil(new Person(fornavn, etternavn, foedselsaar));
		}
		
		System.out.println("Utskrift fra liste");
		
		while(!listeK.erTom()) {
			System.out.println(listeK.fjernFoerste().toString());
		}
		System.out.println("-----------");
		
		System.out.println("Utskrift fra tabell");
		
		while(!listeK.erTom()) {
			System.out.println(listeT.fjernFoerste().toString());
		}
	}
}
