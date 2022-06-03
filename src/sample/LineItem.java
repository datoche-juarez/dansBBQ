package sample;

class LineItem{

    //Declare private variables:
    private int itemQuantity;
    private MenuItem item;

    //Constructor:
    public LineItem(int itemQuantity, MenuItem item) {
        this.itemQuantity = itemQuantity;
        this.item = item;
    }

    //Gets and sets:
    public int getItemQuantity() { return itemQuantity; }
    public MenuItem getItem() { return item; }

    //Calculate cost of line item:
    public double calcItemTotal(){

        return (this.itemQuantity * item.getItemPrice());
    }

}