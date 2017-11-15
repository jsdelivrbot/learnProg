package com.tinoromero;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone phone = new MobilePhone("662 119 1310");

    public static void main(String[] args) {
        /*
        Able to store, modify, remove and query contact names
        Separate Contacts class (name and phone number).
        MobilePhone class holds ArrayList of Contacts
        Add menu: Quit, Print list of contacts, add new contact, update existing contact, remove contact, and search/find contact
        When adding or updating be sure to check if the contact already exists (using name)
        Be ure not to expose the inner working of the ArrayList to MobilePhone
        MobilePhone should do everything with Contact objects only
        */
        boolean quit = false;
        int choice = 0;
        startPhone();
        printInstructions();
        while(!quit) {
            System.out.println("Enter you choice (6 for list of option):");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Shutting down...");
                    quit = true;
                    break;
                case 1:
                    printContacts();
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

    private static void addContact() {
        System.out.println("Enter contact name:");
        String name = scanner.nextLine();
        System.out.println("Enter phone number:");
        String number = scanner.nextLine();
        Contact newContact = Contact.createContact(name, number);
        if (phone.addNewContact(newContact)) {
            System.out.println("New contact added: " + name + " -> " + number);
        } else {
            System.out.println("Cannot add contact.");
        }
    }

    private static void updateContact() {
        System.out.println("Name of contact:");
        String name = scanner.nextLine();
        Contact currentContact = phone.queryContact(name);
        if(currentContact == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("Enter new contact name:");
        String newName = scanner.nextLine();
        System.out.println("Enter new phone number:");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if(phone.updateContact(currentContact, newContact)) {
            System.out.println("Successfully updated record.");
        } else {
            System.out.println("Error updating record.");
        }
    }

    private static void removeContact() {
        System.out.println("Name of contact:");
        String name = scanner.nextLine();
        Contact contact = phone.queryContact(name);
        if(contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        if(phone.removeContact(contact)) {
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Error deleting contact.");
        }
    }

    private static void queryContact() {
        System.out.println("Name of contact:");
        String name = scanner.nextLine();
        Contact contact = phone.queryContact(name);
        if(contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("Name: " + contact.getName() + " - Phone Number: " + contact.getPhoneNumber());
    }

    public static void printInstructions() {
        System.out.println("\nPress");
        System.out.println("\t 0 - To quit.");
        System.out.println("\t 1 - To print list of contacts.");
        System.out.println("\t 2 - To add a new contact.");
        System.out.println("\t 3 - To update an existing contact.");
        System.out.println("\t 4 - To remove a contact.");
        System.out.println("\t 5 - To query if an existing contact exists.");
        System.out.println("\t 6 - To print a list of available actions.");
    }

    public static void printContacts() {
        phone.printContacts();
    }

    public static void startPhone() {
        System.out.println("Starting phone...");
    }
}
