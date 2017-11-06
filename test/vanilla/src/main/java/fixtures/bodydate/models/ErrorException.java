/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package fixtures.bodydate.models;

import com.microsoft.rest.v2.RestException;
import com.microsoft.rest.v2.http.HttpResponse;

/**
 * Exception thrown for an invalid response with Error information.
 */
public class ErrorException extends RestException {
    /**
     * Initializes a new instance of the ErrorException class.
     *
     * @param message the exception message or the response content if a message is not available
     * @param response the HTTP response
     */
    public ErrorException(final String message, HttpResponse response) {
        super(message, response);
    }

    /**
     * Initializes a new instance of the ErrorException class.
     *
     * @param message the exception message or the response content if a message is not available
     * @param response the HTTP response
     * @param body the deserialized response body
     */
    public ErrorException(final String message, final HttpResponse response, final Error body) {
        super(message, response, body);
    }

    @Override
    public Error body() {
        return (Error) super.body();
    }
}
