package com.abubakar.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

//1.implement an interface (view.onclick listener)
//7 Implement an interface (AdapterView.onItemSelectedListener
public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    //2.declare a variable to hold the EditTExt input
    private EditText birthday;
    //5.declare the variables to hold the selected date
    private  int mYear;
    private  int mMonth;
    private  int mDay;

    //7.6 declare a variable for holding the item selected on the spinner
    private String mSpinnerLabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //3.connect the edit text variable with the one in the layout
        birthday = findViewById(R.id.birthday);
        //4, connect the edit Text variable with an onclick listener
        birthday.setOnClickListener(this);
        //7.1 declare a spinner variable and connect it with the spinner view in the layout
        Spinner phonespinner= findViewById(R.id.phone_spinner);
        //7.2 set an onItemSelectedListener on the spinner object/variable you have created

        if(phonespinner!=null){
            phonespinner.setOnItemSelectedListener(this);
        }
        //7.3 create an array adapter using the string array and default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinner_label,android.R.layout.simple_spinner_item);
        //7.4 specify the layout for dropdown menu
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //attach the spinner to the adapter
        if(phonespinner!=null) {
            phonespinner.setAdapter(adapter);
        }

    }

    @Override
    public void onClick(View v) {
        //6 get instance of the current date
        //6.1 endure the focus is on the current edit variable birthday

        if(v == birthday){
            //6.2 Declare a calendar to get current selected date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);
            //6.3 Declare a date picker dialogue to pick selected dates
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    //6.4 set the date on the editText variable
                    birthday.setText(dayOfMonth+"-"+(month+1+"-"+year));
                }
            },mYear,mMonth,mDay);
            //6.5 show the date picker dialog
            datePickerDialog.show();
        }

    }

    public void showToast(View view) {
        Toast check = Toast.makeText(this,"Please Accept Terms and Conditions", Toast.LENGTH_SHORT);
        check.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
//7.6 declare a variable for holding the selected value on the spinner
        //7.7 use the method getItemAtPosition() to get the label selected
        mSpinnerLabel = adapterView.getItemAtPosition(position).toString();
        //7.8 something to do with item selected
        Toast myToast = Toast.makeText(this,"selected phone as: "+mSpinnerLabel,Toast.LENGTH_SHORT);
        myToast.show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast myToast = Toast.makeText(this,"Nothing selected ",Toast.LENGTH_SHORT);
        myToast.show();
    }

    public void createAccount(View view){
        //compare passwords
        //throw error exceptions
        //get the data entered on edit text and save it on a database
        //add an intent and open main activity/login activity
        //throw a toast
        Toast toastSubmit = Toast.makeText(this,"Account Creation Successful",Toast.LENGTH_SHORT);
        toastSubmit.show();

    }

}
