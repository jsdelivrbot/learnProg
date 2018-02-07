package com.tinoromero;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/Tino Romero/Documents/Cursos/LearnProg/JavaProjects/JDBC/" + DB_NAME;

    public static final String TABLE_CONTACTS = "contacts";
    public static final String TABLE_SCHOOLS = "schools";

    public static final String COLUMN_CONTACT_ID = "contact_id";
    public static final String COLUMN_CONTACT_NAME = "contact_name";
    public static final String COLUMN_CONTACT_PHONE = "contact_phone";
    public static final String COLUMN_CONTACT_SCHOOL_ID = "school_id";

    public static final String COLUMN_SCHOOL_ID = "school_id";
    public static final String COLUMN_SCHOOL_NAME = "school_name";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

//            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
//            statement.execute("DROP TABLE IF EXISTS " + TABLE_SCHOOLS);

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS + " (" +
                    COLUMN_CONTACT_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_CONTACT_NAME + " TEXT, " +
                    COLUMN_CONTACT_PHONE + " INTEGER, " +
                    COLUMN_CONTACT_SCHOOL_ID + " INTEGER, " +
                    "FOREIGN KEY (" + COLUMN_CONTACT_SCHOOL_ID + ") REFERENCES " +
                    TABLE_SCHOOLS + "(" + COLUMN_SCHOOL_ID +
                    "))");

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_SCHOOLS + " (" +
                    COLUMN_SCHOOL_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_SCHOOL_NAME + " TEXT" +
                    ")");

//            ResultSet results = statement.executeQuery("SELECT * FROM contacts");
//
//            while(results.next()) {
//                System.out.println(results.getString(COLUMN_CONTACT_ID) + " " + results.getString(COLUMN_CONTACT_NAME) + " " +
//                        results.getInt(COLUMN_CONTACT_PHONE) + " " +
//                        results.getString(COLUMN_CONTACT_SCHOOL_ID));
//            }
//
//            results.close();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error." + e.getMessage());
            e.printStackTrace();
        }

        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit) {
            System.out.println("\nEnter choice:");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 0:
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
                    printSchools();
                    break;
                case 7:
                    addSchool();
                    break;
                case 8:
                    updateSchool();
                    break;
                case 9:
                    removeSchool();
                    break;
                case 10:
                    querySchool();
                    break;
                case 11:
                    printInstructions();
                    break;
                default:
                    System.out.println(":O");
                    break;
            }
        }
    }


    private static void printContacts() {
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            ResultSet results = statement.executeQuery("SELECT " +
                    COLUMN_CONTACT_NAME + ", " + COLUMN_CONTACT_PHONE + ", " + TABLE_SCHOOLS + "." + COLUMN_SCHOOL_NAME + " " +
                    "FROM " + TABLE_CONTACTS + " " +
                    "LEFT JOIN " + TABLE_SCHOOLS + " ON " + TABLE_CONTACTS + "." + COLUMN_CONTACT_SCHOOL_ID + "=" +
                    TABLE_SCHOOLS + "." + COLUMN_SCHOOL_ID);

            while(results.next()) {
                System.out.println(results.getString(COLUMN_CONTACT_NAME) + " " +
                        results.getInt(COLUMN_CONTACT_PHONE) + " " +
                        results.getString(COLUMN_SCHOOL_NAME));
            }

            results.close();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error." + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void printSchools() {
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_SCHOOLS);

            while(results.next()) {
                System.out.println(results.getString(COLUMN_SCHOOL_ID) + " " +
                        results.getString(COLUMN_SCHOOL_NAME));
            }

            results.close();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error." + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void addContact() {
        System.out.println("Enter contact name:");
        String name = scanner.nextLine();
        System.out.println("Enter contact phone:");
        int phone = scanner.nextInt();
        System.out.println("Enter contact school id;");
        int schoolId = scanner.nextInt();

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            statement.execute("INSERT INTO " + TABLE_CONTACTS + " (" +
                    COLUMN_CONTACT_NAME + ", " +
                    COLUMN_CONTACT_PHONE + ", " +
                    COLUMN_CONTACT_SCHOOL_ID + ") " +
                    "VALUES('" + name + "', " + phone + ", '" + schoolId + "')");

            System.out.println("Added " + name + " to contacts list.");

            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error." + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void addSchool() {
        System.out.println("Enter school name:");
        String name = scanner.nextLine();

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            statement.execute("INSERT INTO " + TABLE_SCHOOLS + " (" +
                    COLUMN_SCHOOL_NAME + ") " +
                    "VALUES('" + name + "')");

            System.out.println("Added " + name + " to contacts list.");

            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error." + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void updateContact() {
        System.out.println("Enter contact name to be updated:");
        String oldContact = scanner.nextLine();
        System.out.println("Enter new contact name:");
        String newContact = scanner.nextLine();
        System.out.println("Enter new phone number:");
        int phone = scanner.nextInt();
        System.out.println("Enter new school id:");
        int schoolId = scanner.nextInt();

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            statement.execute("UPDATE " + TABLE_CONTACTS + " SET " +
                    COLUMN_CONTACT_NAME + "='" + newContact + "', " +
                    COLUMN_CONTACT_PHONE + "=" + phone +", " +
                    COLUMN_CONTACT_SCHOOL_ID + "=" + schoolId + " " +
                    "WHERE " + COLUMN_CONTACT_NAME + "='" + oldContact + "'");

            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error." + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void updateSchool() {
        System.out.println("Enter school name to be updated:");
        String oldSchool = scanner.nextLine();
        System.out.println("Enter new school name:");
        String newSchool = scanner.nextLine();

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            statement.execute("UPDATE " + TABLE_SCHOOLS + " SET " +
                    COLUMN_SCHOOL_NAME + "='" + newSchool + "' " +
                    "WHERE " + COLUMN_SCHOOL_NAME + "='" + oldSchool + "'");

            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error." + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void removeContact() {
        System.out.println("Name of contact to delete:");
        String removeContact = scanner.nextLine();

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            statement.execute("DELETE FROM " + TABLE_CONTACTS + " " +
                    "WHERE " + COLUMN_CONTACT_NAME + "='" + removeContact + "'");

            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error." + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void removeSchool() {
        System.out.println("Name of school to delete:");
        String removeSchool = scanner.nextLine();

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            statement.execute("DELETE FROM " + TABLE_SCHOOLS + " " +
                    "WHERE " + COLUMN_SCHOOL_NAME + "='" + removeSchool + "'");

            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error." + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void queryContact() {
        System.out.println("Search for (contact name):");
        String queryContact = scanner.nextLine();

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            ResultSet results = statement.executeQuery("SELECT " +
                    COLUMN_CONTACT_NAME + ", " + COLUMN_CONTACT_PHONE + ", " + TABLE_SCHOOLS + "." + COLUMN_SCHOOL_NAME + " " +
                    "FROM " + TABLE_CONTACTS + " " +
                    "LEFT JOIN " + TABLE_SCHOOLS + " ON " + TABLE_CONTACTS + "." + COLUMN_CONTACT_SCHOOL_ID + "=" +
                    TABLE_SCHOOLS + "." + COLUMN_SCHOOL_ID + " " +
                    "WHERE " + COLUMN_CONTACT_NAME + "='" + queryContact + "'");

            System.out.println(results.getString(COLUMN_CONTACT_NAME) + " " +
                    results.getInt(COLUMN_CONTACT_PHONE) + " " +
                    results.getString(COLUMN_SCHOOL_NAME));

            results.close();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error." + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void querySchool() {
        System.out.println("Query school's students (school id):");
        int schoolId = scanner.nextInt();

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            ResultSet results = statement.executeQuery("SELECT " +
                    COLUMN_CONTACT_NAME + ", " + COLUMN_CONTACT_PHONE + " " +
                    "FROM " + TABLE_CONTACTS + " " +
                    "WHERE " + COLUMN_CONTACT_SCHOOL_ID + "=" + schoolId);

            while(results.next()) {
                System.out.println(results.getString(COLUMN_CONTACT_NAME) + " " +
                        results.getString(COLUMN_CONTACT_PHONE));
            }

            results.close();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error." + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress");
        System.out.println("\t 0 - To quit.");
        System.out.println("\t 1 - To print list of contacts.");
        System.out.println("\t 2 - To add a new contact.");
        System.out.println("\t 3 - To update an existing contact.");
        System.out.println("\t 4 - To remove a contact.");
        System.out.println("\t 5 - To query if an existing contact exists.");
        System.out.println("\t 6 - To print list of schools.");
        System.out.println("\t 7 - To add a new school.");
        System.out.println("\t 8 - To update an existing school.");
        System.out.println("\t 9 - To remove a school.");
        System.out.println("\t 10 - To query if an existing school exists.");
        System.out.println("\t 11 - To print a list of available actions.");
    }

