package Challenge1;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contacts> myContacts ;
        public MobilePhone(String myNumber){
            this.myNumber = myNumber;
            this.myContacts = new ArrayList<Contacts>();
        }
        public boolean addNewContact(Contacts contacts){
            if(findContact(contacts.getName()) >=0){
                System.out.println("Contact is already on file");
                return false;
            }
            myContacts.add(contacts);
            return true;
        }
        private int findContact(String ContactName){
            for(int i=0;i<=this.myContacts.size();i++){
                Contacts contacts = this.myContacts.get(i);
                if(contacts.getName().equals(ContactName)){
                    return i;
                }
            }
            return -1;
        }
        private int findContact(Contacts contacts){
            return this.myContacts.indexOf(contacts);
        }
        public boolean updateContact(Contacts oldContact, Contacts newContact){
            int findPosition = findContact(oldContact);
            if(findPosition <0){
                System.out.println(oldContact.getName() + " was not found" );
                return false;
            }
            this.myContacts.set(findPosition , newContact);
            System.out.println(oldContact.getName() + "was replaced by the element " + newContact.getName());
            return true;
        }
        public String queryContact(Contacts contacts){
            if(findContact(contacts) >= 0){
                return contacts.getName();
            }
            return null;
        }
        public boolean removeContact(Contacts contacts){
            int findPosition = findContact(contacts);
            if(findPosition < 0){
                System.out.print(contacts.getName() + " was not found");
                return false;
            }
            this.myContacts.remove(findPosition);
            System.out.print(contacts.getName() + " was deleted");
            return true;
        }
        public void printContacts(){
            System.out.println("Contact list");
            for(int i=0; i<this.myContacts.size(); i++){
                System.out.println((i+1) + ":"  +  this.myContacts.get(i).getName() + " -> "
                                                + this.myContacts.get(i).getPhoneNumber());

            }
        }
        public Contacts queryContact(String name){
            int position = findContact(name);
            if(position >= 0 ){
                return this.myContacts.get(position);
            }
            return null;
        }

}
