package com.example.ad37_nguyenmanhhung_buoi04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class ContactDetail extends AppCompatActivity {
    ImageView imgCall;
    TextView tvNumber, tvNumberCall, tvCountry, tvTimeDate;
    ImageButton imgButtonBack, imgButtonMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);
        imgCall = findViewById(R.id.imgCall);
        tvNumber = findViewById(R.id.tvNumber);
        tvNumberCall = findViewById(R.id.tvNumberCall);
        tvCountry = findViewById(R.id.tvCountry2);
        tvTimeDate = findViewById(R.id.tvTimeDate);
        imgButtonBack = findViewById(R.id.imgBtnBack);
        imgButtonMore = findViewById(R.id.imgBtnMore);

        Intent intent = getIntent();
        int call = intent.getIntExtra("0", 1);
        String number = intent.getStringExtra("1");
        String country = intent.getStringExtra("2");
        String date = intent.getStringExtra("3");

        switch (call) {
            case 1:
                imgCall.setImageResource(R.drawable.ic_incoming_call);
                break;
            case 2:
                imgCall.setImageResource(R.drawable.ic_outgoing_call);
                break;
            case 3:
                imgCall.setImageResource(R.drawable.ic_missed_call);
                tvTimeDate.setTextColor(Color.RED);
                break;
        }

        tvNumber.setText(number);
        tvNumberCall.setText(number);
        tvCountry.setText(country);
        tvTimeDate.setText(date);

        imgButtonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getBaseContext(), view);
                popupMenu.getMenuInflater().inflate(R.menu.contact_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.mnSetting:
                                Toast.makeText(ContactDetail.this, "Cài đặt", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.mnRecord:
                                Toast.makeText(ContactDetail.this, "Ghi âm", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }
}
