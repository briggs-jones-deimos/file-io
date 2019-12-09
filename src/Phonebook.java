import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Phonebook {


    public ArrayList<Contact> contact = new ArrayList<>();


    final static String directory = "data";
    final static String fileName = "contacts.txt";


    final static Path path = Paths.get(directory,fileName);

    public Phonebook() {
        contact.add(new Contact("alyssa","2105550189"));
        contact.add(new Contact("amber","2105550189"));
        contact.add(new Contact("fer","2105550189"));
    }


    public boolean checkPath(){
        return Files.exists(path);
    }

    public void createPath(){
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, fileName);
       try{
           if (Files.notExists(dataDirectory)){
               Files.createDirectories(dataDirectory);
           }
           if (Files.exists(dataFile)){
               Files.createFile(dataFile);
           }
       }
       catch (IOException e){
           System.out.println("Error E" + e);
       }
    }

    public void writeToFile(){
        if (!checkPath()){
            createPath();
        }

        try {
            ArrayList<String> temp = new ArrayList<>();
            for (Contact c : contact){
                String name = c.getName();
                String number = c.getPhoneNum();
                temp.add(name + " | " + number);
            }
            Files.write(path, temp);
        } catch (IOException e){
            System.out.println("Error" + e);
        }

    }

    public void addContact(String name, String phoneNum){
        contact.add(new Contact(name, phoneNum));
        writeToFile();
    }

    public String searchContacts(String name){
        String person = "Not Found";
        for (Contact c : contact){
            if (c.getName().equalsIgnoreCase(name)){
                person = c.getAll();
            }
        }
        return person;
    }

    public String deleteContact(String name){
        String message = "Not Found";
        for (Contact c : contact){
            if (c.getName().equalsIgnoreCase(name)){
                contact.remove(c);
                message = "Contact Deleted";
            }
        }
        return message;
    }
}
