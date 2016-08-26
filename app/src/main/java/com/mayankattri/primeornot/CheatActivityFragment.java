package com.mayankattri.primeornot;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class CheatActivityFragment extends Fragment {

    private String number;
    private int image_index;
    private String optionYes = "is a Prime Number";
    private String optionNo = "is not a Prime Number";

    public CheatActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Intent intent = getActivity().getIntent();
        View rootView = inflater.inflate(R.layout.fragment_cheat, container, false);

        ArrayList<Integer> myImageList = new ArrayList<>();
        myImageList.add(R.drawable.a);
        myImageList.add(R.drawable.b);
        myImageList.add(R.drawable.c);
        myImageList.add(R.drawable.d);
        myImageList.add(R.drawable.e);
        myImageList.add(R.drawable.f);

        if(intent != null) {
            number = intent.getStringExtra("CheatActivity");
            image_index = intent.getIntExtra("CheatActivityBG", 0);

            if(image_index == 0) {
                rootView.setBackgroundResource(myImageList.get(5));
            } else {
                rootView.setBackgroundResource(myImageList.get(image_index-1));
            }

            TextView textView1 = (TextView) rootView.findViewById(R.id.TV_number);
            TextView textView2 = (TextView) rootView.findViewById(R.id.TV_answer);

            textView1.setText(number);

            if(isPrime(Integer.parseInt(number))) {
                textView2.setText(optionYes);
            } else {
                textView2.setText(optionNo);
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
