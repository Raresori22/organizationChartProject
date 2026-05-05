import java.util.Scanner;
import java.util.ArrayList;


public class main {
    static Group marketing;
    static Group software;
    static Group humanResources;
    public static void main(String[] args) {
        String choice = "";
        Scanner scanner = new Scanner(System.in);
        Group org = null;
        String personName = "";
        String groupName = "";
        Group target = null;

        do {
            System.out.println("Organization management system");
            System.out.println("------------------------------");
            System.out.println();
            System.out.println("1. Create and print hard coded organization");
            System.out.println("2. Print organization, add person to it and finally print it");
            System.out.println("3. Print organization, remove person from it and finally print it");
            System.out.println("Q. Quit the application");
            System.out.println();
            System.out.print("Your choice: ");
            choice = scanner.nextLine().trim();
            System.out.println();
            switch (choice.toUpperCase()) {
                case "1":
                    org = createHardcodedOrganization();
                    org.print();
                    break;
                case "2":
                    if(org == null) {
                        System.out.println("Please create an organization first! Create it in the first step.");
                        break;
                    }
                    org.print();
                    System.out.println();
                    System.out.print("Give unit name: ");
                    groupName = scanner.nextLine();
                    target = org.findGroup(groupName);
                    System.out.print("Give person name: ");
                    personName = scanner.nextLine();
                    System.out.println();
                    if(target == null) {
                        System.out.println("ERROR: Group not found!");
                        break;
                    }
                    if(!checkValidName(personName)) {
                        break;
                    }
                    System.out.println();
                    target.add(new Person(personName, target.getLevel() + 1));
                    org.print();
                    break;
                case "3":
                    if(org == null) {
                        System.out.println("Please create an organization first! Create it in the first step.");
                        break;
                    }
                    org.print();
                    System.out.println();
                    System.out.print("Give person name: ");
                    personName = scanner.nextLine();
                    if(!checkValidName(personName)) {
                        break;
                    }
                    if (!org.remove(personName)) {
                        System.out.println();
                        System.out.println("ERROR: Person not found!");
                        break;
                    }
                    System.out.println();
                    org.print();
                    break;
                case "Q":
                    scanner.close();
                    break;
                default:
                    System.out.println("Please select a valid choice! The choices are: 1, 2, 3, Q/q");
            }
            System.out.println("");
        } while(!choice.equalsIgnoreCase("Q"));
    }

    public static boolean checkValidName(String name) {
        if (name == null || name.isBlank()) {
            System.out.println();
            System.out.println("ERROR: Name cannot be empty!");
            return false;
        }

        String[] parts = name.trim().split("\\s+");

        if (parts.length != 2) {
            System.out.println();
            System.out.println("ERROR: Name must contain exactly last name and first name!");
            return false;
        }

        for (String part : parts) {
            if (!Character.isUpperCase(part.charAt(0))) {
                System.out.println();
                System.out.println("ERROR: First name and last name must start with a capital letter!");
                return false;
            }
        }
        return true;
    }

    public static Group createHardcodedOrganization() {
        Group root = new Group("Top Management", "Barbu Rares", 0);
        root.add(new Person("Wally Allan", 1));

        marketing = new Group("Marketing", "Rafael Jabbari", 1);
        marketing.add(new Person("Michael Garcia", 2));
        marketing.add(new Person("Robert Martinez", 2));
        root.add(marketing);

        software = new Group("Software Development", "Lam Huong", 1);
        software.add(new Person("Danny Cherry", 2));
        software.add(new Person("Ryan Nash", 2));
        software.add(new Person("Grey Rangel", 2));
        root.add(software);

        humanResources = new Group("Human Resources", "Illia Homon", 1);
        humanResources.add(new Person("Kash Todd", 2));
        humanResources.add(new Person("James Williams", 2));
        root.add(humanResources);

        return root;
    }
}



