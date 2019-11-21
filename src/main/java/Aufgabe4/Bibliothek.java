package Aufgabe4;

import java.util.Collections;
/**Das Programm Bibliothek kann verwendet werden, um eine virtuelle Bibliothek zu erstellen, die verschiedene Medien
 * speichern kann. Diese Bibliothek kann auf Wunsch in eine Textdatei gespeichert werden.
 * @Author Andy Gahler
 * @since 03.11.2019
 **/
public class Bibliothek {
    public static void main(String[] args) {

        Zettelkasten zettelkasten = new Zettelkasten();

        zettelkasten.addMedium(new CD("Live at Wembley", "Queen", "Parlophone (EMI)"));

        zettelkasten.addMedium(new ElektronischesMedium("http://www.hochschule-stralsund.de"));
        zettelkasten.addMedium(new Buch("Duden 01.Die deutsche Rechtschreibung", 2004,
                "Bibliographisches Institut, Mannheim", "3-411-04013-0", "-"));
        zettelkasten.addMedium(new Zeitschrift("Der Spiegel", 6, 54, "0038-7452"));

        zettelkasten.sort("ZA");
        /*try {
            zettelkasten.dropMedium("Live at Wembley");
        }catch (DuplicateEntryException e){
            System.out.println("Mehrere Einträge");
            zettelkasten.dropDuplicate("Live at Wembley");

        }
        */
        System.out.println(zettelkasten.findMedium("Live at Wembley").toString());

        for(Medium medium: zettelkasten){
            System.out.println(medium.calculateRepresentation());
        }

        HumanReadablePersistency human= new HumanReadablePersistency();
        BinaryPersistency binary=new BinaryPersistency();

        human.save(zettelkasten,"bib.txt");
        binary.save(zettelkasten,"bib.ser");
    }
}
