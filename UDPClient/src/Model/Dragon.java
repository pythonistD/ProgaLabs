package Model;

import java.io.Serializable;
import java.time.Clock;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Random;

public class Dragon implements Comparable<Dragon>, Serializable {
    Random random = new Random();
    private  long id=counter+1;  //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDate creationDate ; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long age; //Значение поля должно быть больше 0, Поле может быть null
    private double wingspan; //Значение поля должно быть больше 0
    private Boolean speaking; //Поле не может быть null
    private DragonType type; //Поле не может быть null
    private DragonHead dragonHead;
    private static LinkedList<Dragon> dragons = new LinkedList<>();
    private static long counter;
    private long max;
    private Clock clock = Clock.systemUTC();;


    public long getMax(){return max;}

    public void setMax(long max) {
        this.max = max;
    }

    public long inctCounter(){
        return counter++;
    }

    public static LinkedList<Dragon> getDragonsCollection(){
        return Dragon.dragons;
    }


    public LocalDate getCreationDare(){
        return this.creationDate;
    }



//     private  int id = random.nextInt(100);
    public  Dragon(String yaroslav, int i){

    }

    public Dragon(String name, Long age, Double wingspan, Boolean speaking, Coordinates coordinates, DragonHead dragonHead, DragonType type){
        this.name = name;
        this.age = age;
        this.wingspan=wingspan;
        this.coordinates = coordinates;
        this.speaking = speaking;
        this.type = type;
        this.dragonHead=dragonHead;
        this.creationDate = LocalDate.now(clock);
    }
    public Dragon(Long id,String name, Long age, Double wingspan, Boolean speaking, Coordinates coordinates, DragonHead dragonHead, DragonType type){
        this.name = name;
        this.age = age;
        this.id = id;
        this.wingspan=wingspan;
        this.coordinates = coordinates;
        this.speaking = speaking;
        this.type = type;
        this.dragonHead=dragonHead;
        this.creationDate = LocalDate.now(clock);
    }
    public Dragon(){
    }




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }

    public Boolean getSpeaking() {
        return speaking;
    }

    public void setSpeaking(Boolean speaking) {
        this.speaking = speaking;
    }

    public DragonType getType() {
        return type;
    }

    public void setType(DragonType type) {
        this.type = type;
    }

    public DragonHead getHead() {
        return dragonHead;
    }

    public void setHead(DragonHead head) {
        this.dragonHead = head;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dragon dragon = (Dragon) o;
        return id == dragon.id &&
                Double.compare(dragon.wingspan, wingspan) == 0 &&
                Objects.equals(random, dragon.random) &&
                Objects.equals(name, dragon.name) &&
                Objects.equals(coordinates, dragon.coordinates) &&
                Objects.equals(creationDate, dragon.creationDate) &&
                Objects.equals(age, dragon.age) &&
                Objects.equals(speaking, dragon.speaking) &&
                type == dragon.type &&
                Objects.equals(dragonHead, dragon.dragonHead);
    }

    @Override
    public int hashCode() {
        return Objects.hash(random, id, name, coordinates, creationDate, age, wingspan, speaking, type, dragonHead);
    }

    @Override
    public String toString() {
        return "id:" + id +
                ", name:" + name +
                ", age:" + age +
                ", wingspan:" + wingspan +
                ", speaking:" + speaking +
                ", x:" + coordinates.getX() +
                ", y:" + coordinates.getY() +
                ", tooth:" + dragonHead.getToothCount() +
                ", type:" + type + "\n";
    }

    @Override
    public int compareTo(Dragon o) {
        return (int) (this.age - o.getAge());
    }
}
