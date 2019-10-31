package Aufgabe4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Zettelkasten implements Iterator<Medium>,Iterable<Medium> {
    private ArrayList<Medium> myZettelkasten;

    public Zettelkasten() {
        myZettelkasten=new ArrayList<Medium>();
    }

    public boolean addMedium(Medium medium){
        return myZettelkasten.add(medium);
    }

    public boolean dropMedium(String Titel) {
        int i = 0;
        String dm;
        dm = myZettelkasten.get(i).getTitel();

        while (!dm.equals(Titel) && i < myZettelkasten.size()) {
            dm = myZettelkasten.get(i).getTitel();
            i++;
        }
        if (dm.equals(Titel)) {
            myZettelkasten.remove(i);
        } else {
            throw new ArrayStoreException("Der Titel wurde nicht gefunden");
        }
        return true;
    }

    public Medium findMedium(String Titel) {
        int j = 0;
        String fm;
        fm = myZettelkasten.get(j).getTitel();

        while (!fm.equals(Titel) && j < myZettelkasten.size()) {
            fm = myZettelkasten.get(j).getTitel();
            j++;
        }
        if (fm.equals(Titel)) {
            return myZettelkasten.get(j);
        } else {
            return null;
        }
    }


    public void sort(/*Character x,Character y*/) {
        // if(x.equals('A')){
        Collections.sort(myZettelkasten);
        //}

    }


    Iterator<Medium> zk_iterator;

    @Override
    public boolean hasNext() {
        return (zk_iterator != null && zk_iterator.next() != null);
    }

    @Override
    public Medium next() {
        return zk_iterator.next();
    }

    @Override
    public Iterator<Medium> iterator() {
        return zk_iterator=myZettelkasten.iterator();
    }

}

