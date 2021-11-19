package com.example.toife;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.ms.square.android.expandabletextview.ExpandableTextView;

public class stories extends AppCompatActivity {

    public TextView t1;
    public TextView t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);

        ExpandableTextView textView = findViewById(R.id.expand_text_view);
        textView.setText(getString(R.string.i_was_in_st));

        ExpandableTextView textView1 = findViewById(R.id.expand_text_view2);
        textView1.setText(getString(R.string.tug_of_war_));

        ExpandableTextView textView2 = findViewById(R.id.expand_text_view3);
        textView2.setText(getString(R.string.am_grateful));

        ExpandableTextView textView3=findViewById(R.id.expand_text_view4);
        ExpandableTextView textView4 = findViewById(R.id.expand_text_view5);
        ExpandableTextView textView5 = findViewById(R.id.expand_text_view6);
        ExpandableTextView textView6 = findViewById(R.id.expand_text_view7);
        ExpandableTextView textView7 = findViewById(R.id.expand_text_view8);
        ExpandableTextView textView8 = findViewById(R.id.expand_text_view9);
        ExpandableTextView textView9 = findViewById(R.id.expand_text_view10);

        textView3.setText(getString(R.string.being_a_dau));
        textView4.setText(getString(R.string.for_me_it_s));
        textView5.setText(getString(R.string.at_21_i_rea));
        textView6.setText(getString(R.string.be_aware_be));
        textView7.setText(getString(R.string.you_don_t_h));
        textView8.setText(getString(R.string.i_have_live));
        textView9.setText(getString(R.string.one_of_the_));


    }
}