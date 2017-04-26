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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;


//TODO implement spinner handler, retrieving cards by tag, view recycling
public class BrowseCardsActivity extends AppCompatActivity {
    Button newCard;
    Spinner tagList;
    ListView cardView;
    ArrayAdapter<Card> cardArrayAdapter;
    CardBrowser browser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_cards);

        newCard = (Button)findViewById(R.id.btnNewCard);
        tagList = (Spinner)findViewById(R.id.spinTags);
        cardView = (ListView)findViewById(R.id.lvCards);
        browser = new CardBrowser();
        Card[] cardArray;

    }
    public void addNewCard(View view){
        if(view.getId() == R.id.btnNewCard){
            Intent toNewCard = new Intent(this, NewCardActivity.class);
            startActivity(toNewCard);
        }
    }
}
