package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView questionsTv, questionNumberTv;
    private Button option1, option2, option3, option4;
    private ArrayList<QuizModal> quizModalArrayList;
    Random random;
    int currentScore=0, QuestionsAttempted=1, currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionsTv = (TextView) findViewById(R.id.Questions);
        questionNumberTv = (TextView) findViewById(R.id.QuestionsAttempted);
        option1 = (Button) findViewById(R.id.Option1);
        option2 = (Button) findViewById(R.id.Option2);
        option3 = (Button) findViewById(R.id.Option3);
        option4 = (Button) findViewById(R.id.Option4);
        quizModalArrayList = new ArrayList<>();
        random= new Random();
        getQuizQuestions(quizModalArrayList);
        currentPos =0;
        setDataView(currentPos);
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                QuestionsAttempted++;
                currentPos++;
                setDataView(currentPos);
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                QuestionsAttempted++;
                currentPos++;
                setDataView(currentPos);
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                QuestionsAttempted++;
                currentPos++;
                setDataView(currentPos);
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                QuestionsAttempted++;
                currentPos++;
                setDataView(currentPos);
            }
        });
    }
    private void displayBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.LScore));
        TextView score = bottomSheetView.findViewById(R.id.idScore);
        Button reStartQuizBtn = bottomSheetView.findViewById(R.id.restart);
        score.setText("Your Score is : \n"+currentScore + "/8");
        reStartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos=0;
                setDataView(currentPos);
                QuestionsAttempted =1;
                currentScore=0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void setDataView(int currentPos) {
        questionNumberTv.setText("Questions Attempted : " +QuestionsAttempted + "/8");

        if(QuestionsAttempted ==9){
            displayBottomSheet();
        }else{
            questionsTv.setText(quizModalArrayList.get(currentPos).getQuestions());
            option1.setText(quizModalArrayList.get(currentPos).getOption1());
            option2.setText(quizModalArrayList.get(currentPos).getOption2());
            option3.setText(quizModalArrayList.get(currentPos).getOption3());
            option4.setText(quizModalArrayList.get(currentPos).getOption4());

        }

    }

    private void getQuizQuestions(ArrayList<QuizModal>quizModalArrayList) {
        quizModalArrayList.add(new QuizModal("Which folder do you copy and paste an image into?","Layout","Resources","Drawable","Java","Drawable"));
        quizModalArrayList.add(new QuizModal("Which is correct for using any image with the name trainstation?","Android:\"@drawable/trainstation\"","Android:src=\"trainstation\"","Src=@drawable/trainstation","Android:src=\"@drawable/trainstation\"","Drawable"));
        quizModalArrayList.add(new QuizModal("How to kill an activity in Android?","finish()"," finishActivity(int requestCode)","kill()","A & B","A & B"));
        quizModalArrayList.add(new QuizModal("On which thread services work in android?","Worker Thread","Own Thread"," Main Thread","None of the above.","Main Thread"));
        quizModalArrayList.add(new QuizModal("How many threads are there in asyncTask in android?","Only one","Two","AsyncTask doesn't have tread","None of the Above","Only one"));
        quizModalArrayList.add(new QuizModal("What is the 9 patch tool in android?","Using with tool, we can redraw images in 9 sections","image extension tool","image editable tool","Device features","Using with tool, we can redraw images in 9 sections."));
        quizModalArrayList.add(new QuizModal("What is ADB in android?"," Image tool","Development tool","Android Debug Bridge"," None of the above.","Android Debug Bridge"));
        quizModalArrayList.add(new QuizModal("How many orientations does android support?","4","10","2","None of the above","4"));



    }

    public void nextQuestion(View view) {
        if(QuestionsAttempted<=9) {
            currentPos++;
            QuestionsAttempted++;
            setDataView(currentPos);
        }else{
            displayBottomSheet();
        }

    }
}