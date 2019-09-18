package com.byloapp.bylodeals.ui.fragments.merchant;


import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.byloapp.bylodeals.R;

public class MerchantDashboardFragment extends Fragment {

    CardView cardPost, cardManage, cardPast, cardClaimed;

    public MerchantDashboardFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_merchant_dashboard, container, false);

        cardPost = view.findViewById(R.id.cardPost);
        cardPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new AddDealFragment());
            }
        });

        cardManage = view.findViewById(R.id.cardManage);
        cardManage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new ManageDealFragment());
            }
        });

        cardPast = view.findViewById(R.id.cardPast);
        cardPast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new PastDealFragment());
            }
        });

        cardClaimed = view.findViewById(R.id.cardClaimed);
        cardClaimed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new ClaimedDealFragment());
            }
        });

        return view;
    }


    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameMC, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
