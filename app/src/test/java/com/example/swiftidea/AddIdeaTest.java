package com.example.swiftidea;

import static org.mockito.Mockito.*;

import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

// Test class for the 'AddIdeaActivity' class
// Mockito and JUnit are used for mocking and testing

@RunWith(MockitoJUnitRunner.class)
public class AddIdeaTest {

    // Four mock objects defined for four views

    @Mock
    private EditText editText;

    @Mock
    private Button buttonAdd;

    @Mock
    private AddIdeaActivity activity;

    @Mock
    private Editable editable;

    // 'View.OnClickListener' object created in 'setUp' method
    private View.OnClickListener buttonClickListener;

    // Method for initializing the mock objects and setting up the test environment
    @Before
    public void setUp() {
        // 'editText' and 'editable' objects are mocked
        when(editText.getText()).thenReturn(editable);
        // 'View.OnClickListener' object is created
        buttonClickListener = createOnClickListener();
    }

    // Method for testing if a valid idea was added
    @Test
    public void testAddValidIdea() {
        // Button click is simulated with a valid idea
        when(editable.toString()).thenReturn("New Idea");
        buttonClickListener.onClick(buttonAdd);

        // Verification that the result is set to 'RESULT_OK' and is finished
        verify(activity).setResult(eq(AddIdeaActivity.RESULT_OK), any(Intent.class));
        verify(activity).finish();
    }

    // Method for testing if an empty idea will be added
    @Test
    public void testAddEmptyIdea() {
        // Button click is simulated with an empty idea
        when(editable.toString()).thenReturn("");
        buttonClickListener.onClick(buttonAdd);

        // Verification that the result is not seen by the activity and the activity does not finish
        verify(activity, never()).setResult(anyInt(), any(Intent.class));
        verify(activity, never()).finish();
    }

    // Method for testing the 'onBackPressed' method
    @Test
    public void testOnBackPressed() {
        // The 'onBackPressed' method is called
        activity.onBackPressed();
        // Verification that the method is called
        verify(activity).onBackPressed();
    }

    // Method for creating a 'View.OnClickListener' object
    private View.OnClickListener createOnClickListener() {
        // A 'View.OnClickListener' object is returned
        return new View.OnClickListener() {
            // This object simulates the button click behavior
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
                    activity.setResult(AddIdeaActivity.RESULT_OK, resultIntent);
                    // Activity is finished
                    activity.finish();
                }
            }
        };
    }
}