package hogwartSim.interactions;

import hogwartSim.general.*;
import hogwartSim.map.IMap;

import java.util.ArrayList;
import java.util.List;

/**
 * class responsible for interactions after movement (possibly accompanied with map it replaces class General)
 */
public class InteractionAgent implements IInteractionAgent {

    public static void action(ICreature creature, IMap map){
        /**
         * check class of creature to activate proper action
         */
        handleCreatureMeeting(creature, map);
        handleItemMeeting(creature, map);
    }

    /**
     * following specific actions check class of the objects before casting them to their classes
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
    public static void studentAction(Student student, List<ICreature> creaturesOnPosition){

//        /**
//         * check position on map for other creatures
//         * Each creature can interact with just one other creature
//         * (e.g. if there is a basilisk, a student and a teacher on the same position, the student will only interact with the basilisk)
//         */
//        List<ICreature> creaturesOnPosition = maraudersMap.getAtPosition(student1);
//        /**
//        * if creature2 is a teacher activate teacher to give points
//        * or if creature2 is a basilisk activate basilisk to kill the student
//        */
//        if(creature2 != null && creature2.getClass() == Teacher.class)
//            ((Teacher)creature2).changePointNumber((Student) student1);
//
//        else if(creature2 != null && creature2.getClass() == Basilisk.class)
//            ((Basilisk) creature2).kill((Student) student1);
//        /**
//         * if the student is alive (can be killed by basilisk beforehand) check for items and
//         */
//        if (!((Student)student1).getIsAlive()) {
//            IItem item = maraudersMap.checkForItemPosition(student1);
//            if (item != null)
//                ((Student) student1).use(item);
//        }

        List<Basilisk>basiliskList = getBasiliskFromCreatureList(creaturesOnPosition);
//                creaturesOnPosition.stream().filter(
//                creature -> creature.getClass() == Basilisk.class
//        );
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
    public static void teacherAction(Teacher teacher, List<ICreature> creaturesOnPosition){
//        /**
//         * check position on map for other creatures
//         */
//        ICreature creature2 = maraudersMap.getAtPosition(teacher1);
//        /**
//         * if creature2 is a student activate teacher to give points
//         */
//        if(creature2 != null && creature2.getClass() == Student.class)
//            ((Teacher)teacher1).changePointNumber((Student) creature2);
        creaturesOnPosition.forEach(
                (creature -> {
                    if (creature.getClass() == Student.class){
                        teacher.meetStudent((Student) creature);
                    }
                })
        );
    }

    /**
     * Basilisk meeting other creatures
     * @param basilisk
     * @param creaturesOnPosition
     */
    protected static void basiliskAction(Basilisk basilisk, List<ICreature> creaturesOnPosition){
//        /**
//         * check position on map for other creatures
//         */
//        ICreature creature2 = maraudersMap.getAtPosition(basilisk1);
//        /**
//         * if creature2 is a student activate basilisk to kill the student
//         */
//        if(creature2 != null && creature2.getClass() == Student.class)
//            ((Basilisk)basilisk1).kill((Student) creature2);
        creaturesOnPosition.forEach(
                (creature -> {
                    if (creature.getClass() == Student.class){
                        basilisk.kill((Student) creature);
                    }
                })
        );
    }
}
