/**
 * Dan's BBQ POS/Ticket system:
 * The following program is a point of sale system
 * that prints both customer receipts and line tick-
 * ets based on the server's input. The server enters
 * the desired quantity in the corresponding text in-
 * put box and uses the calculate and print buttons
 * to calculate pricing information and output the
 * receipt for the customer and the ticket for the
 * cooks on the line.
 */

package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.FileInputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Dan's BBQ");
        primaryStage.setScene(new Scene(root, 700, 550));

        //Create border pane as frame for all layout:
        BorderPane border = new BorderPane();

        //Create HBox for top of border pane:
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        Button buttonCurrent = new Button("Current");
        buttonCurrent.setPrefSize(100, 20);

        Button buttonProjected = new Button("Projected");
        buttonProjected.setPrefSize(100, 20);
        hbox.getChildren().addAll(buttonCurrent, buttonProjected);

        //Text fields and labels for left pane:
        TextField fldCustomerName = new TextField();
        TextField fldOrderNumber = new TextField();
        TextField fldSteakQty = new TextField();
        TextField fldChickenQty = new TextField();
        TextField fldRibsQty = new TextField();
        TextField fldBrisketQty = new TextField();
        TextField fldPulledPorkQty = new TextField();
        TextField fldCokeQty = new TextField();
        TextField fldSpriteQty = new TextField();
        TextField fldRootBeerQty = new TextField();
        TextField fldLemonadeQty = new TextField();

        fldSteakQty.setText("0");
        fldChickenQty.setText("0");
        fldRibsQty.setText("0");
        fldBrisketQty.setText("0");
        fldPulledPorkQty.setText("0");
        fldCokeQty.setText("0");
        fldSpriteQty.setText("0");
        fldRootBeerQty.setText("0");
        fldLemonadeQty.setText("0");

        Label lblCustomerName = new Label("Customer name: ");
        Label lblOrderNumber = new Label("Order number: ");
        Label lblSteakQty = new Label("Steak 25.99");
        Label lblChickenQty = new Label("Whole Chicken 22.95");
        Label lblRibsQty = new Label("Ribs 18.99");
        Label lblBrisketQty = new Label("Brisket 15.99");
        Label lblPulledPorkQty = new Label("Pulled Pork 15.99");
        Label lblCokeQty = new Label("Coke 2.50");
        Label lblSpriteQty = new Label("Sprite 2.50");
        Label lblRootBeerQty = new Label("Root Beer 2.50");
        Label lblLemonadeQty = new Label("Lemonade 2.50");

        //Bind labels to text fields:
        lblCustomerName.setLabelFor(fldCustomerName);
        lblOrderNumber.setLabelFor(fldOrderNumber);
        lblSteakQty.setLabelFor(fldSteakQty);
        lblChickenQty.setLabelFor(fldChickenQty);
        lblRibsQty.setLabelFor(fldRibsQty);
        lblBrisketQty.setLabelFor(fldBrisketQty);
        lblPulledPorkQty.setLabelFor(fldPulledPorkQty);
        lblCokeQty.setLabelFor(fldCokeQty);
        lblSpriteQty.setLabelFor(fldSpriteQty);
        lblRootBeerQty.setLabelFor(fldRootBeerQty);
        lblLemonadeQty.setLabelFor(fldLemonadeQty);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(5);

        gridPane.addRow(0, lblCustomerName, fldCustomerName);
        gridPane.addRow(1, lblOrderNumber, fldOrderNumber);
        gridPane.addRow(2, lblSteakQty, fldSteakQty);
        gridPane.addRow(3, lblChickenQty, fldChickenQty);
        gridPane.addRow(4, lblRibsQty, fldRibsQty);
        gridPane.addRow(5, lblBrisketQty, fldBrisketQty);
        gridPane.addRow(6, lblPulledPorkQty, fldPulledPorkQty);
        gridPane.addRow(7, lblCokeQty, fldCokeQty);
        gridPane.addRow(8, lblSpriteQty, fldSpriteQty);
        gridPane.addRow(9, lblRootBeerQty, fldRootBeerQty);
        gridPane.addRow(10, lblLemonadeQty, fldLemonadeQty);

        border.setLeft(gridPane);

        //Add ribs image:
        Image ribs = new Image(new FileInputStream("src/ribs.png"));
        ImageView ribsImageView = new ImageView(ribs);
        ribsImageView.setFitWidth(200);
        ribsImageView.setFitHeight(200);
        ribsImageView.setPreserveRatio(false);

        //Text and label fields for right side of grid pane:
        TextField fldDate = new TextField();
        TextField fldTime = new TextField();
        TextField fldSubtotal = new TextField();
        TextField fldSalesTax = new TextField();
        TextField fldCustomerTotal = new TextField();

        Label lblDate = new Label("Date: ");
        Label lblTime = new Label("Time: ");
        Label lblSubtotal = new Label("Subtotal: ");
        Label lblSalesTax = new Label("Sales Tax: ");
        Label lblCustomerTotal = new Label("Customer total: ");

        //Bind text fields to labels:
        lblDate.setLabelFor(fldDate);
        lblTime.setLabelFor(fldTime);
        lblSubtotal.setLabelFor(fldSubtotal);
        lblCustomerTotal.setLabelFor(fldCustomerTotal);
        lblSalesTax.setLabelFor(fldSalesTax);

        GridPane rightGridPane = new GridPane();
        rightGridPane.setPadding(new Insets(10, 10, 10, 70));
        rightGridPane.setVgap(8);
        rightGridPane.setHgap(5);
        rightGridPane.setPrefWidth(400);


        rightGridPane.addRow(0, lblDate, fldDate);
        rightGridPane.addRow(1, lblTime, fldTime);
        rightGridPane.addRow(2, ribsImageView);
        rightGridPane.addRow(3, lblSubtotal, fldSubtotal);
        rightGridPane.addRow(4, lblSalesTax, fldSalesTax);
        rightGridPane.addRow(5, lblCustomerTotal, fldCustomerTotal);

        border.setRight(rightGridPane);

        //Buttons to go on bottom of grid pane:
        Button btnCalculate = new Button("Cash out");
        btnCalculate.setPrefSize(80,25);

        //Store data from text fields in variables and sent to class for calculations:
        btnCalculate.setOnAction(e -> {

            String customerName = fldCustomerName.getText();

            //Creating Customer object:
            Customer customer = new Customer(customerName);

            //Creating Receipt object w/ Customer:
            Receipt invoice = new Receipt(customer);


            Integer steakQty = Integer.valueOf(fldSteakQty.getText());
            Integer chickenQty = Integer.valueOf(fldChickenQty.getText());
            Integer ribsQty = Integer.valueOf(fldRibsQty.getText());
            Integer brisketQty = Integer.valueOf(fldBrisketQty.getText());
            Integer pulledPorkQty = Integer.valueOf(fldPulledPorkQty.getText());
            Integer cokeQty = Integer.valueOf(fldCokeQty.getText());
            Integer spriteQty = Integer.valueOf(fldSpriteQty.getText());
            Integer rootBeerQty = Integer.valueOf(fldRootBeerQty.getText());
            Integer lemonadeQty = Integer.valueOf(fldLemonadeQty.getText());

            //Add menu items to Receipt object:
            for (int i = 1; i <= 9; i++) {

                //Menu item description:
                String productDescription = null;
                double productPrice = 0;
                int productQuantity = 0;

                switch (i) {
                    case 1:
                        productDescription = "Steak";
                        productPrice = 28.99;
                        productQuantity = steakQty;
                        break;
                    case 2:
                        productDescription = "Chicken";
                        productPrice = 22.99;
                        productQuantity = chickenQty;
                        break;
                    case 3:
                        productDescription = "Ribs";
                        productPrice = 18.99;
                        productQuantity = ribsQty;
                        break;
                    case 4:
                        productDescription = "Brisket";
                        productPrice = 15.99;
                        productQuantity = brisketQty;
                        break;
                    case 5:
                        productDescription = "Pulled Pork";
                        productPrice = 15.99;
                        productQuantity = pulledPorkQty;
                        break;
                    case 6:
                        productDescription = "Coke";
                        productPrice = 2.50;
                        productQuantity = cokeQty;
                        break;
                    case 7:
                        productDescription = "Sprite";
                        productPrice = 2.50;
                        productQuantity = spriteQty;
                        break;
                    case 8:
                        productDescription = "Root Beer";
                        productPrice = 2.50;
                        productQuantity = rootBeerQty;
                        break;
                    case 9:
                        productDescription = "Lemonade";
                        productPrice = 2.50;
                        productQuantity = lemonadeQty;
                        break;
                }

                //Create a MenuItem object
                MenuItem menuItem = new MenuItem(productDescription, productPrice);

                //Create a lineItem object:
                LineItem lineItem = new LineItem(productQuantity, menuItem);

                invoice.add(menuItem, productQuantity);

            }
                //Print subtotal, tax, and total before tip:
                DecimalFormat df = new DecimalFormat("$ 0.00");

                String subtotalAmt = df.format(invoice.getSubtotal());
                String strSubtotal = String.valueOf(subtotalAmt);
                fldSubtotal.setText(strSubtotal.toString());

                String taxAmt = df.format(invoice.getTax());
                String strTax = String.valueOf(taxAmt);
                fldSalesTax.setText(strTax.toString());

                String customerTotal = df.format(invoice.getCustomerTotal());
                String strCustomerTotal = String.valueOf(customerTotal);
                fldCustomerTotal.setText(strCustomerTotal.toString());

                //Output date and time of order being processed:
                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yy");
                String strDate = dateFormat.format(date);

                Date time = new Date();
                SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
                String strTime = timeFormat.format(time);

                fldDate.setText(strDate.toString());
                fldTime.setText(strTime.toString());

                //Output order number:
                int intOrderNumber = invoice.getTicketNumber();
                fldOrderNumber.setText(String.valueOf(intOrderNumber));

                //Print the receipt and the ticket:
            try {
                invoice.printReceipt();
            }
            catch (IOException exception)
            {
                exception.printStackTrace();
            }

            try {
                invoice.printTicket();
            }
            catch (IOException exception)
            {
                exception.printStackTrace();
            }
        });

        Button btnExit = new Button("Exit");
        btnExit.setPrefSize(80, 25);

        //Exits program when clicked:
        btnExit.setOnAction(e -> {
            System.out.println("Good bye!");
            Platform.exit();
        });

        HBox buttonsHbox = new HBox();
        buttonsHbox.setSpacing(30);
        buttonsHbox.setPadding(new Insets(10, 10, 10, 270));
        buttonsHbox.getChildren().add(btnCalculate);
        buttonsHbox.getChildren().add(btnExit);

        border.setBottom(buttonsHbox);

        Scene sceneOne = new Scene(border);
        primaryStage.setScene(sceneOne);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
