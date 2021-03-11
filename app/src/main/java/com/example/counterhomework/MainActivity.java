package com.example.counterhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize all the view variables.
        mShowCount = (TextView) findViewById(R.id.txtCount);

        // Restore the state.
        if (savedInstanceState != null) {
            boolean isVisible =
                    savedInstanceState.getBoolean("reply_visible");
            if (isVisible) {
                mShowCount.setVisibility(View.VISIBLE);
                mShowCount.setText(savedInstanceState.getString("reply_text"));
                mShowCount.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mShowCount.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text",mShowCount.getText().toString());
        }
    }

    /**
     * Metodo que incrementa el contador en 1
     * @param view la view que se actualiza
     */
    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
}