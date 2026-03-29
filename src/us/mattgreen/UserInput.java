package us.mattgreen;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInput {
    private final ArrayList<Talkable> list;
    private final Scanner scanner = new Scanner(System.in);

    public UserInput(ArrayList<Talkable> list) {
        this.list = list;
    }

    public void addAnimal() {
        System.out.println("Which type of animal would you like to create? (Dog / Cat / Teacher)");
        String type = scanner.nextLine().trim();

        while (true) {
            if (type.equalsIgnoreCase("Dog")) {
                createDog();
                break;
            } else if (type.equalsIgnoreCase("Cat")) {
                createCat();
                break;
            } else if (type.equalsIgnoreCase("Teacher")) {
                createTeacher();
                break;
            } else {
                System.out.println("Invalid type. Please enter: Dog, Cat, or Teacher");
                type = scanner.nextLine().trim();
            }
        }
    }

    private void createDog() {
        String name = promptNonEmpty("Enter the dog's name:");
        boolean friendly = promptBoolean("Is the dog friendly? (true/false or yes/no):");
        list.add(new Dog(friendly, name));
        System.out.println("Dog added: " + name);
    }

    private void createCat() {
        String name = promptNonEmpty("Enter the cat's name:");
        int mouses = promptInt("How many mouses has the cat killed? (integer):");
        list.add(new Cat(mouses, name));
        System.out.println("Cat added: " + name);
    }

    private void createTeacher() {
        String name = promptNonEmpty("Enter the teacher's name:");
        int age = promptInt("Enter the teacher's age (integer):");
        list.add(new Teacher(age, name));
        System.out.println("Teacher added: " + name);
    }

    private String promptNonEmpty(String prompt) {
        while (true) {
            System.out.println(prompt);
            String s = scanner.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Input cannot be empty.");
        }
    }

    private int promptInt(String prompt) {
        while (true) {
            System.out.println(prompt);
            String s = scanner.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private boolean promptBoolean(String prompt) {
        while (true) {
            System.out.println(prompt);
            String s = scanner.nextLine().trim().toLowerCase();
            if (s.equals("true") || s.equals("false")) return Boolean.parseBoolean(s);
            if (s.equals("yes") || s.equals("y")) return true;
            if (s.equals("no") || s.equals("n")) return false;
            System.out.println("Please enter true/false or yes/no.");
        }
    }
}
