package ca.nbcc.shoppinglist;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SelectList extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_list);

    }

    @Override
    public void onBackPressed() {
        Intent backReply = new Intent(getApplicationContext(), MainActivity.class);
        setResult(RESULT_CANCELED, backReply);
        super.onBackPressed();
    }

    public void processButton(View view) {
        Button buttonToProcess = (Button)view;
        Log.d(LOG_TAG, buttonToProcess.getText().toString() + " Button clicked!");
        String reply = buttonToProcess.getText().toString();

        ShoppingList item = new ShoppingList(1, reply);

        Intent replyIntent = new Intent(getApplicationContext(), MainActivity.class);
        replyIntent.putExtra("item", item);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}
