package Aufgabe4;

public class CD extends Medium{
    private String Label;
    private String Kuenstler;

    public CD(String Titel,String Kuenstler,String Label){
        super(Titel);
        setKuenstler(Kuenstler);
        setLabel(Label);
    }


    public String getLabel(){
        return Label;
    }

    public void setLabel(String Label) {

        if (Label.equals(null)|| Label.equals("")) {
            throw new IllegalArgumentException("Das Label der CD fehlt!");
        }
        this.Label = Label;
    }

    public String getKuenstler(){
        return Kuenstler;
    }

    public void setKuenstler(String Kuenstler) {

        if (Kuenstler.equals(null)|| Kuenstler.equals("")) {
            throw new IllegalArgumentException("Der Name des Künstlers der CD fehlt!");
        }
        this.Kuenstler = Kuenstler;
    }

    @Override
    public int CompareTo(Medium o) {
        return 0;
    }

    @Override
    public String calculateRepresentation() {
        StringBuilder cd=new StringBuilder();
        cd.append("Titel:"+getTitel()+"\n");
        cd.append("Künstler:"+Kuenstler+"\n");
        cd.append("Label:"+Label+"\n");
        return cd.toString();
    }

    @Override
    public int compareTo(Medium medium) {
        return 0;
    }
}
