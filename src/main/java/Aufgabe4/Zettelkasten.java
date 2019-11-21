package Aufgabe4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Zettelkasten implements Iterable<Medium>,Comparable<Medium> {
    private ArrayList<Medium> myZettelkasten;
    private String SORTED = "0";

    /**
     * Erstellt einen Zettelkasten in Form einer Arraylist für die Medien
     */
    public Zettelkasten() {
        myZettelkasten = new ArrayList<Medium>();
    }

    /**
     * @param medium Hinzufügen des Mediums zum Zettelkasten
     * @return false    Medium nicht erfolgreich hinzugefügt
     */
    public boolean addMedium(Medium medium) {
        return myZettelkasten.add(medium);
    }

    /**
     * @param Titel Löschen des Mediums aus dem Zettelkastens anhand des Titels
     * @return false    Medium nicht erfolgreich entfernt
     */
    public boolean dropMedium(String Titel) throws DuplicateEntryException {
         List<Medium> result=findMedium(Titel);
        if(result.size()>1){
            throw new DuplicateEntryException("Mehrfache Einträge");
        }
        else if(result.size()<1){
            return false;
        }
        else{
            return myZettelkasten.remove(result.get(0));
        }
    }

    public boolean dropDuplicate(String Titel){
        int auswahl,index = 0;
        List<Medium> auswahlListe=findMedium(Titel);
        Scanner sc=new Scanner(System.in);
        System.out.println("Art der Löschung: 1-Bestimmte");
        System.out.print("                  2-Alle\n");
        System.out.print("Auswahl:");
        auswahl=sc.nextInt();

        switch (auswahl){
            case 1:
                for (Medium medium : auswahlListe) {
                    index = auswahlListe.indexOf(medium);
                    System.out.print("Eintrag:" + index+"\n");
                    System.out.println("Medium:" + auswahlListe.get(index).calculateRepresentation());
                }
                System.out.println("Nummer des Eintrags:");
                auswahl = sc.nextInt();
                 myZettelkasten.remove(auswahlListe.get(auswahl));
                break;

            case 2:
                for(int i=0;i<auswahlListe.size();i++){
                    myZettelkasten.remove(auswahlListe.get(i));
                }
                break;
        }
        return true;
    }

    /**@param Titel Finden eines Mediums im Zettelkasten anhand des Titels
     * @return      Liefert das gefundene Medium zurück*/
        public List<Medium> findMedium (String Titel) {
            List<Medium> multipleMed = new ArrayList<Medium>();
           for(Medium medium: myZettelkasten){
               if(medium.getTitel().equals(Titel)){
                   multipleMed.add(medium);
                   Collections.sort(multipleMed,Collections.reverseOrder());
               }
           }
            return multipleMed;
          }




        /**Sortieren des Zettelkastens anhand zwei Parameter
         * @param  p        Der erste Sortier-Parameter
         * @return true     Sortieren hat funktioniert
         * @return false    Sortieren hat nicht funktioniert*/
    public boolean sort(String p) {
        if (p=="AZ") {
            if(SORTED.equals("AZ")){
                return false;
            }
                Collections.sort(myZettelkasten);
            SORTED="AZ";
            }
            if (p=="ZA") {
                if(SORTED.equals("ZA")){
                    return false;
                }
                Collections.sort(myZettelkasten, Collections.reverseOrder());
                SORTED="ZA";
            }
            return true;
        }

        public String getSORTED(){
        return SORTED;
        }

    @Override
    public Iterator<Medium> iterator() {
        return myZettelkasten.iterator();
    }


    @Override
    public int compareTo(Medium o) {
        return this.getClass().getName().compareTo(o.getClass().getName());
    }
}

