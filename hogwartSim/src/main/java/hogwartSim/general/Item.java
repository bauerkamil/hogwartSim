package hogwartSim.general;

import hogwartSim.map.IMap;

public abstract class Item implements IItem {
    protected boolean isUsed;
    protected IMap map;

    public Item(IMap map){
        this.map = map;
        this.isUsed = true;
    }

    public void getUsed(){
        this.isUsed = false;
    }

//    public void meetStudent(Student student){}
}
