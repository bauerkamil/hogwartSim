package hogwartSim.general;

public class Teacher extends Wizard implements IPointGetter {

    protected String house;

    public Teacher(String house) {
        super(house);
    }

    public static void addPoints(Student student1) {
    }
}
