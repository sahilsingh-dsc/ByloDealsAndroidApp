package com.byloapp.bylodeals.ui.fragments.merchant;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.byloapp.bylodeals.R;

public class PreviewDealFragment extends Fragment {



    public PreviewDealFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_preview_deal, container, false);


        return view;
    }

}
