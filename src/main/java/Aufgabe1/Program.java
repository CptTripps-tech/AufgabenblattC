package Aufgabe1;

import java.io.*;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Adresse adresse= new Adresse();
        adresse.setStrasse("Ringstr. 1");
        adresse.setOrt("Musterstadt");

        Person hugo= new Person();
        hugo.setName("Hugo Schmidt");
        hugo.setAdresse(adresse);

        Person erika =new Person();
        erika.setName("Erika Schmidt");
        erika.setAdresse(adresse);

        ArrayList<Person> people=new ArrayList<Person>();
        people.add(hugo);
        people.add(erika);

        ObjectOutput out=new ObjectOutputStream(new FileOutputStream("obj.ser"));
        out.writeObject(people);
        out.close();

        ObjectInput in=new ObjectInputStream(new FileInputStream("obj.ser"));
        ArrayList<Person> per = (ArrayList<Person>) in.readObject();
        in.close();

        System.out.println(per);

           if(hugo.getAdresse().equals(erika.getAdresse())){
               System.out.println("True:Adresse wurde nur einmal deserialisiert");
           }

        System.out.println(per.equals(hugo.getAdresse()));

    }
}
