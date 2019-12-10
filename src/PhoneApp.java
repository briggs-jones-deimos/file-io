import util.Input;

import java.util.Scanner;

public class PhoneApp {
    private Scanner scan = new Scanner(System.in);
    private Phonebook book = new Phonebook();
    private Input util = new Input();

    public PhoneApp() throws Exception {
        book.getContacts();
        showChoices();
    }

    public void showChoices() throws Exception {
        System.out.println("" +
                "1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");

        int answer = util.getInt(1, 5, 0);
        deployChoice(answer);
    }

    private void deployChoice(int choice) throws Exception {
        switch (choice){
            case 1:
                showContacts(); break;
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

    private void showContacts() throws Exception {
        book.getContacts();
        askToContinue();
    }

    private void addContact() throws Exception {
        System.out.print("Contact name:\n");
        String name = util.getString();
        System.out.print("Phone number: \n");
        String number = util.getString();
        if (!checkForContact(name, number)) {
            book.addContact(name, number);
        }
        showContacts();
        askToContinue();
    }

    private boolean checkForContact(String name, String number) throws Exception {
        boolean exists = false;
        for (Contact c : book.contact){
            if (name.equalsIgnoreCase(c.getName())){
                exists = true;
                System.out.println("There's already a contact named " + name + ". Do you want to overwrite it? " +
                        "(Yes/No)\n");
                boolean choice = util.getBoolean();
                if (choice) {
                    c.setName(name);
                    c.setPhoneNum(number);
                }
            }
        }
        return exists;
    }

    private void searchByName() throws Exception {
        System.out.print("Name: \n");
        String name = util.getString();
        System.out.println(book.searchContacts(name));
        askToContinue();
    }

    private void deleteByName() throws Exception {
        System.out.print("Name: \n");
        String name = util.getString();
        System.out.println(book.deleteContact(name));
        showContacts();
        askToContinue();
    }

    private void exit(){
        System.out.println("Goodbye.");
    }

    private void askToContinue() throws Exception {
        System.out.println("Do you wish to continue?");
        boolean answer = util.getBoolean();
        if (answer) {
            showChoices();
        } else {
            exit();
        }

    }

}
