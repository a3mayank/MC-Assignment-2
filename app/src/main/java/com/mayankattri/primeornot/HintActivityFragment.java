package com.mayankattri.primeornot;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A placeholder fragment containing a simple view.
 */
public class HintActivityFragment extends Fragment {

    private int image_index;

    public HintActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Intent intent = getActivity().getIntent();
        View rootView = inflater.inflate(R.layout.fragment_hint, container, false);

        ArrayList<Integer> myImageList = new ArrayList<>();
        myImageList.add(R.drawable.a);
        myImageList.add(R.drawable.b);
        myImageList.add(R.drawable.c);
        myImageList.add(R.drawable.d);
        myImageList.add(R.drawable.e);
        myImageList.add(R.drawable.f);

        if(intent != null) {
            image_index = intent.getIntExtra("HintActivityBG", 0);
            String number = intent.getStringExtra("HintActivity");
            ArrayList<Integer> factors = allFactors(Integer.parseInt(number));
            String factorsList = "";

            if (image_index == 0) {
                rootView.setBackgroundResource(myImageList.get(5));
            } else {
                rootView.setBackgroundResource(myImageList.get(image_index - 1));
            }

            for(int i = 0; i < factors.size(); i++) {
                factorsList += factors.get(i);
                factorsList += ", ";
            }

            TextView textView1 = (TextView) rootView.findViewById(R.id.TV_number);
            TextView textView2 = (TextView) rootView.findViewById(R.id.TV_hint);
            TextView textView3 = (TextView) rootView.findViewById(R.id.TV_factors);

            String hint = "Hint : Prime Numbers have only 2 factors";
            String factorsStr = "Factors : " + factorsList;

            textView1.setText(number);
            textView2.setText(hint);
            textView3.setText(factorsStr);
        }

        return rootView;
    }

    public ArrayList<Integer> allFactors(int a) {
        int upperlimit = (int)(Math.sqrt(a));
        ArrayList<Integer> factors = new ArrayList<Integer>();
        for (int i = 1; i <= upperlimit; i++) {
            if (a % i == 0){
                factors.add(i);
                if (i != a/i){
                    factors.add(a/i);
                }
            }
        }
        Collections.sort(factors);
        return factors;
    }
}
