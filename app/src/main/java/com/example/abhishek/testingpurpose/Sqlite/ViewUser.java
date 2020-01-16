package com.example.abhishek.testingpurpose.Sqlite;

import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.abhishek.testingpurpose.R;
import com.example.abhishek.testingpurpose.databinding.ActivityViewUserBinding;

import java.net.Proxy;
import java.util.ArrayList;

public class ViewUser extends AppCompatActivity {

    ActivityViewUserBinding activityViewUserBinding;
    ArrayList<User> userArrayList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            activityViewUserBinding = DataBindingUtil.setContentView(ViewUser.this, R.layout.activity_view_user);

            activityViewUserBinding.linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            activityViewUserBinding.tableLayout.setStretchAllColumns(true);

            TableRow rowTitle = new TableRow(this);
            rowTitle.setGravity(Gravity.CENTER);

            TableRow rowTable = new TableRow(this);

            TextView textView = new TextView(this);
            textView.setText("User Detail...");
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
            textView.setGravity(Gravity.CENTER);
            textView.setTypeface(Typeface.SERIF, Typeface.BOLD);
            rowTitle.addView(textView);
            activityViewUserBinding.tableLayout.addView(rowTitle);


            TextView t1 = new TextView(this);
            TextView t2 = new TextView(this);
            TextView t3 = new TextView(this);
            TextView t4 = new TextView(this);
            t1.setText("ID");
            t2.setText("NAME");
            t3.setText("EMAIL");
            t4.setText("MOBILE");

            t1.setPadding(8, 0, 8, 0);
            t2.setPadding(8, 0, 8, 0);
            t3.setPadding(8, 0, 8, 0);
            t4.setPadding(8, 0, 8, 0);

            activityViewUserBinding.linearLayout.addView(t1);
            activityViewUserBinding.linearLayout.addView(t2);
            activityViewUserBinding.linearLayout.addView(t3);
            activityViewUserBinding.linearLayout.addView(t4);

            //rowTable.addView(activityViewUserBinding.linearLayout);
            activityViewUserBinding.tableLayout.addView(rowTable);
            MyDbHandler myDbHandler = Temp.getMyDbHandler();
            userArrayList = myDbHandler.viewUser();

            for (User user : userArrayList) {
                LinearLayout linearLayout = new LinearLayout(this);
                TableRow tableRow = new TableRow(this);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                TextView t6 = new TextView(this);
                TextView t7 = new TextView(this);
                TextView t8 = new TextView(this);
                TextView t9 = new TextView(this);
                t6.setText(user.getId());
                t7.setText(user.getName());
                t8.setText(user.getEmail());
                t9.setText(user.getPhone());

                t6.setPadding(1, 0, 1, 0);
                t7.setPadding(1, 0, 1, 0);
                t8.setPadding(1, 0, 1, 0);
                t9.setPadding(1, 0, 1, 0);

                linearLayout.addView(t6);
                linearLayout.addView(t7);
                linearLayout.addView(t8);
                linearLayout.addView(t9);

                tableRow.addView(linearLayout);

                activityViewUserBinding.tableLayout.addView(tableRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
