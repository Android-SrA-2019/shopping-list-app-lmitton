package ca.nbcc.shoppinglist;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static  final String EXTRA_MESSAGE = "com.example.shopping-list-app-lmitton.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    private ShoppingList itemList = new ShoppingList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawView();
    }

    private void drawView(){
        Log.d(LOG_TAG, "View drawn  LLM");
        //to redraw the model
        //follow the model view controller pattern
        for (ShoppingList.ListItem item : itemList.getItems()) {
            Log.d(LOG_TAG, Integer.toString(item.getCount()) + " " + item.getName() + " LLM");
        }


    }

    public void launchSelectList(View view) {
        Intent intent = new Intent(this, SelectList.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SelectList.EXTRA_REPLY);
                itemList.addItem(reply);
                Log.d(LOG_TAG, reply + "Result returned  LLM");
            }
        }
    }
}
