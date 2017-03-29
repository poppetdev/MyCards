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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The methods of the Card class are mostly self-explanatory, so I will omit detailed
 * descriptions on them for now. The main thing to know is that the Card class contains all the
 * relevant information about a card, and is mainly used to pass flashcard information between
 * classes.
 */
@SuppressWarnings("unused")
public class Card {

    @SuppressWarnings("FieldCanBeLocal")
    private int id = -1;

    private String frontText = "";
    private String backText = "";
    private List<String> tags = new ArrayList<>();

    private Date lastReviewDate = null;
    private Date nextReviewDate = null;
    private double easiness = -1.0;

    public Card(int id, String frontText, String backText, Date nextReviewDate, Date lastReviewDate, double easiness) {
        this.id = id;
        this.frontText = frontText;
        this.backText = backText;
        this.nextReviewDate = nextReviewDate;
        this.lastReviewDate = lastReviewDate;
        this.easiness = easiness;
    }


    public String getFrontText() {
        return frontText;
    }


    public void setFrontText(String frontText) {
        this.frontText = frontText;
    }


    public String getBackText() {
        return backText;
    }


    public void setBackText(String backText) {
        this.backText = backText;
    }


    public int getId() {
        return id;
    }


    public String[] getTags() {
        return (String[]) tags.toArray();
    }


    public void addTag(String tag) {
        this.tags.add(tag);
    }


    public void removeTag(String tag) {
        this.tags.remove(tag);
    }


    public Date getLastReviewDate() {
        return lastReviewDate;
    }


    public void setLastReviewDate(Date lastReviewDate) {
        this.lastReviewDate = lastReviewDate;
    }


    public Date getNextReviewDate() {
        return nextReviewDate;
    }


    public void setNextReviewDate(Date nextReviewDate) {
        this.nextReviewDate = nextReviewDate;
    }


    public double getEasiness() {
        return easiness;
    }


    public void setEasiness(double easiness) {
        this.easiness = easiness;
    }


}
