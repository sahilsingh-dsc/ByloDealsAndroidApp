package com.byloapp.bylodeals.ui.fragments.merchant;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.byloapp.bylodeals.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PastDealFragment extends Fragment {


    public PastDealFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_past_deal, container, false);
    }

}
