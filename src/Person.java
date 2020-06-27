import java.io.Serializable;

/**
 * Класс для описания покупателя билета.
 * @author Дмитрий Толочек P3130
 * @version 2.0 After 5 lab check.
 */

public class Person implements Comparable<Person>, Serializable {
    private static final long serialVersionUID = 0;
    private Double weight; //Поле может быть null, Значение поля должно быть больше 0
    private Color eyeColor; //Поле не может быть null
    private Color hairColor; //Поле может быть null
    private Country nationality; //Поле может быть null
    private Location location; //Поле может быть null

    public Double getWeight() {return weight;}
    public void setWeight(Double weight) {this.weight = weight;}

    public Color getEyeColor() {return eyeColor;}
    public void setEyeColor(Color eyeColor) {this.eyeColor = eyeColor;}

    public Color getHairColor() {return hairColor;}
    public void setHairColor(Color hairColor) {this.hairColor = hairColor;}

    public Country getNationality() {return nationality;}
    public void setNationality(Country nationality) {this.nationality = nationality;}

    public Location getLocation() {return location;}
    public void setLocation(Location location) {this.location = location;}

    /**
     * Метод для показа информации о человеке
     */
    public void showInfo(){
        System.out.println("Weight: " + this.weight);
        System.out.println("EyeColor: " + this.eyeColor);
        System.out.println("HairColor: " + this.hairColor);
        System.out.println("Nationality: " + this.nationality);
        System.out.println("Location - " + this.location);
    }

    @Override
    public int compareTo(Person a) {
        double A, B;
        if (this.weight == null){A = 0.0;} else {A = this.weight;}
        if (a.weight == null){B = 0.0;} else {B = a.weight;}
        return Double.compare(A, B);
    }
}
