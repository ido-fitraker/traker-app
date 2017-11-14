package com.traker.traker.activities.login_flow;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.traker.traker.R;
import com.traker.traker.beans.TrakerUser;
import com.traker.traker.components.TrakerButton;
import com.traker.traker.managers.LoginManager;
import com.traker.traker.util.loggers.TrakerLog;

import java.io.FileNotFoundException;

public class PersonalDetailsActivity extends AppCompatActivity {

    private ImageView mProfileImage;
    // might have to be some Facebook specific button. check with Facebook sdk.
    private ImageButton mFacebookButton;
    private EditText mNamePersonalDetails;
    private EditText mAgePersonalDetails;
    private Spinner mGenderPersonalDetails;
    private TrakerButton mContinueButton;
    private CheckBox mCheckBox;
    private String mGenderSelection;
    private String mPicturePath;
    private static int RESULT_LOAD_IMAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private static int PERMISSION_REQUEST_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);
        bindViews();
        initViews();
        verifyStoragePermissions(this);
        TrakerLog.d(TrakerLog.getCause()+" onCreate method");
    }

    private void bindViews() {
        mProfileImage = (ImageView) findViewById(R.id.personal_details_personal_image);
        mNamePersonalDetails = (EditText)findViewById(R.id.personal_details_questionnaire_name);
        mAgePersonalDetails = (EditText)findViewById(R.id.personal_details_questionnaire_age);
        mGenderPersonalDetails = (Spinner)findViewById(R.id.personal_details_questionnaire_gender_spinner);
        mContinueButton = (TrakerButton)findViewById(R.id.personal_details_continue_button);
        mCheckBox = (CheckBox)findViewById(R.id.personal_details_checkbox);
        TrakerLog.d(TrakerLog.getCause()+" binded views");
    }
    private void initViews(){
        populateSpinners();
        assignImageListener();
        assignContinueButtonListener();
        // needs to add the Facebook button listener according the Facebook sdk.
        TrakerLog.d(TrakerLog.getCause()+" initiated views");
    }

    private void populateSpinners(){
        mGenderPersonalDetails.setAdapter(ArrayAdapter.createFromResource(this,
                R.array.gender_array,
                R.layout.support_simple_spinner_dropdown_item
        ));
        mGenderPersonalDetails.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mGenderSelection = adapterView.getItemAtPosition(i).toString();
                TrakerLog.i(TrakerLog.getCause()+" item selected: "+ mGenderSelection);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        TrakerLog.d(TrakerLog.getCause()+" populated gender spinner");
    }
    private void assignImageListener(){
        mProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(
                        Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
        TrakerLog.d(TrakerLog.getCause()+" assigend imageListener");
    }
    private void assignContinueButtonListener() {
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitDetails();
                TrakerLog.d(TrakerLog.getCause()+" pressed continue button");
            }
        });
        TrakerLog.d(TrakerLog.getCause());
    }

    private void submitDetails() {
        if(mCheckBox.isChecked()) {
//            TrakerUser currentUser = LoginManager.getInstance().getLoggedinUser();
//            currentUser.setFullName(mNamePersonalDetails.getText().toString());
//            currentUser.setAge(Integer.valueOf(mAgePersonalDetails.getText().toString()));
//            currentUser.setGender(mGenderSelection);
//            currentUser.setProfileImageURI(mPicturePath);
            TrakerLog.d(TrakerLog.getCause()+" initiated user");
//            TrakerLog.d(TrakerLog.getCause()+currentUser);
            Intent i = new Intent(this, HealthFormActivity.class);
            startActivity(i);
        }else{
            Toast.makeText(this, "עליך לאשר את תנאי השימוש כדי להמשיך.", Toast.LENGTH_SHORT).show();
        }
    }
    //persmission method.
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have read or write permission
        int writePermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int readPermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE);

        if (writePermission != PackageManager.PERMISSION_GRANTED || readPermission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    PERMISSION_REQUEST_CODE
            );
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data){
            Uri selectedImage = data.getData();
            TrakerLog.d(TrakerLog.getCause()+" path to selected image: "+selectedImage.toString());
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            mPicturePath = cursor.getString(columnIndex);
            cursor.close();
            TrakerLog.i(TrakerLog.getCause()+" picture path: "+mPicturePath);

            Bitmap bitmap;
            bitmap = BitmapFactory.decodeFile(mPicturePath);

            Toast.makeText(this, bitmap.toString(), Toast.LENGTH_SHORT).show();

            mProfileImage.setImageBitmap(bitmap);

//            mProfileImage.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            TrakerLog.d(TrakerLog.getCause()+" set image bitmap on ImageView");

        }
    }

}
