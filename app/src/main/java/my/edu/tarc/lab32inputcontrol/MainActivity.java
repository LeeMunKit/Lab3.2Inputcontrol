package my.edu.tarc.lab32inputcontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;
    private double basicPremium;
    private double extraPayMale;
    private double extraPaySmoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerAge = (Spinner)findViewById(R.id.spinnerAge);
        spinnerAge.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.age, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(adapter);

        radioButtonMale = (RadioButton)findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton)findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = (CheckBox)findViewById(R.id.checkBoxSmoker);
        textViewPremium = (TextView)findViewById(R.id.textViewPremium);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //TODO: calculate basic premium according to age group
        switch (position) {
            case 0:
                basicPremium = 50;
                extraPayMale = 0 ;
                extraPaySmoke = 0;
                break;
            case 1:
                basicPremium = 55;
                extraPayMale = 0 ;
                extraPaySmoke = 0;
                break;
            case 2:
                basicPremium = 60;
                extraPayMale = 50 ;
                extraPaySmoke = 0;
                break;
            case 3:
                basicPremium = 70;
                extraPayMale = 100 ;
                extraPaySmoke = 100;
                break;
            case 4:
                basicPremium = 120;
                extraPayMale = 100 ;
                extraPaySmoke = 150;
                break;
            case 5:
                basicPremium = 160;
                extraPayMale = 50 ;
                extraPaySmoke = 150;
                break;
            case 6:
                basicPremium = 200;
                extraPayMale = 0 ;
                extraPaySmoke = 250;
                break;
            case 7:
                basicPremium = 250;
                extraPayMale = 0 ;
                extraPaySmoke = 250;
                break;
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculate(View v){
        RadioGroup radioGroupAge = (RadioGroup)findViewById(R.id.radioGroup);
        int gender = radioGroupAge.getCheckedRadioButtonId();

        double total = 0;
        total += basicPremium;

        if(checkBoxSmoker.isChecked()==true){
            total += extraPaySmoke;
        }
        if(gender == R.id.radioButtonMale){
            total += extraPayMale;
        }
        textViewPremium.setText(String.format("RM %.2f",total));
    }

    public void clearText(View v){

    }
}
