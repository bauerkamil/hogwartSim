package hogwartSim.general;

public abstract class Item implements IItem, IPointGetter {
    protected boolean isUsed = true;

    public void getUsed(){
        this.isUsed = false;
    }
}
