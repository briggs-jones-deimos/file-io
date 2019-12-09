import util.Input;

import java.util.Scanner;

public class PhoneApp {
    private Scanner scan = new Scanner(System.in);
    private Phonebook book = new Phonebook();
    private Input util = new Input();

    public PhoneApp() {
        book.getContacts();
        showChoices();
    }

    public void showChoices(){
        System.out.println("" +
                "1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");

        int answer = util.getInt(1, 5);
        deployChoice(answer);
    }

    private void deployChoice(int choice){
        switch (choice){
            case 1:
                book.getContacts(); break;
            case 2:
                addContact(); break;
            case 3:
                searchByName(); break;
            case 4:
                deleteByName(); break;
            case 0:
            case 5:
            default: exit(); break;
        }

    }

    private void addContact(){
        System.out.print("Contact name:\n");
        String name = util.getString();
        System.out.print("Phone number: \n");
        String number = util.getString();
        book.addContact(name, number);
    }

    private void searchByName(){
        System.out.print("Name: \n");
        String name = util.getString();
        book.searchContacts(name);
    }

    private void deleteByName(){
        System.out.print("Name: \n");
        String name = util.getString();
        book.deleteContact(name);
    }

    private void exit(){
        System.out.println("Goodbye.");
    }

}
