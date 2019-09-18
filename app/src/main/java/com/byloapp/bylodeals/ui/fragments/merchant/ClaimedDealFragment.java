package com.byloapp.bylodeals.ui.fragments.merchant;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.byloapp.bylodeals.R;

public class ClaimedDealFragment extends Fragment {


    public ClaimedDealFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_claimed_deal, container, false);
    }

}
