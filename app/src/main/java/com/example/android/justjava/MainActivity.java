//package com.example.android.justjava;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}
package com.example.android.justjava;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    String name;
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //String priceMessage = "Total: $" + calculatePrice(quantity) + "\nThank you!";
        displayMessage(createOrderSummery(calculatePrice(quantity)));
        //displayPrice(quantity * 5);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    public void increment(View view){
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view){
        if (quantity > 0) {
            quantity = quantity - 1;
        }
        display(quantity);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    private int calculatePrice(int quantity){
        return quantity*5;
    }

    private String createOrderSummery(int price){
        CheckBox whippedCream = findViewById(R.id.whipped_cream_checkbox);
        CheckBox chocolate = findViewById(R.id.chocolate_checkbox);
        EditText nameInput = findViewById(R.id.name_edit_text);
        name = nameInput.getText().toString();
        String message = "Name: " + name + "\nAdd whipped cream? ";
        if (whippedCream.isChecked()){
            message += "true";
        } else {
            message += "false";
        }
        message += "\nAdd chocolate? ";
        if (chocolate.isChecked()){
            message += "true";
        } else {
            message += "false";
        }
        message += "\nQuantity: " + quantity +"\nTotal: $" + price + "\nThank you!";
        return message;
    }
}