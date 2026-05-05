public class Group extends Unit {
    private String bossName;

    public Group(String name, String bossName, int level) {
        super(name, level);
        this.bossName = bossName;
    }

    public Group findGroup(String name) {
        for (UNIT_IF member : members) {
            if (member instanceof Group && ((Group) member).getName().equals(name)) {
                return (Group) member;
            }
        }
        return null;
    }

    public void add(UNIT_IF unit) {
        members.add(unit);
    }

    public boolean remove(String name) {
        boolean removed = members.removeIf(m -> ((Unit) m).getName().equals(name));

        if (!removed) {
            for (UNIT_IF member : members) {
                if (member instanceof Group) {
                    removed = ((Group) member).remove(name);
                    if (removed) break;
                }
            }
        }
        return removed;
    }

    @Override
    public void print() {
        String indent = "  ".repeat(level);
        if (level > 0) {
            System.out.println();
        }
        System.out.println(indent + "Group: " + name + ", boss's name: " + bossName);
        for (UNIT_IF member : members) {
            member.print();
        }
    }

}

