package com.byloapp.bylodeals.ui.fragments.merchant;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.byloapp.bylodeals.R;
import com.google.android.material.textfield.TextInputEditText;
import com.hootsuite.nachos.NachoTextView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;

public class AddDealFragment extends Fragment{


    String[] deal_type = {"Type of Deal", "Flash Deal"};
    String deal_typeSelected = "Type of Deal";
    String image_chooser_status = "none";
    String date_chooser_status = "none";
    String button_chooser_status = "0";

    Calendar calendar;


    TextInputEditText txtStartDate, txtEndDate, txtDealTitle, txtDealDesc;
    ImageView imgBackToDash;
    Spinner spinnerTypeOfDeal;
    ImageView imgChangeImages, imgGalleryImage, imgDealImage;
    NachoTextView txtDealKeyWords;
    TextView btnSaveAndPreview;

    private int SpannedLength = 0;

    private static final  int GALLERY_REQUEST =1;
    private final int PICK_IMAGE_REQUEST = 71;
    private static final int CAMERA_REQUEST_CODE=1;


    public AddDealFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_deal, container, false);

        imgBackToDash = (ImageView) view.findViewById(R.id.imgBackToDash);
        imgBackToDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new MerchantDashboardFragment());
            }
        });

        calendar = Calendar.getInstance();
        txtStartDate = view.findViewById(R.id.txtStartDate);
        txtEndDate = view.findViewById(R.id.txtEndDate);
        txtDealTitle = view.findViewById(R.id.txtDealTitle);
        txtDealDesc = view.findViewById(R.id.txtDealDesc);
        btnSaveAndPreview = view.findViewById(R.id.btnSaveAndPreview);

        btnSaveAndPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveAndPreview();
                if (button_chooser_status.equals("0")){
                    saveAndPreview();
                    button_chooser_status = "1";

                } else {
                    LayoutInflater layoutInflater = LayoutInflater.from(getContext());
                    final View imageChooser = layoutInflater.inflate(R.layout.dealpost_success_alert, null);
                    final AlertDialog addDealDialog = new AlertDialog.Builder(getContext()).create();
                    addDealDialog.setView(imageChooser);
                    imageChooser.findViewById(R.id.btnDealOk).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            addDealDialog.dismiss();
                            replaceFragment(new MerchantDashboardFragment());
                        }
                    });
                    addDealDialog.show();
                    button_chooser_status = "0";
                }
            }
        });

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };


        txtStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date_chooser_status = "start";
                new DatePickerDialog(getContext(), date, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        txtEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date_chooser_status = "end";
                new DatePickerDialog(getContext(), date, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        spinnerTypeOfDeal = view.findViewById(R.id.spinnerTypeOfDeal);
        ArrayAdapter deal_typeArray = new ArrayAdapter<String>(getContext(), R.layout.support_simple_spinner_dropdown_item, deal_type);
        spinnerTypeOfDeal.setAdapter(deal_typeArray);
        spinnerTypeOfDeal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                deal_typeSelected = adapterView.getItemAtPosition(i).toString();

                if (deal_typeSelected.equals("Type of Deal")){
                    spinnerTypeOfDeal.setBackground(getResources().getDrawable(R.drawable.rc_textfield_border_grey));
                    ((TextView) adapterView.getChildAt(0)).setTextColor(getResources().getColor(R.color.colorBlack60));
                } else {
                    spinnerTypeOfDeal.setBackground(getResources().getDrawable(R.drawable.rc_textfield_border_grey));
                    ((TextView) adapterView.getChildAt(0)).setTextColor(getResources().getColor(R.color.colorBlack));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] suggestions = new String[]{"Flash Deal"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, suggestions);
        txtDealKeyWords = view.findViewById(R.id.txtDealKeyWords);
        txtDealKeyWords.setAdapter(adapter);

        imgChangeImages = view.findViewById(R.id.imgChangeImages);
        imgChangeImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImageChooser();
            }
        });

        imgGalleryImage = view.findViewById(R.id.imgGalleryImage);
        imgDealImage = view.findViewById(R.id.imgDealImage);


        return view;
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        if (date_chooser_status.equals("start")){
            txtStartDate.setText(sdf.format(calendar.getTime()));
            txtStartDate.setFocusable(true);
        }

        if (date_chooser_status.equals("end")){
            txtEndDate.setText(sdf.format(calendar.getTime()));
            txtEndDate.setFocusable(true);
        }

    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameMC, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void showImageChooser(){
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        final View imageChooser = layoutInflater.inflate(R.layout.askforimage_alert, null);
        final AlertDialog imageChooserDialog = new AlertDialog.Builder(getContext()).create();
        imageChooserDialog.setView(imageChooser);
        imageChooser.findViewById(R.id.txtUploadGallery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_chooser_status = "gallery";
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Gallery Image"), PICK_IMAGE_REQUEST);
                imageChooserDialog.dismiss();
            }
        });
        imageChooser.findViewById(R.id.txtUploadDeal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_chooser_status = "deal";
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Deal Image"), PICK_IMAGE_REQUEST);
                imageChooserDialog.dismiss();
            }
        });

        imageChooserDialog.show();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null ) {
            Uri filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), filePath);
                if (image_chooser_status.equals("gallery")) {
                    imgGalleryImage.setImageBitmap(bitmap);
                }
                if (image_chooser_status.equals("deal")) {
                    imgDealImage.setImageBitmap(bitmap);
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private void saveAndPreview(){
        imgChangeImages.setClickable(false);
        txtDealTitle.setEnabled(false);
        spinnerTypeOfDeal.setEnabled(false);
        txtDealKeyWords.setEnabled(false);
        txtStartDate.setEnabled(false);
        txtEndDate.setEnabled(false);
        txtDealDesc.setEnabled(false);
        btnSaveAndPreview.setText("Post Deal");
    }

}
