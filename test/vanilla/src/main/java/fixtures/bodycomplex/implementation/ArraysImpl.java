/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package fixtures.bodycomplex.implementation;

import com.microsoft.rest.v2.RestProxy;
import com.microsoft.rest.v2.RestResponse;
import fixtures.bodycomplex.Arrays;
import com.google.common.reflect.TypeToken;
import com.microsoft.rest.v2.annotations.BodyParam;
import com.microsoft.rest.v2.annotations.ExpectedResponses;
import com.microsoft.rest.v2.annotations.GET;
import com.microsoft.rest.v2.annotations.Headers;
import com.microsoft.rest.v2.annotations.Host;
import com.microsoft.rest.v2.annotations.PUT;
import com.microsoft.rest.v2.annotations.UnexpectedResponseExceptionType;
import com.microsoft.rest.v2.http.HttpClient;
import com.microsoft.rest.v2.ServiceCallback;
import com.microsoft.rest.v2.ServiceFuture;
import com.microsoft.rest.v2.Validator;
import fixtures.bodycomplex.models.ArrayWrapper;
import fixtures.bodycomplex.models.ErrorException;
import java.io.IOException;
import rx.functions.Func1;
import rx.Observable;
import rx.Single;

/**
 * An instance of this class provides access to all the operations defined
 * in Arrays.
 */
public class ArraysImpl implements Arrays {
    /** The RestProxy service to perform REST calls. */
    private ArraysService service;
    /** The service client containing this operation class. */
    private AutoRestComplexTestServiceImpl client;

    /**
     * Initializes an instance of Arrays.
     *
     * @param client the instance of the service client containing this operation class.
     */
    public ArraysImpl(AutoRestComplexTestServiceImpl client) {
        this.service = RestProxy.create(ArraysService.class, client.restClient().baseURL(), client.httpClient(), client.serializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for Arrays to be
     * used by RestProxy to perform REST calls.
    */
    @Host("http://localhost")
    interface ArraysService {
        @Headers({ "x-ms-logging-context: fixtures.bodycomplex.Arrays getValid" })
        @GET("complex/array/valid")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorException.class)
        Single<RestResponse<Void, ArrayWrapper>> getValid();

        @Headers({ "x-ms-logging-context: fixtures.bodycomplex.Arrays putValid" })
        @PUT("complex/array/valid")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorException.class)
        Single<RestResponse<Void, Void>> putValid(@BodyParam("application/json; charset=utf-8") ArrayWrapper complexBody);

        @Headers({ "x-ms-logging-context: fixtures.bodycomplex.Arrays getEmpty" })
        @GET("complex/array/empty")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorException.class)
        Single<RestResponse<Void, ArrayWrapper>> getEmpty();

