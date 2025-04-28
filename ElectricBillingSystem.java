import java.util.Scanner;
class Person {
    String name, address;
 Person(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
class Customer extends Person {
    int id;
    String meterNumber;
    double units;
Customer(int id, String name, String address, String meterNumber, double units) {
        super(name, address);
        this.id = id;
        this.meterNumber = meterNumber;
        this.units = units;
    }
}
public class ElectricBillingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Customer[] customers = new Customer[10];
        int customerCount = 0;
       while (true) {
            System.out.println("\nElectric Billing System");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customer Records");
            System.out.println("3. Generate Bill");
           System.out.println("4.Update Customer Details");
           System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
           switch (choice) {
                case 1:
                    if (customerCount < customers.length) {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Address: ");
                        String address = sc.nextLine();
                        System.out.print("Enter Meter Number: ");
                        String meter = sc.nextLine();
                        System.out.print("Enter Units: ");
                        double units = sc.nextDouble();
                      customers[customerCount++] = new Customer(id, name, address, meter, units);
                        System.out.println("Customer added.");
                    } else {
                        System.out.println("Customer list full.");
                    }
                    break;
                case 2:
                    for (int i = 0; i < customerCount; i++) {
                        Customer c = customers[i];
                        System.out.println("ID: " + c.id + ", Name: " + c.name + ", Address: " + c.address + ", Meter: " + c.meterNumber + ", Units: " + c.units);
                    }
                    break;
                 case 3:
                    System.out.print("Enter ID to generate bill: ");
                    int bid = sc.nextInt();
                    boolean found = false;
                    for (int i = 0; i < customerCount; i++) {
                        if (customers[i].id == bid) {
                            found = true;
                            double amount = customers[i].units * 5;
                            System.out.println("Bill for " + customers[i].name);
                            System.out.println("Units: " + customers[i].units);
                            System.out.println("Amount: ₹" + amount);
                        }
                    }
                    if (!found) 
		System.out.println("Customer not found.");
                    break;
            case 4:
             System.out.print("Enter ID to update: ");
           int uid = sc.nextInt();
          sc.nextLine(); 
          boolean updated = false;
         for (int i = 0; i < customerCount; i++) {
        if (customers[i].id == uid) {
            System.out.print("Enter new Name: ");
            customers[i].name = sc.nextLine();
            System.out.print("Enter new Address: ");
            customers[i].address = sc.nextLine();
            System.out.print("Enter new Meter Number: ");
            customers[i].meterNumber = sc.nextLine();
            System.out.print("Enter new Units: ");
            customers[i].units = sc.nextDouble();
            
            updated = true;
            System.out.println("Customer details updated.");
            break; 
        }
    }
   if(!updated)
               {
                System.out.println("Customer not found.");
                  }
               break;
       case 5:
          System.out.println("Exiting...");
            sc.close();
            return;
           default:
            System.out.println("Invalid choice.");
            }
        }
    }
}
