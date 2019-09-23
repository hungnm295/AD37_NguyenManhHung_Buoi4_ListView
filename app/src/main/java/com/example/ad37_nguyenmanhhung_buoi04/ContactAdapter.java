package com.example.ad37_nguyenmanhhung_buoi04;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {
    ArrayList<Contact> contactList;

    public ContactAdapter(ArrayList<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int i) {
        return contactList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ResourceType")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        view = inflater.inflate(R.layout.item_layout, viewGroup, false);
        ImageView imgCall = view.findViewById(R.id.imgCall);
        TextView tvNumberName = view.findViewById(R.id.tvNumberName);
        TextView tvCountry = view.findViewById(R.id.tvCountry);
        TextView tvDate = view.findViewById(R.id.tvDate);

        Contact contact = contactList.get(i);
        switch (contact.getCall()){
            case 1:
                imgCall.setImageResource(R.drawable.ic_incoming_call);
                break;
            case 2:
                imgCall.setImageResource(R.drawable.ic_outgoing_call);
                break;
            case 3:
                imgCall.setImageResource(R.drawable.ic_missed_call);
                tvNumberName.setTextColor(Color.RED);
                break;
        }
        tvNumberName.setText(contact.getNumberName());
        tvCountry.setText(contact.getCountry());
        tvDate.setText(contact.getDate());
        return view;
    }
}
