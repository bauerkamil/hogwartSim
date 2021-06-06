package hogwartSim.interactions;

import hogwartSim.general.*;
import hogwartSim.map.IMap;

import java.util.ArrayList;
import java.util.List;


/**
 * Class responsible for interactions after movement
 */
public class InteractionAgent implements IInteractionAgent {

    /**
     * handles cases of creatures meeting other things on the map
     * @param creature
     * @param map
     */
    public static void action(ICreature creature, IMap map){

        handleCreatureMeeting(creature, map);
        handleItemMeeting(creature, map);
    }


    /**
     * Checks class of creature and activates proper action
     * @param creature
     * @param map
     */
    protected static void handleCreatureMeeting(ICreature creature, IMap map){
        List<ICreature> creaturesOnPosition = map.getAtPosition(map.getPosition(creature));


        if (creaturesOnPosition == null || creaturesOnPosition.size() < 2){
            return;
        }

        creaturesOnPosition.remove(creature);

        if(creature.getClass() == Student.class)
            studentAction((Student)creature, creaturesOnPosition);

        else if(creature.getClass() == Teacher.class)
            teacherAction((Teacher)creature, creaturesOnPosition);

        else if(creature.getClass() == Basilisk.class){
            basiliskAction((Basilisk)creature, creaturesOnPosition);
        }
        else
            throw new IllegalArgumentException("The class of @param creature hasn't been specified in handleCreatureMeeting - Interaction Agent");

    }

    /**
     * The class responsible for action between creatures and items
     * @param creature Student, teacher or basilisk
     * @param map The map
     */
    protected static void handleItemMeeting(ICreature creature, IMap map){
        if (creature.getClass() != Student.class){
           return;
        }
        Student student = (Student) creature;

        if(!student.getIsAlive()){
            return;
        }
        List<IItem> itemsOnPosition = map.getItemsAtPosition(map.getPosition(student));

        for(IItem item : itemsOnPosition){
            student.use(item);
        }

    }

    /**
     * Class responsible for running specific actions between student and other creatures
     * @param student The student
     * @param creaturesOnPosition Other creatures on the same position as the student
     */
    public static void studentAction(Student student, List<ICreature> creaturesOnPosition){

        List<Basilisk>basiliskList = getBasiliskFromCreatureList(creaturesOnPosition);


        if (basiliskList.size() > 0){
            Basilisk basilisk0 = basiliskList.get(0);
            basilisk0.kill(student);
        }


        creaturesOnPosition.stream().filter(
                creature -> creature.getClass() == Teacher.class
        ).forEach(c -> {
            ((Teacher)c).meetStudent(student);
        });

    }
    protected static List<Basilisk> getBasiliskFromCreatureList(List<ICreature> creaturesOnPosition){
        final List<Basilisk>basiliskList = new ArrayList<>();

        creaturesOnPosition.forEach(creature -> {
            if (creature.getClass() == Basilisk.class)
                basiliskList.add((Basilisk) creature);
        });
        return basiliskList;
    }

    /**
     * Class responsible for running specific actions between teacher and other creatures
     * @param teacher The teacher
     * @param creaturesOnPosition Other creatures on the same position as the teacher
     */
    public static void teacherAction(Teacher teacher, List<ICreature> creaturesOnPosition){

        creaturesOnPosition.forEach(
                (creature -> {
                    if (creature.getClass() == Student.class){
                        teacher.meetStudent((Student) creature);
                    }
                })
        );
    }

    /**
     * Class responsible for running specific actions between teacher and other creatures
     * @param basilisk The basilisk
     * @param creaturesOnPosition Other creatures on the same position as the basilisk
     */
    protected static void basiliskAction(Basilisk basilisk, List<ICreature> creaturesOnPosition){

        creaturesOnPosition.forEach(
                (creature -> {
                    if (creature.getClass() == Student.class){
                        basilisk.kill((Student) creature);
                    }
                })
        );
    }
}
