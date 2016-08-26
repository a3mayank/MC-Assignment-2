package com.mayankattri.primeornot;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class CheatActivityFragment extends Fragment {

    public CheatActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Intent intent = getActivity().getIntent();
        View rootView = inflater.inflate(R.layout.fragment_cheat, container, false);

        String optionYes = "Prime Number : YES";
        String optionNo = "Prime Number : NO";
        String reasonYes = "Reason : Only 2 factors";
        String reasonNo = "Reason : More than 2 factors";

        ArrayList<Integer> myImageList = new ArrayList<>();
        myImageList.add(R.drawable.a);
        myImageList.add(R.drawable.b);
        myImageList.add(R.drawable.c);
        myImageList.add(R.drawable.d);
        myImageList.add(R.drawable.e);
        myImageList.add(R.drawable.f);

        if(intent != null) {
            String number = intent.getStringExtra("CheatActivity");
            int image_index = intent.getIntExtra("CheatActivityBG", 0);

            if(image_index == 0) {
                rootView.setBackgroundResource(myImageList.get(5));
            } else {
                rootView.setBackgroundResource(myImageList.get(image_index -1));
            }

            TextView textView1 = (TextView) rootView.findViewById(R.id.TV_number);
            TextView textView2 = (TextView) rootView.findViewById(R.id.TV_answer);
            TextView textView3 = (TextView) rootView.findViewById(R.id.TV_reason);

            textView1.setText(number);

            if(isPrime(Integer.parseInt(number))) {
                textView1.setTextColor(Color.GREEN);
                textView2.setText(optionYes);
                textView3.setText(reasonYes);
            } else {
                textView1.setTextColor(Color.RED);
                textView2.setText(optionNo);
                textView3.setText(reasonNo);
            }

        }

        return rootView;
    }

    // checks if a number is prime or not
    private boolean isPrime(int value) {
        if(value == 1) {
            return false;
        }
        for (int i = 2; i * i <= value; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
