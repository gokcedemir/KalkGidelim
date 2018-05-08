
public class Hayvan {

    public String animalName;
    public String kindOfAnimal;
    public String whichAnimal;
    public String inputDate;
    public String outputDate;
    public String animalOwner;
    public String phoneNumber;
    public int barinakId;

    @Override
    public String toString() {
        return animalName + " " + barinakId
                + " " + whichAnimal + " " + kindOfAnimal + " " + inputDate
                + " " + outputDate + " " + animalOwner + " " + phoneNumber;
    }
}
