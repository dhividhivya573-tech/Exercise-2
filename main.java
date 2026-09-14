import java.util.Scanner;

class TelephoneBill {
    int customerNumber;
    String customerName;
    int previousMonth;
    int currentMonth;
    String connectionType;

    TelephoneBill(int customerNumber, String customerName,
                   int previousMonth, int currentMonth,
                   String connectionType) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.previousMonth = previousMonth;
        this.currentMonth = currentMonth;
        this.connectionType = connectionType;
    }

    void calculateBill() {
        double bill =0;

        if (connectionType.equalsIgnoreCase("prepaid")) {
            if (currentMonth <= 100) {
                bill = currentMonth * 1.0;
            } else if (currentMonth <= 200) {
                bill = (100 * 1.0) + ((currentMonth - 100) * 1.5);
            } else {
                bill = (100 * 1.0) + (100 * 1.5)
                        + ((currentMonth - 200) * 2.0);
            }
        } else if (connectionType.equalsIgnoreCase("postpaid")) {
            if (currentMonth <= 100) {
                bill = currentMonth * 0.75;
            } else if (currentMonth <= 200) {
                bill = (100 * 0.75) + ((currentMonth - 100) * 1.25);
            } else {
                bill = (100 * 0.75) + (100 * 1.25)
                        + ((currentMonth - 200) * 1.75);
            }
        } else {
            System.out.println("Invalid connection type");
            return;
        }

        System.out.println("\n----- TELEPHONE BILL -----");
        System.out.println("Customer Number : " + customerNumber);
        System.out.println("Customer Name   : " + customerName);
        System.out.println("Previous Month  : " + previousMonth + " minutes");
        System.out.println("Current Month   : " + currentMonth + " minutes");
        System.out.println("Connection Type : " + connectionType);
        System.out.println("Total Bill      : Rs. " + bill);
    }
}

public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer Number: ");
        int number = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Previous Month Call Duration: ");
        int previous = sc.nextInt();

        System.out.print("Enter Current Month Call Duration: ");
        int current = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Connection Type (Prepaid/Postpaid): ");
        String type = sc.nextLine();

        TelephoneBill obj = new TelephoneBill(
                number, name, previous, current, type);

        obj.calculateBill();

        sc.close();
    }
}