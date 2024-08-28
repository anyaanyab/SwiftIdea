package com.example.swiftidea;

import static org.mockito.Mockito.*;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

// Test class for the 'EditIdeaActivity' class
// Mockito and JUnit are used for mocking and testing
@RunWith(MockitoJUnitRunner.class)
public class EditIdeaTest {

    // Three mock objects defined for three views

    @Mock
    private EditIdeaActivity activity;

    @Mock
    private ImageView imageBack;

    @Mock
    private Button buttonBack;

    // Two 'View.OnClickListener' objects created in the 'setUp' method
    private View.OnClickListener imageBackClickListener;
    private View.OnClickListener buttonBackClickListener;

    // Method for initializing the mock objects and setting up the test environment
    @Before
    public void setUp() {
        // Two 'View.OnCLickListener' objects are created for 'image back' and 'button back' click listeners
        imageBackClickListener = createImageBackClickListener();
        buttonBackClickListener = createButtonBackClickListener();
    }

    // Method for testing the 'image back' click event
    @Test
    public void testImageBackClick() {
        // An 'image back' click is simulated
        imageBackClickListener.onClick(imageBack);
        // Verification that 'onBackPressed' is called
        verify(activity).onBackPressed();
    }

    // Method for testing the 'button back' click event
    @Test
    public void testButtonBackClick() {
        // A 'button back' click is simulated
        buttonBackClickListener.onClick(buttonBack);
        // Verification that 'onBackPressed' is called
        verify(activity).onBackPressed();
    }

    // Method for creating a 'View.OnClickListener' object for 'image back' click listener
    private View.OnClickListener createImageBackClickListener() {
        // 'View.OnClickListener' object is returned
        return new View.OnClickListener() {
            // The returned object calls 'onBackPressed' when clicked
            @Override
            public void onClick(View v) {
                activity.onBackPressed();
            }
        };
    }

    // Method for creating a 'View.OnClickListener' object for 'button back' click listener
    private View.OnClickListener createButtonBackClickListener() {
        // 'View.OnClickListener' object is returned
        return new View.OnClickListener() {
            // The returned object calls 'onBackPressed' when clicked
            @Override
            public void onClick(View v) {
                activity.onBackPressed();
            }
        };
    }
}
