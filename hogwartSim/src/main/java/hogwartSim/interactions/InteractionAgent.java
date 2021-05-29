package hogwartSim.interactions;

import hogwartSim.general.*;
import hogwartSim.map.IMap;

/**
 * class responsible for interactions after movement (possibly accompanied with map it replaces class General)
 */
public class InteractionAgent {

    public static void action(ICreature creature1, IMap maraudersMap){
        /**
         * check class of creature to activate proper action
         */
        if(creature1.getClass() == Student.class)
            studentAction(creature1, maraudersMap);

        else if(creature1.getClass() == Teacher.class)
            teacherAction(creature1, maraudersMap);

        else if(creature1.getClass() == Basilisk.class)
            basiliskAction(creature1, maraudersMap);

        else
            throw new IllegalArgumentException("The class of @param creature1 hasn't been specified in action - Interaction Agent");

    }

    /**
     * following specific actions check class of the objects before casting them to their classes
     */


    public static void studentAction(ICreature student1, IMap maraudersMap){
        /**
         * check position on map for other creatures
         * Each creature can interact with just one other creature
         * (e.g. if there is a basilisk, a student and a teacher on the same position, the student will only interact with the basilisk)
         */
        ICreature creature2 = maraudersMap.checkPosition(student1);
        /**
        * if creature2 is a teacher activate teacher to give points
        * or if creature2 is a basilisk activate basilisk to kill the student
        */
        if(creature2.getClass() == Teacher.class)
            ((Teacher)creature2).changePointNumber((Student) student1);

        else if(creature2.getClass() == Basilisk.class)
            ((Basilisk) creature2).kill((Student) student1);
        /**
         * if the student is alive (can be killed by basilisk beforehand) check for items and
         */
        if (((Student)student1).getIsAlive()){
            IItem item = maraudersMap.checkForItemPosition(student1);
            if(item != null)
                ((Student)student1).use(item);
        }

    }
    public static void teacherAction(ICreature teacher1, IMap maraudersMap){
        /**
         * check position on map for other creatures
         */
        ICreature creature2 = maraudersMap.checkPosition(teacher1);
        /**
         * if creature2 is a student activate teacher to give points
         */
        if(creature2.getClass() == Student.class)
            ((Teacher)creature2).changePointNumber((Student) creature2);

    }
    public static void basiliskAction(ICreature basilisk1, IMap maraudersMap){
        /**
         * check position on map for other creatures
         */
        ICreature creature2 = maraudersMap.checkPosition(basilisk1);
        /**
         * if creature2 is a student activate basilisk to kill the student
         */
        if(creature2.getClass() == Student.class)
            ((Basilisk)basilisk1).kill((Student) creature2);
    }
}
