package com.project.eddsato.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void checkRadioAnswers (){
        RadioGroup mQuestion01RadioButton = (RadioGroup) findViewById(R.id.rg_answers01);
        if (mQuestion01RadioButton.getCheckedRadioButtonId() == R.id.rb_link){
            correct += 1;
        }

        RadioGroup mQuestion02RadioButton = (RadioGroup) findViewById(R.id.rg_answers02);
        if (mQuestion02RadioButton.getCheckedRadioButtonId() == R.id.rb_13hearts){
            correct += 1;
        }

        RadioGroup mQuestion03RadioButton = (RadioGroup) findViewById(R.id.rg_answers03);
        if (mQuestion03RadioButton.getCheckedRadioButtonId() == R.id.rb_120years){
            correct += 1;
        }

    }

    public void checkCheckBoxAnswers(){
        CheckBox mMiphaCheckBox = (CheckBox) findViewById(R.id.cb_mipha);
        CheckBox mDarukCheckBox = (CheckBox) findViewById(R.id.cb_daruk);
        CheckBox mRevaliCheckBox = (CheckBox) findViewById(R.id.cb_revali);
        CheckBox mUrbosaCheckBox = (CheckBox) findViewById(R.id.cb_urbosa);
        CheckBox mEponaCheckBox = (CheckBox) findViewById(R.id.cb_epona);
        CheckBox mSheikCheckBox = (CheckBox) findViewById(R.id.cb_sheik);

        boolean isMiphaCheckBoxChecked = mMiphaCheckBox.isChecked();
        boolean isDarukCheckBoxChecked = mDarukCheckBox.isChecked();
        boolean isRevaliCheckBoxChecked = mRevaliCheckBox.isChecked();
        boolean isUrbosaCheckBoxChecked = mUrbosaCheckBox.isChecked();
        boolean isEponaCheckBoxChecked = mEponaCheckBox.isChecked();
        boolean isSheikCheckBoxChecked = mSheikCheckBox.isChecked();

        if (isMiphaCheckBoxChecked && isDarukCheckBoxChecked && isRevaliCheckBoxChecked &&
                isUrbosaCheckBoxChecked && !isEponaCheckBoxChecked && !isSheikCheckBoxChecked){
            correct += 1;
        }

    }

    public void checkTypedAnswers(){
        EditText mPrimalEvilEditText = (EditText) findViewById(R.id.et_primalEvil);
        String name = mPrimalEvilEditText.getText().toString();

        if (name.equalsIgnoreCase("calamity ganon")){
            correct += 1;
        }
    }

    public void submitQuiz (View view){
        correct = 0;

        checkRadioAnswers();
        checkCheckBoxAnswers();
        checkTypedAnswers();

        Toast.makeText(this, "Correct answers: " + correct, Toast.LENGTH_SHORT).show();
    }

}