//    private static void addToDB() {
//        try {
//            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
//            Statement statement = conn.createStatement();
//
//            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
//            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS + " (" +
//                    COLUMN_NAME + " TEXT, " +
//                    COLUMN_PHONE + " INTEGER, " +
//                    COLUMN_EMAIL + " TEXT" +
//                    ")");
//
//            insertContact(statement,"Tino",321654987,"tinoromero@nearsoft.com");
//            insertContact(statement,"Juventino",321654987,"jtdurazo@nearsoft.com");
//            insertContact(statement,"Juve",123456789,"jromero@nearsoft.com");
//            insertContact(statement,"Jr D",789456123,"romerotino@nearsoft.com");
//            statement.execute("UPDATE contacts SET phone=1191310 WHERE name='Tino'");
//            statement.execute("DELETE FROM contacts WHERE name='Juve'");
//
//            ResultSet results = statement.executeQuery("SELECT * FROM contacts");
//
//            while(results.next()) {
//                System.out.println(results.getString(COLUMN_NAME) + " " +
//                        results.getInt(COLUMN_PHONE) + " " +
//                        results.getString(COLUMN_EMAIL));
//            }
//
//            results.close();
//
//            statement.close();
//            conn.close();
//        } catch (SQLException e) {
//            System.out.println("Error." + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//    private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {
//        statement.execute("INSERT INTO " + TABLE_CONTACTS + " (" +
//                COLUMN_NAME + ", " +
//                COLUMN_PHONE + ", " +
//                COLUMN_EMAIL + ") " +
//                "VALUES('" + name + "', " + phone + ", '" + email + "')");
//    }
}