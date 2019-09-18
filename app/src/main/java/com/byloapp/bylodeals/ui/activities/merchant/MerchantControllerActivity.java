package com.byloapp.bylodeals.ui.activities.merchant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.byloapp.bylodeals.R;
import com.byloapp.bylodeals.ui.fragments.merchant.MerchantDashboardFragment;

public class MerchantControllerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_controller);

        FragmentManager fm = getSupportFragmentManager();
        MerchantDashboardFragment merchantDashboardFragment = new MerchantDashboardFragment();
        fm.beginTransaction().add(R.id.frameMC,merchantDashboardFragment).commit();



    }
}
