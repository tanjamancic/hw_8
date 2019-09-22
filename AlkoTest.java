package osmipaket;

import java.util.Scanner;

public class AlkoTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dobrodosli u alko aproksimator 9000");
		int pol, idPica = 0;
		System.out.print("Unesite Vasu tezinu u kilogramima");
		double tezina = sc.nextDouble() * 1000;
		System.out.println("Unesite Vas pol(ako ste musko unesite 1, ako ste zensko unesite 0): ");
		pol = sc.nextInt();
		double r = korektivniFaktorPola(pol), bac = 0, suma = 0;
		do {
			System.out.println("Unesite id pica koje ste pili ili -1 ako ste vec uneli sva pica: ");
			idPica = sc.nextInt();
			if ( idPica == -1 ) continue;
			double procenat = procenat(idPica);
			System.out.println("Unesite koliko mililitra pica ste popili: ");
			int kolicina = sc.nextInt();
			suma += kolicina * procenat; 
		} while ( idPica != -1 ); 
		bac = ( suma / ( tezina * r)) * 1000;
		String kazna = "", poeni = "", zabrana = "", stanje = "";
		if ( bac <= 0.2)  {
			kazna = "Bez kazne";
			poeni = "0";
			zabrana = "0";
			stanje = "Dozvoljena";
		}
		else if ( bac <= 0.5)  {
			kazna = "10.000 dinara";
			poeni = "0";
			zabrana = "0";
			stanje = "Umerena";
		}
		else if ( bac <= 0.8)  {
			kazna = "10.000 - 20.000 dinara";
			poeni = "6";
			zabrana = "3";
			stanje = "Srednja";
		}
		else if ( bac <= 1.2)  {
			kazna = "20.000 - 40.000 dinara";
			poeni = "8";
			zabrana = "4";
			stanje = "Visoka";
		}
		else if ( bac <= 1.6)  {
			kazna = "100.000 - 120.000 dinara";
			poeni = "9";
			zabrana = "8";
			stanje = "Teska";
		}
		else if ( bac <= 2.0)  {
			kazna = "100.000 - 120.000 dinara";
			poeni = "14";
			zabrana = "8";
			stanje = "Visoka";
		}
		else {
			kazna = "30 - 60 dana zatvora";
			poeni = "15";
			zabrana = "9";
			stanje = "Potpuna";
		}
		System.out.println("--------------------");
		System.out.printf("BAC: %.2f - %s alkoholisanost\n" , bac, stanje );
		System.out.println("--------------------");
		System.out.println("Kazna: " + kazna);
		System.out.println("Kazneni poeni: " + poeni);
		System.out.println("Zabrana voznje: " + zabrana + " meseci");
	}
	static double procenat(int idPica) {
		double procenat = 0 ;
		switch (idPica) {
			case 1 :
				procenat = 50;
				break;
			case 2 : 
				procenat = 40; 
				break;
			case 3 : 
				procenat = 4.7; 
				break;
			case 4 :
				procenat = 11; 
				break;
			default : 
				System.out.println("Pogresan unos id pica.");
		}
		return procenat/100 ;
	}
	static double korektivniFaktorPola (int pol) {
		double r = 0;
		switch (pol) {
			case 0:
				r = 0.68;
				break;
			case 1 : 
				r = 0.55;
				break;
			default :
				System.out.println("Neispravan unos.");
				break;
		}
		return r;
	}
}
