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

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Database manager. This class provides a high-level interface to database operations in the app.
 */
class MyCardsDBManager extends SQLiteOpenHelper implements NotificationStorage, CardStorage {

    private Context context = null;

    MyCardsDBManager(Context context,
                     String name,
                     SQLiteDatabase.CursorFactory factory,
                     int dbVersion) {
        super(context, name, factory, dbVersion);
        this.context = context;
    }

    @Override
    public void deleteCardById(int cardId) {
        SQLiteDatabase db = this.getWritableDatabase();
        Object[] args = {cardId};
        try {
            db.beginTransaction();
            db.execSQL("DELETE FROM card WHERE _id = ?;", args);
            db.execSQL("DELETE FROM tag WHERE cardId = ?", args);
            db.setTransactionSuccessful();
        } catch (SQLiteException e) {
            Log.e("DBManager", "deleteCardById(" + cardId + ") failed with SQLiteException: " +
                    e.getLocalizedMessage());
        } finally {
            db.endTransaction();
            db.close();
        }
    }

    private static ContentValues cardToContentValues(Card card) {
        ContentValues cv = new ContentValues();
        cv.put("_id", card.getId());
        cv.put("nextReviewDate", card.getNextReviewDate().getTime());
        cv.put("lastReviewDate", card.getLastReviewDate().getTime());
        cv.put("easiness", card.getEasiness());
        cv.put("frontText", card.getFrontText());
        cv.put("backText", card.getBackText());
        return cv;
    }

    @Override
    public void insertOrUpdateCard(Card card) {
        ContentValues cv = cardToContentValues(card);
        String[] whereArgs = {String.valueOf(card.getId())};
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.beginTransaction();
            db.delete("card", "_id = ?", whereArgs);
            db.insert("card", null, cv);
            ContentValues tagValues = new ContentValues();
            tagValues.put("cardId", card.getId());
            for (String tagName : card.getTags()) {
                tagValues.put("tagName", tagName);
                db.insert("tag", null, tagValues);
            }
            db.setTransactionSuccessful();
        } catch (SQLiteException e) {
            Log.e("DBManager", "insertOrUpdateCard(card): " + e.getLocalizedMessage());
        } finally {
            db.endTransaction();
            db.close();
        }
    }

    private Card cardFromCursor(Cursor cursor) {
        if(cursor.isBeforeFirst() || cursor.isAfterLast()) {
            return null;
        }

        return new Card(cursor.getInt(cursor.getColumnIndex("_id")),
                cursor.getString(cursor.getColumnIndex("frontText")),
                cursor.getString(cursor.getColumnIndex("backText")),
                new Date(cursor.getLong(cursor.getColumnIndex("nextReviewDate"))),
                new Date(cursor.getLong(cursor.getColumnIndex("lastReviewDate"))),
                cursor.getDouble(cursor.getColumnIndex("easiness"))
        );
    }

    private Card[] cardArrayFromCursor(Cursor cursor) {
        List<Card> cards = new ArrayList<>();
        cursor.moveToFirst();
        do {
            cards.add(cardFromCursor(cursor));
        } while(cursor.moveToNext());

        return cards.toArray(new Card[cards.size()]);
    }

    @Override
    public Card getCardById(int cardId) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] args = {String.valueOf(cardId)};
        Cursor c = db.rawQuery("SELECT * FROM card WHERE _id = ?;", args);
        c.moveToFirst();
        return cardFromCursor(c);
    }

    @Override
    public Card[] getAllCards() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM card;", null);
        return cardArrayFromCursor(c);
    }

    @Override
    public Card[] getCardsForReviewBefore(Date d) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] args = {String.valueOf(d.getTime())};
        Cursor c = db.rawQuery("SELECT * FROM card WHERE nextReviewDate < ?;", args);
        return cardArrayFromCursor(c);
    }

    @Override
    public void deleteNotificationRuleById(int ruleId) {

    }

    @Override
    public void insertOrUpdateNotificationRule(NotificationRule rule) {

    }

    @Override
    public NotificationRule getNotificationRuleById(int ruleId) {
        return null;
    }

    @Override
    public NotificationRule[] getAllNotificationRules() {
        return new NotificationRule[0];
    }

    @Override
    public NotificationRule[] getAllNotificationRulesForDate(Date d) {
        return new NotificationRule[0];
    }

    @Override
    public void setDoNotDisturb(boolean enabled) {

    }

    @Override
    public boolean getDoNotDisturb() {
        return false;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.beginTransaction();
        try {
            db.execSQL(context.getString(R.string.create_card_table_sql));
            db.execSQL(context.getString(R.string.create_tag_table_sql));
            db.setTransactionSuccessful();
        } catch (SQLiteException e) {
            Log.e("DBManager", "onCreate(db): " + e.getLocalizedMessage());
        } finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO: Implement this
    }
}
