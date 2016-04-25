package com.example.guest.willitrain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.searchCityButton)
    Button mSearchCityButton;
    @Bind(R.id.searchZipButton) Button mSearchZipButton;
    @Bind(R.id.searchCityText) TextView mSearchCityText;
    @Bind(R.id.searchZipText)
    TextView mSearchZipText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSearchCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = mSearchCityText.getText().toString();
                Intent cityIntent = new Intent(MainActivity.this, ForecastActivity.class);
                startActivity(cityIntent);
            }
        });
    }
}
