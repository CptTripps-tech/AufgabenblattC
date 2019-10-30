package Aufgabe2;


public class Program {
    public static void main(String[] args){
        Familie Smith=new Familie("Stan","Francine");
        Smith.addKind("Steve");
        Smith.addKind("Haley");

        Familie Griffin = new Familie("Peter","Louis");

        Familie familie=new Familie("Tom","Elisa");

        for(Familie.Familienmitglied f: Familie.Familienmitglied.values()){
            Smith.getMitglied(f);
        }

        System.out.println("\n");

        for(Familie.Familienmitglied f: Familie.Familienmitglied.values()){
            Griffin.getMitglied(f);
        }

        System.out.println("\n");

        for(String name:familie){
            System.out.println(name);
        }
    }
}
