DAN's BARBEQUE POS
------------------
This point of sale system for a barbeque restaurant contains numerous text 
input fields which a server will enter after taking an order from a table.
The pos takes in the customer's name, and individual quantities depending on 
menu items ordered by the customer. Depending on the quantities entered, the
pos calculates the subtotal of the order. It then multiplies the subtotal by
the state sales tax of 6% to output the tax amount. It then adds these two 
amounts together to get the customer total. 
Upon completion of the calculation, the program also prints a receipt and a 
ticket for the back of house. The receipt contains an itemized list of items 
ordered with the ordered quantities and item totals. It then outputs all other
pricing information and gives the user the option to tip. The other ticket prin-
ted for the cooks only has the itemized orders with the time and customer name 
along with the order number. 
When writing this program I utilized JavaFx for the user interface. I took in all
user input through the use of text input fields. Because this data is automatically
string data, it had to be converted to integers to be useful in the classes that 
would record the order and perform calculations. The calculations for pricing would
generate a double result so they had to also be converted back to strings to be used
in the text fields for the user output. I also made use of classes by breaking this
program down into classes that could be used as a framework for the objects that I
used to record order information and generate tickets and receipts. By creating  
classes for MenuItems, Customers, LineItems, and Receipts I was able to create objec-
ts and reuse them every time another instance was needed. 
The final outputs were both written to .txt files (receipt.txt and ticket.txt), using
the FileWriter and PrintWriter as well as wrapping the process in a try catch statement
with the proper exception cases in case of something went wrong while trying to open, 
write, or close the file. Other topics covered in CIS 171 that were utitlized in this
program include array lists to store the line item objects and the use of lambda events
which were used for the buttons to trigger click events for this application.  
