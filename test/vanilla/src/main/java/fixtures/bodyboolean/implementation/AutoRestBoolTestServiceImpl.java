/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package fixtures.bodyboolean.implementation;

import com.microsoft.rest.v2.RestClient;
import com.microsoft.rest.v2.RestProxy;
import com.microsoft.rest.v2.RestResponse;
import com.microsoft.rest.v2.ServiceClient;
import fixtures.bodyboolean.AutoRestBoolTestService;
import fixtures.bodyboolean.Bools;
import rx.Single;

/**
 * Initializes a new instance of the AutoRestBoolTestService class.
 */
public class AutoRestBoolTestServiceImpl extends ServiceClient implements AutoRestBoolTestService {

    /**
     * The Bools object to access its operations.
     */
    private Bools bools;

    /**
     * Gets the Bools object to access its operations.
     * @return the Bools object.
     */
    public Bools bools() {
        return this.bools;
    }

    /**
     * Initializes an instance of AutoRestBoolTestService client.
     *
     * @param baseUrl the base URL of the host
     */
    public AutoRestBoolTestServiceImpl(String baseUrl) {
        super(baseUrl);
        initialize();
    }

    /**
     * Initializes an instance of AutoRestBoolTestService client.
     */
    public AutoRestBoolTestServiceImpl() {
        this("http://localhost");
        initialize();
    }

    /**
     * Initializes an instance of AutoRestBoolTestService client.
     *
     * @param restClient the REST client containing pre-configured settings
     */
    public AutoRestBoolTestServiceImpl(RestClient restClient) {
        super(restClient);
        initialize();
    }

    private void initialize() {
        this.bools = new BoolsImpl(this);
    }
}
