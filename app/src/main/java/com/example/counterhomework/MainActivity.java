package com.example.counterhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button btnCount;
    private TextView editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize all the view variables.
        mShowCount = (TextView) findViewById(R.id.txtCount);
        btnCount = (Button) findViewById(R.id.btnCount);
        editText = (TextView) findViewById(R.id.editText);

        // Restore the state.
        if (savedInstanceState != null) {
            int count = savedInstanceState.getInt("mCount_value");
            mCount = count;
            mShowCount.setText(Integer.toString(count));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mCount > 0) {
            outState.putInt("mCount_value", mCount);
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