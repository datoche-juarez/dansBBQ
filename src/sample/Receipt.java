package sample;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// This class represents Invoice with all description
class Receipt {

    //Declare private variables:
    private Customer customer;

    //Store date and time:
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    //Array list of line items for order:
    ArrayList<LineItem> lineItem = new ArrayList<>();

    //Constructor:
    public Receipt(Customer customer) {
        this.customer = customer;
    }

    //Add line item to array list:
    public void add(MenuItem product, int quantity){

        LineItem item = new LineItem(quantity, product);

        lineItem.add(item);

    }

    //Calculate subtotal:
    public double getSubtotal(){

        double amount = 0;

        for(int i=0; i<lineItem.size(); i++){

            amount += lineItem.get(i).calcItemTotal();
        }

        return amount;
    }

    //Calculate tax on order:
    public double getTax() {
        double taxAmount = 0;
        double subtotal = 0;

        subtotal = getSubtotal();
        taxAmount = subtotal * 0.06;

        return taxAmount;
    }

    public double getCustomerTotal() {
        double taxAmount = 0;
        double subtotal = 0;
        double customerTotal = 0;

        taxAmount = getTax();
        subtotal = getSubtotal();
        customerTotal = taxAmount + subtotal;

        return customerTotal;

    }

    //Method that prints receipt to receipt.txt
    public void printReceipt() throws IOException {

        try {
            //Create files:
            File receiptFile = new File("receipt.txt");

            //Create file writers:
            FileWriter receiptWriter = new FileWriter(receiptFile);

            //Create print writers:
            PrintWriter rpw = new PrintWriter(receiptWriter);

            rpw.println("\n\t\tReceipt");

            //Restaurant address output:
            rpw.println("\n\tDan's Barbeque");
            rpw.println("\t8704 Michigan Ave.");
            rpw.println("\tDearborn, MI 48124");

            rpw.println("\n\t\tSALE");

            //Display customer information:
            rpw.println("\nCustomer: " + customer.getCustomerName() + "\n\n");

            // create an object of DecimalFormat class for printing price in format
            DecimalFormat df = new DecimalFormat("$ 0.00");

            // now print each product details using for loop
            for (int i = 0; i < lineItem.size(); i++) {

                //Display quantity:
                rpw.print("\t" + lineItem.get(i).getItemQuantity() + "\t");

                //Display name:
                rpw.print(lineItem.get(i).getItem().getItemName() + "\t\t");

                //Display item price
                rpw.print(df.format(lineItem.get(i).getItem().getItemPrice()) + "\t\t");

                //Display item total:
                rpw.print(df.format(lineItem.get(i).calcItemTotal()) + "\t");

                rpw.println();
            }

            // now print Total due Amount
            rpw.println("\nSub-total : " + df.format(getSubtotal()));

            //Print tax amount:
            rpw.println("\nSales Tax: " + df.format(getTax()));

            //Print customer total:
            rpw.println("\nTotal: " + df.format(getCustomerTotal()));

            //Print tip line:
            rpw.println("\nTip: _________");

            //Print total after tip line:
            rpw.println("\nTOTAL: _________");

            rpw.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    //This method prints to ticket.txt:
    public void printTicket() throws IOException {

        try {
            //Create files:
            File ticketFile = new File("ticket.txt");

            //Create file writers:
            FileWriter ticketWriter = new FileWriter(ticketFile);

            //Create print writers:
            PrintWriter tpw = new PrintWriter(ticketWriter);

            tpw.println("\n\t\tLine Ticket");

            //Add ticket number:
            tpw.println("\nTicket #: " + getTicketNumber());

            //Display date and time:
            tpw.println(formatter.format(date));

            //Display customer name:
            tpw.println("\nCustomer: " + customer.getCustomerName() + "\n\n");

            //Output each item and quantity:
            for (int i = 0; i < lineItem.size(); i++) {
                //Display item qty:
                tpw.print("\t" + lineItem.get(i).getItemQuantity() + "\t");

                //Display item name:
                tpw.print(lineItem.get(i).getItem().getItemName() + "\t\t");

                tpw.println();
            }

            tpw.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    //Increments ticket number:
    public int getTicketNumber () {
        int ticketNumber = 0;

        ticketNumber++;

        return ticketNumber;

    }

}