package com.byloapp.bylodeals.ui.fragments.merchant;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.byloapp.bylodeals.R;

public class ClaimedDealFragment extends Fragment {

    RecyclerView recyclerClaimedDeal;
    ImageView imgBackToDash;

    public ClaimedDealFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_claimed_deal, container, false);

        imgBackToDash = view.findViewById(R.id.imgBackToDash);
        imgBackToDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new MerchantDashboardFragment());
            }
        });

        recyclerClaimedDeal = view.findViewById(R.id.recyclerClaimedDeal);
        recyclerClaimedDeal.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameMC, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
