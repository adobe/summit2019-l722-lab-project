/*
 *  Copyright 2018 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.adobe.summit.twentynineteen.lab722.core.servlets;

import org.apache.sling.testing.mock.sling.junit.SlingContext;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import javax.script.Bindings;
import javax.script.SimpleBindings;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.assertEquals;

public class NotFoundResponseStatusTest {

    @Rule
    public final SlingContext context = new SlingContext();

    private Bindings bindings;

    @Before
    public void setup() {
        bindings = new SimpleBindings();
        bindings.put("response", context.response());
        bindings.put("request", context.request());
    }

    @Test
    public void testActivate() {
        NotFoundResponseStatus fixture = new NotFoundResponseStatus();
        fixture.init(bindings);

        assertEquals("text/html", context.response().getContentType());
        assertEquals(HttpServletResponse.SC_NOT_FOUND, context.response().getStatus());

    }

    @Test
    public void testResponseText() {
        context.request().setPathInfo("/some/missing/page.html");
        context.request().setMethod("GET");

        NotFoundResponseStatus fixture = new NotFoundResponseStatus();
        fixture.init(bindings);

        assertEquals("Could not find /some/missing/page.html for request method GET.", fixture.getResponseText());
    }
}
