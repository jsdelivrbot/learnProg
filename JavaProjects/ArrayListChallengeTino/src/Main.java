import java.util.Scanner;

public class Main {
    /*
        Able to store, modify, remove and query contact names
        Separate Contacts class (name and phone number).
        MobilePhone class holds ArrayList of Contacts
        Add menu: Quit, Print list of contacts, add new contact, update existing contact, remove contact, and search/find contact
        When adding or updating be sure to check if the contact already exists (using name)
        Be ure not to expose the inner working of the ArrayList to MobilePhone
        MobilePhone should do everything with Contact objects only
    */
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone phone = new MobilePhone("662-119-1310");

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;

        printInstructions();
        while(!quit) {
            System.out.println("Enter your choice (6 for list of options):");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    printContactList();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printInstructions();
                    break;
            }
        }
    }

    public static void printContactList() {
        if(!phone.printContactList()) {
            System.out.println("No contacts in Contact List.");
        }
    }

    public static void addContact() {
        System.out.println("Enter contact name:");
        String name = scanner.nextLine();
        System.out.println("Enter phone number:");
        String number = scanner.nextLine();
        Contact newContact = Contact.createContact(name, number);
        if(phone.addNewContact(newContact)) {
            System.out.println("Contact added.");
        } else {
            System.out.println("Error adding contact.");
        }
    }

    public static void updateContact() {
        System.out.println("Enter contact name:");
        String oldName = scanner.nextLine();
        Contact oldContact = phone.queryContact(oldName);
        if(oldContact == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("Enter new name:");
        String newName = scanner.nextLine();
        System.out.println("Enter new phone number:");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if(phone.updateContact(oldContact, newContact)) {
            System.out.println("Contact updated.");
        } else {
            System.out.println("Error updating contact.");
        }
    }

    public static void removeContact() {
        System.out.println("Enter name of contact to be removed.");
        String contact = scanner.nextLine();
        if(phone.removeContact(contact)) {
            System.out.println(contact + " has been removed.");
        } else {
            System.out.println("Error removing contact.");
        }
    }

    public static void queryContact() {
        System.out.println("Enter name of contact:");
        String name = scanner.nextLine();
        Contact contact = phone.queryContact(name);
        if(contact!=null) {
            System.out.println("Name: " + name + " - Number: " + contact.getNumber());
        } else {
            System.out.println("Error with query.");
        }
    }

    public static void printInstructions() {
        System.out.println("Press:\n" +
                        "0 - Quit\n" +
                        "1 - Print Contact List\n" +
                        "2 - Add new contact\n" +
                        "3 - Update existing contact\n" +
                        "4 - Remove contact\n" +
                        "5 - Query contact\n" +
                        "6 - Print list of available options\n");
    }
}
