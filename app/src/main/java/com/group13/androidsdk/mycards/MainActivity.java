/*
 * Copyright (c) 2017 Michael D'Arcy and Brianne O'Niel.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.group13.androidsdk.mycards;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {
    Button btnReview, btnBrowse, btnSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReview = (Button)findViewById(R.id.btnReview);
        btnBrowse = (Button)findViewById(R.id.btnBrowse);
        btnSettings = (Button)findViewById(R.id.btnSettings);



    }


    public void btnClick(View v){
        switch(v.getId()){
            case R.id.btnStReview:
                //go to START REVIEW activity
                Intent toReview = new Intent(this, ReviewCategoryActivity.class);
                startActivity(toReview);
                break;
            case R.id.btnBrowse:
                //go to BROWSE CARDS activity
                Intent toBrowse = new Intent(this, BrowseCardsActivity.class);
                startActivity(toBrowse);
                break;
            case R.id.btnSettings:
                //to to SETTINGS activity
                Intent toSettings = new Intent(this, SettingsActivity.class);
                startActivity(toSettings);
                break;
            default:
                break;
        }
    }
}
