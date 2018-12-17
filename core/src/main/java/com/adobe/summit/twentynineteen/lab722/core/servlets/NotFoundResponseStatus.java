/*
 *  Copyright 2015 Adobe Systems Incorporated
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

import com.adobe.cq.sightly.WCMUsePojo;

/**
 * This class is responsible for handling the status for a not found request.
 */
public class NotFoundResponseStatus extends WCMUsePojo {
    
    @Override
    public void activate() throws Exception {
        getResponse().setStatus(404);
        getResponse().setContentType("text/html");
    }

    public String getResponseText() {
        // uncomment this line and comment out the line below to get rid of the security violation
        // return String.format("Could not find %s for request method %s.", getRequest().getPathInfo(), getRequest().getMethod());
        return String.format("Could not find " + getRequest().getPathInfo() + " for request method %s.", getRequest().getMethod());
    }

}