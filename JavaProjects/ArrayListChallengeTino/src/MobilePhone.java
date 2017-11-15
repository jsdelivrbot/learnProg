import java.util.ArrayList;

public class MobilePhone {
    public String myNumber;
    public ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact newContact) {
        if(findContact(newContact)<0) {
            myContacts.add(newContact);
            return true;
        }

        return false;
    }

    public boolean removeContact(String name) {
        int position = findContact(name);
        if(position >= 0) {
            myContacts.remove(position);
            return true;
        }

        return false;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        if(position>=0) {
            myContacts.set(position, newContact);
            return true;
        } else {
            return false;
        }
    }

    public Contact queryContact(String name) {
        int position = findContact(name);

        return myContacts.get(position);
    }

    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    public int findContact(String contactName) {
        for(int i=0; i<myContacts.size(); i++) {
            if(this.myContacts.get(i).getName().equals(contactName)) {
                return i;
            }
        }

        return -1;
    }

    public boolean printContactList() {
        if(myContacts.size()>0) {
            for(int i=0; i<myContacts.size(); i++) {
                Contact contact = myContacts.get(i);
                System.out.println((i+1) + ". " + contact.getName() + " -> " + contact.getNumber());
            }
            return true;
        } else {
            return false;
        }
    }

}
