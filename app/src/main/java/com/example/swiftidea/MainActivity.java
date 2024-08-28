package com.example.swiftidea;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

// This class is used as the main entry point of the application
// It is an extension of the 'AppCompatActivity' class
public class MainActivity extends AppCompatActivity {

    // Constant used as a request code to identify the result of the activity
    static final int REQUEST_CODE_ADD_IDEA = 1;
    // Object used to display the list of ideas in the ListView
    IdeaAdapter adapter;
    // Object used to store the list of ideas
    private List<String> items;

    // The method 'onCreate' is overridden to provide specific functionality
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // savedInstanceState - 'Bundle' object that contains the saved state of the activity
        // Superclass' 'onCreate' method called to perform default initialization
        super.onCreate(savedInstanceState);
        // Content view of the activity is set
        setContentView(R.layout.activity_main);

        // Views are found in the layout using their IDs

        // View for adding a new idea
        Button addIdeaButton = findViewById(R.id.addIdeaButton);
        // View for displaying the list of ideas
        ListView listView = findViewById(R.id.listView);

        // The 'items' list is initialized
        items = new ArrayList<>();

        // Temporary items are added to the list
        items.add("First Idea");
        items.add("Second Idea");
        items.add("Third Idea");

        // An instance of the 'IdeaAdapter' class is created
        // The current context and the 'items' are passed as parameters
        adapter = new IdeaAdapter(this, items);
        // The adapter is set to 'ListView'
        listView.setAdapter(adapter);

        // The onClickListener is set for the add idea button
        addIdeaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When 'add idea' button clicked:
                // 'Intent' object created to start the activity
                Intent intent = new Intent(MainActivity.this, AddIdeaActivity.class);
                // The activity is started passing the 'REQUEST_CODE_ADD_IDEA' as request code
                startActivityForResult(intent, REQUEST_CODE_ADD_IDEA);
            }
        });
    }

    // Method for handling the result of the activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /**
         * requestCode - 'int' value that represents the request code of the activity
         * resultCode - 'int' value that represents the result code of activity
         * data - 'Intent' object that contains the result data
         */

        // Superclass' method called to perform default initialization
        super.onActivityResult(requestCode, resultCode, data);

        // Check if the request code matches and the result code is RESULT_OK
        if (requestCode == REQUEST_CODE_ADD_IDEA && resultCode == RESULT_OK) {
            // If true, the new idea is retrieved from the intent data
            String newIdea = data.getStringExtra("NEW_IDEA");
            if (newIdea != null) {
                // The new idea is added to the 'items' list
                items.add(newIdea);
                // The adapter is notified to refresh the list
                adapter.notifyDataSetChanged();
            }
        }
    }
}
