package hogwartSim.map;

import hogwartSim.general.*;

public class InteractionAgent {

    public static void action(ICreature creature1, ICreature creature2){
        /**
         * check class of creature to activate proper action
         */
        if(creature1.getClass() == Student.class){
            /**
             * if creature1 is a student activate teacher to give points or basilisk to kill the student
             */
            if(creature2.getClass() == Teacher.class)
                Teacher.addPoints((Student) creature1);

            else if(creature2.getClass() == Basilisk.class)
                Basilisk.kill((Student) creature1);
        }
        /**
         * if creature1 is a teacher and creature2 is a student add points
         */
        else if(creature1.getClass() == Teacher.class){

            if(creature2.getClass() == Student.class)
                Teacher.addPoints((Student) creature2);
        }
        /**
         * if creature1 is a basilisk and creature2 is a student kill the student
         */
        else if(creature1.getClass() == Basilisk.class){
            Basilisk.kill((Student) creature2);
        }

        else
            throw new IllegalArgumentException("The class of @param creature1 hasn't been specified in Interaction Agent");

    }
}
