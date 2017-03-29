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
 * A basic implementation of the <code>DatePattern</code> interface, using a simple pattern of
 * start and end dates. Any dates between the start and end dates are considered matches, and all
 * others are not matches.
 */
class SimpleDatePattern implements DatePattern {

    private Date start;
    private Date end;

    public SimpleDatePattern(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean dateMatches(Date d) {
        return d != null && start != null && end != null && d.after(start) && d.before(end);
    }
}
