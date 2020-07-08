package Challenge1;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("9650276913");
    public static void main (String[] args){
        boolean quit = false;
        startMobilePhone();
        printActions();
        while(!quit){
            System.out.print("Enter the action to perform:");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0 : System.out.println("Shutting down Mobile Phone ....");
                         quit = true;
                         break;
                case 1 : mobilePhone.printContacts();
                         break;
                case 2 : addNewContact();
                         break;
                case 3 : updateNewContact();
                         break;
                case 4 : removeContact();
                         break;
                case 5 : queryContact();
                         break;
                case 6 : printActions();
                         break;
            }
        }
    }
    private static void addNewContact() {
        System.out.print("Enter the new Contact name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the Phone number: ");
        String phoneNumber = scanner.nextLine();
        Contacts newContact =  Contacts.createContact(name , phoneNumber);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println("New Contact added : name= " + name + "phone number =" + phoneNumber);
        }else{
            System.out.println("Cannot add the contact name:" + name + "because it is already on file");
        }

    }
    public static void startMobilePhone(){
        System.out.println("Starting Mobile Phone ....");
    }
    public static void printActions(){
        System.out.print("\n Available Actions. \n Press:");
        System.out.println( "0  -  to shutdown \n"  +
                            "1  -  to print contacts \n" +
                            "2  -  to a new contact \n" +
                            "3  -  to update an existing contact \n" +
                            "4  -  to remove an existing contact \n" +
                            "5  - query an existing contact exists \n" +
                            "6  - to print a list of available actions.");
        System.out.print("Choose your actions: ");
    }
    public static void updateNewContact() {
        System.out.print("Enter the existing contact :");
        String name = scanner.nextLine();
        Contacts ifRecordExisting = mobilePhone.queryContact(name);
        if (ifRecordExisting == null) {
            System.out.print("Record not found ");
            return;
        }
        System.out.print("Enter the contact name ");
        String newName = scanner.nextLine();
        System.out.print("Enter the phone number ");
        String newPhoneNumber = scanner.nextLine();
        Contacts newContact = Contacts.createContact(newName, newPhoneNumber);
        if (mobilePhone.updateContact(ifRecordExisting, newContact)) {
            System.out.println(" Record Successfully updated ...");
        } else {
            System.out.println("Error updating contact ....");
        }
    }
        public static void removeContact(){
            System.out.println("Enter the existing contact ");
            String name = scanner.nextLine();
            Contacts ifRecordExisting = mobilePhone.queryContact(name);
            if(ifRecordExisting == null){
                System.out.println("Record not found ");
                return;
            }
            if(mobilePhone.removeContact(ifRecordExisting)){
                System.out.println("Record Successfully deleted ...");
            }else{
                System.out.println("Error deleting record");
            }
    }
    public static void queryContact(){
        System.out.println("Enter the existing contact: ");
        String name = scanner.nextLine();
        Contacts ifRecordExisting = mobilePhone.queryContact(name);
        if(ifRecordExisting == null ){
            System.out.println("Record not found ");
            return ;
        }
        System.out.println("Name: " + ifRecordExisting.getName() + "phoneNumber: " + ifRecordExisting.getPhoneNumber());
    }
}
