package Aufgabe2;

import java.util.ArrayList;
import java.util.Iterator;


public class Familie implements Iterable<String>  {

    private ArrayList mitglieder;

    public Familie(String Vater, String Mutter) {
        mitglieder = new ArrayList<>();
        mitglieder.add(0, Mutter);
        mitglieder.add(1, Vater);

        if (Vater == null || Vater == "") {
            throw new IllegalArgumentException("Name des Vaters fehlt!");
        }
        if (Mutter == null || Mutter == "") {
            throw new IllegalArgumentException("Name der Mutter fehlt!");
        }

    }

    public void addKind(String kind) {
        mitglieder.add(kind);

        if (kind == null || kind == "") {
            throw new IllegalArgumentException("Name des Kindes fehlt!");
        }
    }

    @Override public Iterator<String> iterator()
    {
        Iterator<String> it=mitglieder.iterator();
        return it;
    }


    public enum Familienmitglied {
        Vater,Mutter,Kinder
    }

    public void getMitglied(Familienmitglied mg) {
        switch (mg){
            case Vater:
                System.out.println(mitglieder.get(1));
                break;
            case Mutter:
                System.out.println(mitglieder.get(0));
                break;
            case Kinder:

                if(mitglieder.size()==2){
                    System.out.println("");
                    break;
                }

                int i=2;
                for(mitglieder.get(2);i<mitglieder.size();i++) {
                    if(i==2) {
                        System.out.print(mitglieder.get(i));
                    }
                    if(i>2 && i<mitglieder.size()){
                        System.out.print(","+mitglieder.get(i));
                    }
                }
                break;
        }
    }
}

