package com.example.swiftidea;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

// Test class for the 'IdeAdapter' class
// Mockito and JUnit are used for mocking and testing
public class IdeaAdapterTest {

    // Seven mock objects defined for seven views

    @Mock
    private Context context;
    @Mock
    private LayoutInflater inflater;
    @Mock
    private View convertView;
    @Mock
    private ViewGroup parent;
    @Mock
    private TextView textView;
    @Mock
    private Button openButton;
    @Mock
    private Button deleteButton;

    // Instance of 'IdeaAdapter' class being tested
    private IdeaAdapter adapter;
    // List of idea strings - for testing purposes
    private List<String> ideas;

    // Method for initializing the mock objects and setting up the test environment
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        // List of strings for ideas created
        ideas = Arrays.asList("Idea 1", "Idea 2", "Idea 3");
        // 'IdeaAdapter' instance initialized
        adapter = new IdeaAdapter(context, ideas);

        // Mock objects set up for objects
        when(context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).thenReturn(inflater);
        when(inflater.inflate(R.layout.list_item, parent, false)).thenReturn(convertView);
        when(convertView.findViewById(R.id.textView)).thenReturn(textView);
        when(convertView.findViewById(R.id.openButton)).thenReturn(openButton);
        when(convertView.findViewById(R.id.deleteButton)).thenReturn(deleteButton);
    }

    // Method for testing the 'getView' method of the 'IdeaAdapter' class
    @Test
    public void testGetView() {
        // 'getVIew' method called with a position of 0
        View result = adapter.getView(0, null, parent);
        // Verification that the returned view is the mock 'convertView' object
        assertEquals(convertView, result);
        // Verification that the 'textView' is set with the text "Idea 1"
        verify(textView).setText("Idea 1");
    }
}
