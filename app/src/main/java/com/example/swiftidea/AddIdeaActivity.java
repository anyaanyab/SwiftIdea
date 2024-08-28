package com.example.swiftidea;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

// Create a class for adding ideas, as an extension of the AppCompatActivity class
public class AddIdeaActivity extends AppCompatActivity {

    // The method onCreate is overridden to provide specific to the app functionality
    // Initialization of the activity takes places and sets up the UI
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         * @param savedInstanceState is a 'Bundle' object containing the saved state of the activity
         */
        // The superclass' method is called to perform default initialization
        super.onCreate(savedInstanceState);
        /* The content view of the activity is set */
        setContentView(R.layout.activity_add);

        // Views are found in the layout using their IDs

        // View for adding a new idea
        Button buttonAdd = findViewById(R.id.buttonAddIdea);
        // View for entering text
        EditText editText = findViewById(R.id.editTextIdea);
        // View for navigating back to the previous page
        ImageView imageBack = findViewById(R.id.imageBack);

        // This event listener method is set for the back image view
        imageBack.setOnClickListener(new View.OnClickListener() {
            // When the back image view is clicked, method called to navigate back to the previous page
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // This event listener method is set for the 'add' button view
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * When the button is clicked:
             * The text is retrieved from the 'EditText' view, any whitespace is trimmed, stored in 'newIdea' variable
             * The variable 'newIdea' is checked to not be empty
             * If not empty, new 'Intent' object created and the string from the variable is stored with the key "NEW_IDEA"
             */
            public void onClick(View v) {
                String newIdea = editText.getText().toString().trim();
                if (!newIdea.isEmpty()) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("NEW_IDEA", newIdea);
                    // Result of the activity is set to 'RESULT_OK'
                    setResult(RESULT_OK, resultIntent);
                    // Activity is finished
                    finish();
                }
            }
        });

    }
}
