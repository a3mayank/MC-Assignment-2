package com.mayankattri.primeornot;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

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

            if (image_index == 0) {
                rootView.setBackgroundResource(myImageList.get(5));
            } else {
                rootView.setBackgroundResource(myImageList.get(image_index - 1));
            }
        }

        return rootView;
    }
}
