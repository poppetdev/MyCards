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


import java.util.Date;

/**
 * Represents a "rule" for the notification rules list. Each notification rule has a date pattern
 * (used to select times that the notification is active) and a boolean to indicate whether the
 * rule is enabled. It also has an ID so it can be uniquely identified. The methods themselves
 * should be mostly self-explanatory (just getter/setter type methods).
 */
@SuppressWarnings("unused")
public class NotificationRule {

    private int id = -1;
    private DatePattern datePattern = new SimpleDatePattern(new Date(), new Date());
    private boolean enabled = true;


    public NotificationRule(int id, DatePattern datePattern, boolean enabled) {
        this.id = id;
        this.datePattern = datePattern;
        this.enabled = enabled;
    }

    public NotificationRule(int id, DatePattern datePattern) {
        this(id, datePattern, true);
    }


    public void setDatePattern(DatePattern dp) {
        this.datePattern = dp;
    }

    public DatePattern getDatePattern() {
        return this.datePattern;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public int getId() {
        return this.id;
    }

}
