package Aufgabe4;

public class Bibliothek {
    public static void main(String[] args){

        Zettelkasten zettelkasten= new Zettelkasten();

        zettelkasten.addMedium(new CD("Live at Wembley","Queen","Parlophone (EMI)"));
        zettelkasten.addMedium(new ElektronischesMedium("http://www.hochschule-stralsund.de"));
        zettelkasten.addMedium(new Buch("Duden 01.Die deutsche Rechtschreibung",2004,
                "Bibliographisches Institut, Mannheim","3-411-04013-0","-"));
        zettelkasten.addMedium(new Zeitschrift("Der Spiegel",6,54,"0038-7452"));

        zettelkasten.sort();

        for(Medium medium: zettelkasten){
            System.out.println(medium.calculateRepresentation());
        }
    }
}
