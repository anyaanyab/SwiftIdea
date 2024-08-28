package com.example.swiftidea;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// This class provides the functionality to view specifics of a created idea
// It is an extension of the AppCompatActivity class
public class EditIdeaActivity extends AppCompatActivity {

    // The method 'onCreate' is overridden to provide specific functionality
    // The activity is initialized and the UI is set up
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         * @param savedInstanceState is a 'Bundle' object containing the saved state of the activity
         */
        // The superclass' method is called to perform default initialization
        super.onCreate(savedInstanceState);
        // The content view of the activity is set
        setContentView(R.layout.activity_edit);
        // The data passed from 'MainActivity' is retrieved and stored in 'item' variable
        String item = getIntent().getStringExtra("ITEM");

        // The views are found in the layout using their IDs

        // View for navigating back to the previous page
        Button buttonBack = findViewById(R.id.buttonBack);
        // View for displaying the idea details
        TextView detailTextView = findViewById(R.id.detailTextView);
        // View for displaying the idea notes
        TextView editTextView = findViewById(R.id.editIdea);
        // View for navigating back to the previous page
        ImageView imageBack = findViewById(R.id.imageBack);

        // The data is set to the TextViews
        detailTextView.setText("Your Idea");
        editTextView.setText(item);

        // The event listener method is set for the back image view
        imageBack.setOnClickListener(new View.OnClickListener() {
            // When the back image view is clicked, the method is called to navigate back to the previous page
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // The event listener method is set for the back button view
        buttonBack.setOnClickListener(new View.OnClickListener() {
            // When the back button view is clicked, the method is called to navigate back to the previous page
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
