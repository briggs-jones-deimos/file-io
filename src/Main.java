public class Main {
    public static void main(String[] args) {
        Phonebook myphonebook = new Phonebook();

        System.out.println(myphonebook.checkPath());
        myphonebook.writeToFile();
        myphonebook.addContact("karli", "2015550819");
        System.out.println(myphonebook.searchContacts("alyssa"));
    }
}
