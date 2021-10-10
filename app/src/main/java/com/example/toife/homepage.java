package com.example.toife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class homepage extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    TextView sc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        sc = (TextView) findViewById(R.id.selfcare);
        sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSCHome();
            }
        });
    }

    private void openSCHome() {

        Intent secahome =  new Intent(this, Selfcare_homepage.class);
        startActivity(secahome);

    }
    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popupenu_homepage);
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "Item 1 clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this, "Item 2 clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(this, "Item 3 clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }


}