package hogwartSim.interactions;

import hogwartSim.general.*;
import hogwartSim.map.MarudersMap;

/**
 * class responsible for interactions after movement (possibly accompanied with map it replaces class General)
 */
public class InteractionAgent {

    public static void action(ICreature creature1){
        /**
         * check class of creature to activate proper action
         */
        if(creature1.getClass() == Student.class)
            studentAction(creature1);

        else if(creature1.getClass() == Teacher.class)
            teacherAction(creature1);

        else if(creature1.getClass() == Basilisk.class)
            basiliskAction(creature1);

        else
            throw new IllegalArgumentException("The class of @param creature1 hasn't been specified in action - Interaction Agent");

    }
    public static void studentAction(ICreature student1){
        /**
         * check position on map for other creatures
         */
        ICreature creature2 = MarudersMap.checkPosition(student1);
        /**
        * if creature2 is a teacher activate teacher to give points
        * or if creature2 is a basilisk activate basilisk to kill the student
        */
        if(creature2.getClass() == Teacher.class)
            Teacher.addPoints((Student) student1);

        else if(creature2.getClass() == Basilisk.class)
            Basilisk.kill((Student) student1);
        /**
         * check for items...
         */
    }
    public static void teacherAction(ICreature teacher1){
        /**
         * check position on map for other creatures
         */
        ICreature creature2 = MarudersMap.checkPosition(teacher1);
        /**
         * if creature2 is a student activate teacher to give points
         */
        if(creature2.getClass() == Student.class)
            Teacher.addPoints((Student) creature2);

    }
    public static void basiliskAction(ICreature basilisk1){
        /**
         * check position on map for other creatures
         */
        ICreature creature2 = MarudersMap.checkPosition(basilisk1);
        /**
         * if creature2 is a student activate basilisk to kill the student
         */
        if(creature2.getClass() == Student.class)
            Basilisk.kill((Student) creature2);
    }
}