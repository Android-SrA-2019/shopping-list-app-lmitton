package ca.nbcc.shoppinglist;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final int REQUEST_CODE = 1;
    private ShoppingList item;
    private ArrayList<ShoppingList> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            itemList = new ArrayList();
        } else {
            itemList = savedInstanceState.getParcelableArrayList("items");
            Log.d(LOG_TAG, "itemList LLM " + itemList.size());
            drawView();
        }
    }

    private void drawView() {
        ArrayList<TextView> textListItems = new ArrayList();
        Log.d(LOG_TAG, "View drawn  LLM");
        //to redraw the model
        //follow the model view controller pattern
        LinearLayout parentLayout = (LinearLayout) findViewById(R.id.textView_holder);
        if (parentLayout.getChildCount() > 0){
            parentLayout.removeAllViews();
        }
        LayoutInflater layoutInflater = getLayoutInflater();
        View view;

        for (ShoppingList item : itemList) {
            Log.d(LOG_TAG, item.toString() + " draw view item LLM");
            view = layoutInflater.inflate(R.layout.text_layout, parentLayout, false);
            TextView textView = (TextView) view.findViewById(R.id.text);
            textView.setText(item.toString());
            parentLayout.addView(textView);
        }
    }

    public void launchSelectList(View view) {
        Intent intent = new Intent(this, SelectList.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    private void addOne(String itemName) {

        boolean itemFound = false;
        for (ShoppingList item : itemList) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                int newCount = item.getCount() + 1;
                item.setCount(newCount);
                Log.d(LOG_TAG, item.toString() + " increased count LLM");
                itemFound = true;
            }
        }
        if (!itemFound) {
            ShoppingList item = new ShoppingList(1, itemName);
            itemList.add(item);
            Log.d(LOG_TAG, item.toString() + " added new item LLM");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Log.d(LOG_TAG, "Back button pressed no result returned  LLM");
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                item = (ShoppingList) data.getParcelableExtra("item");
                addOne(item.getName());
                Log.d(LOG_TAG, item.getName() + " Result returned  LLM");

            }
        } else {
            Log.d(LOG_TAG, "Back button pressed no result returned  LLM");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList("items", itemList);
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume LLM");
        drawView();
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.d(LOG_TAG, "onStart LLM");
//        drawView();
//    }
}
