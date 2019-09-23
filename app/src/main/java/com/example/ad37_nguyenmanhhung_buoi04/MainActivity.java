package com.example.ad37_nguyenmanhhung_buoi04;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvContact;
    ArrayList<Contact> contactList;
    ContactAdapter contactAdapter;
    Button btnRecent, btnContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnContact = findViewById(R.id.bntContact);
        btnRecent = findViewById(R.id.btnRecent);
        lvContact = findViewById(R.id.lvContact);

        contactList = new ArrayList<>();
        contactList.add(new Contact(3, "0987654321", "Hà Nội", "20/09/2019"));
        contactList.add(new Contact(2, "0389503456", "TP Hồ Chí Minh", "21/09/2019"));
        contactList.add(new Contact(3, "0123456789", "Đà Nẵng", "22/09/2019"));
        contactList.add(new Contact(2, "0988678543", "Cần Thơ", "23/09/2019"));
        contactList.add(new Contact(1, "0988458565", "Bắc Ninh", "24/09/2019"));
        contactList.add(new Contact(3, "0988656598", "Bắc Giang", "25/09/2019"));
        contactList.add(new Contact(1, "0987654321", "Hà Nội", "20/09/2019"));
        contactList.add(new Contact(3, "0389503456", "TP Hồ Chí Minh", "21/09/2019"));
        contactList.add(new Contact(3, "0123456776", "Đà Nẵng", "22/09/2019"));
        contactList.add(new Contact(2, "0988678543", "Cần Thơ", "23/09/2019"));
        contactList.add(new Contact(1, "0988458565", "Bắc Ninh", "24/09/2019"));
        contactList.add(new Contact(3, "0988656598", "Bắc Giang", "25/09/2019"));

        contactAdapter = new ContactAdapter(contactList);
        lvContact.setAdapter(contactAdapter);
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getBaseContext(), ContactDetail.class);
                Contact contact = contactList.get(i);
                int call = contact.getCall();
                String numberName = contact.getNumberName();
                String country = contact.getCountry();
                String date = contact.getDate();
                intent.putExtra("0", call);
                intent.putExtra("1", numberName);
                intent.putExtra("2", country);
                intent.putExtra("3", date);
                startActivity(intent);
            }
        });

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               btnRecent.setTextColor(Color.parseColor("#AAA7A7"));
               btnContact.setTextColor(Color.parseColor("#6933C9"));
            }
        });

        btnRecent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               btnContact.setTextColor(Color.parseColor("#AAA7A7"));
               btnRecent.setTextColor(Color.parseColor("#8BC34A"));
            }
        });
    }
}
