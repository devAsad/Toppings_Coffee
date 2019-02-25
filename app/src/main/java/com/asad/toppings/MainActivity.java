package com.asad.toppings;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_Plus,btn_minus,btn_Order, btn_reset;
    TextView tv_1;
    CheckBox checkBox1, checkBox2;
    int coffee = 0;
    int total = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_minus = findViewById(R.id.btn_minus);
        btn_Order = findViewById(R.id.btn_order);
        btn_Plus = findViewById(R.id.btn_plus);
        btn_reset = findViewById(R.id.btn_reset);

        checkBox1 = findViewById(R.id.cb_cream);
        checkBox2 = findViewById(R.id.cb_choco);
        tv_1 = findViewById(R.id.tv_1);

        btn_Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coffee++;
                tv_1.setText(String.valueOf(coffee));

            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (coffee > 0) {
                    coffee--;
                    tv_1.setText(String.valueOf(coffee));
                }


            }
        });

        btn_Order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total = coffee * 10;
                if (checkBox1.isChecked() && coffee > 0) {
                    total += 5 * coffee;
                }
                if (checkBox2.isChecked() && coffee > 0) {
                    total += 5 * coffee;

                }
                if (coffee > 0) {
                    if (checkBox1.isChecked() && checkBox2.isChecked()) {
                        Toast.makeText(MainActivity.this, "You have selected " + String.valueOf(coffee)
                                        + "Coffee with Whipped Cream and Chocolate . Your Bill is " + String.valueOf(total),
                                Toast.LENGTH_SHORT).show();
                    } else if (checkBox1.isChecked()) {
                        Toast.makeText(MainActivity.this, "You have selected " + String.valueOf(coffee)
                                        + "Coffee with Whipped Cream . Your Bill is " + String.valueOf(total),
                                Toast.LENGTH_SHORT).show();
                    } else if (checkBox2.isChecked()) {

                        Toast.makeText(MainActivity.this, "You have selected " + String.valueOf(coffee) +
                                        "Coffee with Chocolate . Your Bill is " + String.valueOf(total)
                                , Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "You have selected " + String.valueOf(coffee)
                                + "Coffee without Toppings . Your Bill is " + String.valueOf(total), Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(MainActivity.this, "No Coffee Selected ... ", Toast.LENGTH_SHORT).show();

                }
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total = 0;
                coffee = 0;
                tv_1.setText(String.valueOf(coffee));
                checkBox1.setChecked(false);
                checkBox2.setChecked(false);

            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
