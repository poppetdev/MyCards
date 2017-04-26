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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SettingsActivity extends AppCompatActivity {
    RadioGroup toggleDND;
    RadioButton noDisturb, yesDisturb;
    Button toRules, newRule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        toggleDND = (RadioGroup)findViewById(R.id.rgrpDisturbView);
        noDisturb = (RadioButton)findViewById(R.id.rbNoDisturb);
        yesDisturb = (RadioButton)findViewById(R.id.rbYesDisturb);
        toRules = (Button)findViewById(R.id.btnViewRules);
        newRule = (Button)findViewById(R.id.btnNewRule);
        yesDisturb.setChecked(true);

        //instantiate any other object required by NSM
        //NotificationSettingsManager nsm = new NotificationSettingsManager();
        //nsm.setDoNotDisturbEnabled(false);              //DO NOT DISTURB disabled by default

        //handle radioButtons

        //handle buttons

    }
    public void toggleDND(View view){
        //stuff
    }

    public void ruleButtons(View view){
        //stuff
    }


}
