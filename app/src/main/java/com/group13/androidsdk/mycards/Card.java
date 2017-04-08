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

    private Date lastReviewDate = new Date(0);
    private Date nextReviewDate = new Date(0);
    private double easiness = 2.5;

    public Card(int id,
                String frontText,
                String backText,
                Date nextReviewDate,
                Date lastReviewDate,
                double easiness) {
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

    public void setId(int id) {
        this.id = id;
    }


    public String[] getTags() {
        return tags.toArray(new String[tags.size()]);
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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Card card = (Card) o;

        if (id != card.id) {
            return false;
        }
        if (Double.compare(card.easiness, easiness) != 0) {
            return false;
        }
        if (!frontText.equals(card.frontText)) {
            return false;
        }
        if (!backText.equals(card.backText)) {
            return false;
        }
        if (!tags.equals(card.tags)) {
            return false;
        }
        if (lastReviewDate != null ? !lastReviewDate.equals(card.lastReviewDate) : card
                .lastReviewDate != null) {
            return false;
        }
        return nextReviewDate != null ? nextReviewDate.equals(card.nextReviewDate) : card
                .nextReviewDate == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + frontText.hashCode();
        result = 31 * result + backText.hashCode();
        result = 31 * result + tags.hashCode();
        result = 31 * result + (lastReviewDate != null ? lastReviewDate.hashCode() : 0);
        result = 31 * result + (nextReviewDate != null ? nextReviewDate.hashCode() : 0);
        temp = Double.doubleToLongBits(easiness);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
