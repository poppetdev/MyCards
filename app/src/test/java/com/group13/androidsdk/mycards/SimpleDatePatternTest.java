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

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Unit tester for <code>SimpleDatePattern</code>
 */
public class SimpleDatePatternTest {
    @Test
    public void dateMatchesTest() {
        SimpleDatePattern dp = new SimpleDatePattern(new Date(10000), new Date(15000), 0, 0);

        assertTrue("Must match startDate", dp.dateMatches(new Date(10000)));
        assertTrue("Must match endDate", dp.dateMatches(new Date(15000)));
        assertTrue("Must match date in middle of first range", dp.dateMatches(new Date(12500)));

        assertFalse("Must not match before startDate", dp.dateMatches(new Date(9999)));
        assertFalse("Must not match after endDate", dp.dateMatches(new Date(15001)));


        dp = new SimpleDatePattern(new Date(10000), new Date(15000), 10000, 5);

        assertTrue("Must match startDate", dp.dateMatches(new Date(10000)));
        assertTrue("Must match endDate", dp.dateMatches(new Date(15000)));
        assertTrue("Must match date in middle of first range", dp.dateMatches(new Date(12500)));

        assertTrue("Must match startDate of middle range", dp.dateMatches(new Date(20000)));
        assertTrue("Must match endDate of middle range", dp.dateMatches(new Date(25000)));
        assertTrue("Must match date in middle of middle range", dp.dateMatches(new Date(22500)));

        assertTrue("Must match startDate of final range", dp.dateMatches(new Date(60000)));
        assertTrue("Must match endDate of final range", dp.dateMatches(new Date(65000)));
        assertTrue("Must match date in middle of final range", dp.dateMatches(new Date(62500)));

        assertFalse("Must not match before startDate", dp.dateMatches(new Date(9999)));
        assertFalse("Must not match between ranges", dp.dateMatches(new Date(15001)));
        assertFalse("Must not match between ranges", dp.dateMatches(new Date(19999)));

        assertFalse("Must not match after final range", dp.dateMatches(new Date(65001)));
        assertFalse("Must not match after final range", dp.dateMatches(new Date(70000)));
        assertFalse("Must not match after final range", dp.dateMatches(new Date(72500)));
        assertFalse("Must not match after final range", dp.dateMatches(new Date(75000)));

        assertFalse("Must not match null", dp.dateMatches(null));
    }


    @Test
    public void nextMatchTest() {
        SimpleDatePattern dp = new SimpleDatePattern(new Date(10000), new Date(15000), 0, 0);

        assertEquals("Must return start on input before start", new Date(10000), dp.nextMatch(new Date(100)));
        assertNull("Must return null on input after end", dp.nextMatch(new Date(15001)));

        assertEquals("Must return input on input that matches", new Date(10000), dp.nextMatch(new Date(10000)));
        assertEquals("Must return input on input that matches", new Date(12500), dp.nextMatch(new Date(12500)));
        assertEquals("Must return input on input that matches", new Date(15000), dp.nextMatch(new Date(15000)));


        dp = new SimpleDatePattern(new Date(10000), new Date(15000), 10000, 5);

        assertEquals("Must return start on input before start", new Date(10000), dp.nextMatch(new Date(100)));
        assertEquals("Must return next match on input between intervals", new Date(20000), dp.nextMatch(new Date(15001)));
        assertNull("Must return null on input after end", dp.nextMatch(new Date(65001)));

        assertEquals("Must return input on input that matches", new Date(10000), dp.nextMatch(new Date(10000)));
        assertEquals("Must return input on input that matches", new Date(12500), dp.nextMatch(new Date(12500)));
        assertEquals("Must return input on input that matches", new Date(15000), dp.nextMatch(new Date(15000)));

        assertEquals("Must return input on input that matches", new Date(30000), dp.nextMatch(new Date(30000)));
        assertEquals("Must return input on input that matches", new Date(32500), dp.nextMatch(new Date(32500)));
        assertEquals("Must return input on input that matches", new Date(35000), dp.nextMatch(new Date(35000)));
    }
}