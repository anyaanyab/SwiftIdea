package com.example.swiftidea;

import static org.mockito.Mockito.*;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

// Test class for the 'MainActivity' class
// Mockito and JUnit are used for mocking and testing
@RunWith(MockitoJUnitRunner.class)
public class MainActivityTest {

    // Three mock objects defined for two views and the class being tested

    @Mock
    private Button addIdeaButton;

    @Mock
    private MainActivity activity;

    @Mock
    private IdeaAdapter adapter;

    // List of strings - for testing purposes
    private List<String> items;

    // 'View.OnClickListener' object created in 'setUp' method
    private View.OnClickListener addIdeaButtonClickListener;

    // Method for initializing the mock objects and setting up the test environment
    @Before
    public void setUp() {
        // Empty list of items created
        items = new ArrayList<>();
        // 'View.OnClickListener' object created for 'add idea' button click listener
        addIdeaButtonClickListener = createAddIdeaButtonClickListener();
    }

    // Method for testing the 'add idea' button click event
    @Test
    public void testAddIdeaButtonClick() {
        // An 'add idea' button click is simulated
        addIdeaButtonClickListener.onClick(addIdeaButton);
        // Verification that a new intent is started with the request code
        verify(activity).startActivityForResult(any(Intent.class), eq(MainActivity.REQUEST_CODE_ADD_IDEA));
    }

    // Method for testing the 'onActivityResult' method with an invalid request code
    @Test
    public void testOnActivityResultWithInvalidRequestCode() {
        Intent mockIntent = mock(Intent.class);
        // The 'onActivityResult' method called with an invalid request code
        activity.onActivityResult(999, MainActivity.RESULT_OK, mockIntent);

        // Verification that the adapter's 'notifyDataSetChanged' method is not called
        verify(adapter, never()).notifyDataSetChanged();
        // Verification that a new item "New Test Idea" is not added to the list
        assert(!items.contains("New Test Idea"));
    }

    // Method for testing the 'onActivityResult' method with an invalid result code
    @Test
    public void testOnActivityResultWithInvalidResultCode() {
        Intent mockIntent = mock(Intent.class);
        // The 'onActivityResult' method called with an invalid result code
        activity.onActivityResult(MainActivity.REQUEST_CODE_ADD_IDEA, MainActivity.RESULT_CANCELED, mockIntent);

        // Verification that the adapter's 'notifyDataSetChanged' method is not called
        verify(adapter, never()).notifyDataSetChanged();
        // Verification that a new item "New Test Idea" is not added to the list
        assert(!items.contains("New Test Idea"));
    }

    // Method for creating a 'View.OnClickListener' object for the 'add idea' button click listener
    private View.OnClickListener createAddIdeaButtonClickListener() {
        // 'View.OnClickListener' object is returned
        return new View.OnClickListener() {
            // The returned object starts a new intent with a valid request code when clicked
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, AddIdeaActivity.class);
                activity.startActivityForResult(intent, MainActivity.REQUEST_CODE_ADD_IDEA);
            }
        };
    }
}