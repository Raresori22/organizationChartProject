import java.util.ArrayList;

public abstract class Unit implements UNIT_IF {
    protected String name;
    protected ArrayList<UNIT_IF> members = new ArrayList<>();
    protected int level;

    public Unit(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
}