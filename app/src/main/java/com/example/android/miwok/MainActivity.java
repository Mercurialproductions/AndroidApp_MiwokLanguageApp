/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    //Creates global variables
    TextView numbers, family, phrases, colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);


        //Initilizes global variables by asigning a view Id
        numbers = (TextView)findViewById(R.id.numbers);
        family = (TextView) findViewById(R.id.family);
        colors = (TextView) findViewById(R.id.colors);
        phrases = (TextView) findViewById(R.id.phrases);

        //Sets onclick listener events

        //Onclick listener for numbers

        numbers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent openNumbers = new Intent(MainActivity.this, NumberActivity.class);// creates an explicit intent to open the Numbers Activity

                startActivity(openNumbers); //Starts the Numbers Activity
            }
        });

        //Onclick listener for family

        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent openFamily = new Intent(MainActivity.this, FamilyActivity.class); //creates an explicit intent to open the family activity

                startActivity(openFamily); //Starts the Family Activity
            }


        });

        //Onclick listener for colors

        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent openColors = new Intent(MainActivity.this, ColorsActivity.class); //creates and explicit inent to open the Colors Activity

                startActivity(openColors); //Starts the Colors Activity
            }

        });


        //Onclick listerer for phrases

        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent openPhrases = new Intent(MainActivity.this, PhrasesActivity.class); //Creates an explicit intent to open the Phrases Activity

                startActivity(openPhrases);
            }
        });


    }






}
