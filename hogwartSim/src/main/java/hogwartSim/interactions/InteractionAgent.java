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
    public static void studentAction(ICreature student1, IMap maraudersMap){
        /**
         * check position on map for other creatures
         */
        ICreature creature2 = maraudersMap.checkPosition(student1);
        /**
        * if creature2 is a teacher activate teacher to give points
        * or if creature2 is a basilisk activate basilisk to kill the student
        */
        if(creature2.getClass() == Teacher.class)
            Teacher.addPoints((Student) student1);

        else if(creature2.getClass() == Basilisk.class)
            ((Basilisk) creature2).kill((Student) student1);
        /**
         * check for items...
         */
        IItem item = maraudersMap.checkItemPosition(student1);
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
            Teacher.addPoints((Student) creature2);

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
