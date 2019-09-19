package com.byloapp.bylodeals.ui.fragments.merchant;


import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.byloapp.bylodeals.R;

public class ManageDealFragment extends Fragment {

    ImageView imgBackToDash;
    TextView txtDeactivateDeal;
    RecyclerView recyclerManageDeal;

    public ManageDealFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manage_deal, container, false);


        imgBackToDash = view.findViewById(R.id.imgBackToDash);
        imgBackToDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new MerchantDashboardFragment());
            }
        });

//        txtDeactivateDeal = view.findViewById(R.id.txtDeactivateDeal);
//        txtDeactivateDeal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                LayoutInflater layoutInflater = LayoutInflater.from(getContext());
//                final View imageChooser = layoutInflater.inflate(R.layout.deactivate_success_alert, null);
//                final AlertDialog addDealDialog = new AlertDialog.Builder(getContext()).create();
//                addDealDialog.setView(imageChooser);
//                imageChooser.findViewById(R.id.btnDealOk).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        addDealDialog.dismiss();
//                    }
//                });
//                addDealDialog.show();
//
//            }
//        });

        recyclerManageDeal = view.findViewById(R.id.recyclerManageDeal);
        recyclerManageDeal.setLayoutManager(new LinearLayoutManager(getContext()));


        return view;
    }


    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameMC, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
