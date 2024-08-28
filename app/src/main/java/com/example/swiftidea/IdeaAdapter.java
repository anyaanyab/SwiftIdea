package com.example.swiftidea;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

// This class is used to display the list of the existing ideas in a 'ListView'
// It is an extension of the class 'ArrayAdapter<String>'
public class IdeaAdapter extends ArrayAdapter<String> {
    // Initialization of the adapter with the application context and list of ideas takes place
    private final Context context;
    private final List<String> values;
    /**
     * @param context is a 'Context' object that represents the application context
     * @param values is a 'List<String>' object that contains the list of ideas to be displayed
     */

    public IdeaAdapter(Context context, List<String> values) {
        // The superclass' constructor is called to perform the default initialization
        super(context, R.layout.list_item, values);
        // 'context' and 'values' fields are initialized with provided parameters
        this.context = context;
        this.values = values;
    }

    // The method 'getView' is overridden to provide specific functionality
    // It returns a view for the item at a certain position in the list
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        /**
         * position - 'int' value that represents the position of the item in the list
         * convertView - 'View' object that represents the view to be reused
         * parent - 'ViewGroup' object that represents the parent view
         */
        // The layout is inflated using the 'LayoutInflater' service
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);

        // Views are found in the layout using their IDs

        // View for deleting an idea
        Button deleteButton = rowView.findViewById(R.id.deleteButton);
        // View for opening (viewing) an idea
        Button openButton = rowView.findViewById(R.id.openButton);
        // View for displaying the idea content
        TextView textView = rowView.findViewById(R.id.textView);

        // The text of the TextView is set to the value at a certain position in values list
        textView.setText(values.get(position));

        // onClickListener is set for the delete button
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When button is clicked:
                // Toast message displayed as an indicator for deleting the item
                Toast.makeText(context, "The following item has been deleted: " + values.get(position), Toast.LENGTH_SHORT).show();
                // The item is removed from the values list at a certain position
                values.remove(position);
                // Adapter is notified to refresh the list
                notifyDataSetChanged();
            }
        });

        // onClickListener is set for the open button
        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When button is clicked:
                // Intent object created to start the EditIdea activity
                Intent intent = new Intent(context, EditIdeaActivity.class);
                // The item data is passed with the key ITEM
                intent.putExtra("ITEM", values.get(position));
                // Activity started using 'startActivity' method
                context.startActivity(intent);
            }
        });

        // The inflated view is returned
        return rowView;
    }
}
