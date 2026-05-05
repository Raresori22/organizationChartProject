public class Person extends Unit {
    public Person(String name, int level) {
        super(name,level);
    }

    @Override
    public void print() {
        String indent = "  ".repeat(level);
        System.out.println(indent + "Worker: " + name);
    }
}
