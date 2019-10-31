package Aufgabe4;

public class Zeitschrift extends Medium{
    private String ISSN;
    private int Volume;
    private  int Nummer;

    public Zeitschrift(String Titel,int Nummer,int Volume,String ISSN){
        super(Titel);
        setNummer(Nummer);
        setVolume(Volume);
        setISSN(ISSN);
    }

    public void setNummer(int Nummer){
        if (Nummer == 0) {
            throw new IllegalArgumentException("Die Nummer der Zeitschrift fehlt!");
        }
        this.Nummer = Nummer;
    }

    public int getNummer(){
        return this.Nummer;
    }

    public void setVolume(int Volume){

        if(Volume==0){
            throw new IllegalArgumentException("Die Volume der Zeitschrift fehlt!");
        }
        this.Volume=Volume;
    }

    public int getVolume(){
        return this.Volume;
    }

    public void setISSN(String ISSN) {

        if (ISSN.equals(null)|| ISSN .equals("")) {
            throw new IllegalArgumentException("Die ISSN der Zeitschrift fehlt!");
        }
        this.ISSN = ISSN;
    }

    public String getISSN(){
        return this.ISSN;
    }

    @Override
    public int CompareTo(Medium o) {
        return 0;
    }

    @Override
    public String calculateRepresentation() {
        StringBuilder zs=new StringBuilder();
        zs.append("Titel:"+getTitel()+"\n");
        zs.append("Nummer"+Nummer+"\n");
        zs.append("Volume:"+Volume+"\n");
        zs.append("ISSN:"+ISSN+"\n");
        return zs.toString();
    }

    @Override
    public int compareTo(Medium medium) {
        return 0;
    }
}