        @Headers({ "x-ms-logging-context: fixtures.bodycomplex.Arrays putEmpty" })
        @PUT("complex/array/empty")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorException.class)
        Single<RestResponse<Void, Void>> putEmpty(@BodyParam("application/json; charset=utf-8") ArrayWrapper complexBody);

        @Headers({ "x-ms-logging-context: fixtures.bodycomplex.Arrays getNotProvided" })
        @GET("complex/array/notprovided")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorException.class)
        Single<RestResponse<Void, ArrayWrapper>> getNotProvided();

    }

    /**
     * Get complex types with array property.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the ArrayWrapper object if successful.
     */
    public ArrayWrapper getValid() {
        return getValidAsync().toBlocking().value();
    }

    /**
     * Get complex types with array property.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<ArrayWrapper> getValidAsync(ServiceCallback<ArrayWrapper> serviceCallback) {
        return ServiceFuture.fromBody(getValidAsync(), serviceCallback);
    }

    /**
     * Get complex types with array property.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return a {@link Single} emitting the RestResponse<Void, ArrayWrapper> object
     */
    public Single<RestResponse<Void, ArrayWrapper>> getValidWithRestResponseAsync() {
        return service.getValid();
    }

    /**
     * Get complex types with array property.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return a {@link Single} emitting the RestResponse<Void, ArrayWrapper> object
     */
    public Single<ArrayWrapper> getValidAsync() {
        return getValidWithRestResponseAsync()
            .map(new Func1<RestResponse<Void, ArrayWrapper>, ArrayWrapper>() { public ArrayWrapper call(RestResponse<Void, ArrayWrapper> restResponse) { return restResponse.body(); } });
        }


    /**
     * Put complex types with array property.
     *
     * @param complexBody Please put an array with 4 items: "1, 2, 3, 4", "", null, "&amp;S#$(*Y", "The quick brown fox jumps over the lazy dog"
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the void object if successful.
     */
    public void putValid(ArrayWrapper complexBody) {
        putValidAsync(complexBody).toBlocking().value();
    }

    /**
     * Put complex types with array property.
     *
     * @param complexBody Please put an array with 4 items: "1, 2, 3, 4", "", null, "&amp;S#$(*Y", "The quick brown fox jumps over the lazy dog"
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<Void> putValidAsync(ArrayWrapper complexBody, ServiceCallback<Void> serviceCallback) {
        return ServiceFuture.fromBody(putValidAsync(complexBody), serviceCallback);
    }

    /**
     * Put complex types with array property.
     *
     * @param complexBody Please put an array with 4 items: "1, 2, 3, 4", "", null, "&amp;S#$(*Y", "The quick brown fox jumps over the lazy dog"
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return a {@link Single} emitting the RestResponse<Void, Void> object
     */
    public Single<RestResponse<Void, Void>> putValidWithRestResponseAsync(ArrayWrapper complexBody) {
        if (complexBody == null) {
            throw new IllegalArgumentException("Parameter complexBody is required and cannot be null.");
        }
        Validator.validate(complexBody);
        return service.putValid(complexBody);
    }

    /**
     * Put complex types with array property.
     *
     * @param complexBody Please put an array with 4 items: "1, 2, 3, 4", "", null, "&amp;S#$(*Y", "The quick brown fox jumps over the lazy dog"
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return a {@link Single} emitting the RestResponse<Void, Void> object
     */
    public Single<Void> putValidAsync(ArrayWrapper complexBody) {
        return putValidWithRestResponseAsync(complexBody)
            .map(new Func1<RestResponse<Void, Void>, Void>() { public Void call(RestResponse<Void, Void> restResponse) { return restResponse.body(); } });
        }


    /**
     * Get complex types with array property which is empty.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the ArrayWrapper object if successful.
     */
    public ArrayWrapper getEmpty() {
        return getEmptyAsync().toBlocking().value();
    }

    /**
     * Get complex types with array property which is empty.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<ArrayWrapper> getEmptyAsync(ServiceCallback<ArrayWrapper> serviceCallback) {
        return ServiceFuture.fromBody(getEmptyAsync(), serviceCallback);
    }

    /**
     * Get complex types with array property which is empty.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return a {@link Single} emitting the RestResponse<Void, ArrayWrapper> object
     */
    public Single<RestResponse<Void, ArrayWrapper>> getEmptyWithRestResponseAsync() {
        return service.getEmpty();
    }

    /**
     * Get complex types with array property which is empty.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return a {@link Single} emitting the RestResponse<Void, ArrayWrapper> object
     */
    public Single<ArrayWrapper> getEmptyAsync() {
        return getEmptyWithRestResponseAsync()
            .map(new Func1<RestResponse<Void, ArrayWrapper>, ArrayWrapper>() { public ArrayWrapper call(RestResponse<Void, ArrayWrapper> restResponse) { return restResponse.body(); } });
        }


    /**
     * Put complex types with array property which is empty.
     *
     * @param complexBody Please put an empty array
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the void object if successful.
     */
    public void putEmpty(ArrayWrapper complexBody) {
        putEmptyAsync(complexBody).toBlocking().value();
    }

    /**
     * Put complex types with array property which is empty.
     *
     * @param complexBody Please put an empty array
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<Void> putEmptyAsync(ArrayWrapper complexBody, ServiceCallback<Void> serviceCallback) {
        return ServiceFuture.fromBody(putEmptyAsync(complexBody), serviceCallback);
    }

    /**
     * Put complex types with array property which is empty.
     *
     * @param complexBody Please put an empty array
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return a {@link Single} emitting the RestResponse<Void, Void> object
     */
    public Single<RestResponse<Void, Void>> putEmptyWithRestResponseAsync(ArrayWrapper complexBody) {
        if (complexBody == null) {
            throw new IllegalArgumentException("Parameter complexBody is required and cannot be null.");
        }
        Validator.validate(complexBody);
        return service.putEmpty(complexBody);
    }

    /**
     * Put complex types with array property which is empty.
     *
     * @param complexBody Please put an empty array
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return a {@link Single} emitting the RestResponse<Void, Void> object
     */
    public Single<Void> putEmptyAsync(ArrayWrapper complexBody) {
        return putEmptyWithRestResponseAsync(complexBody)
            .map(new Func1<RestResponse<Void, Void>, Void>() { public Void call(RestResponse<Void, Void> restResponse) { return restResponse.body(); } });
        }


    /**
     * Get complex types with array property while server doesn't provide a response payload.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the ArrayWrapper object if successful.
     */
    public ArrayWrapper getNotProvided() {
        return getNotProvidedAsync().toBlocking().value();
    }

    /**
     * Get complex types with array property while server doesn't provide a response payload.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<ArrayWrapper> getNotProvidedAsync(ServiceCallback<ArrayWrapper> serviceCallback) {
        return ServiceFuture.fromBody(getNotProvidedAsync(), serviceCallback);
    }

    /**
     * Get complex types with array property while server doesn't provide a response payload.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return a {@link Single} emitting the RestResponse<Void, ArrayWrapper> object
     */
    public Single<RestResponse<Void, ArrayWrapper>> getNotProvidedWithRestResponseAsync() {
        return service.getNotProvided();
    }

    /**
     * Get complex types with array property while server doesn't provide a response payload.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return a {@link Single} emitting the RestResponse<Void, ArrayWrapper> object
     */
    public Single<ArrayWrapper> getNotProvidedAsync() {
        return getNotProvidedWithRestResponseAsync()
            .map(new Func1<RestResponse<Void, ArrayWrapper>, ArrayWrapper>() { public ArrayWrapper call(RestResponse<Void, ArrayWrapper> restResponse) { return restResponse.body(); } });
        }


}
