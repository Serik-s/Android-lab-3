package com.example.serik.lab3;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
/**
 * Created by Serik on 10.10.17.
 */

public class ResponseConverterFactory extends Converter.Factory {

    private ResponseConverterFactory() {
        // Private constructor.
    }

    public static ResponseConverterFactory create() {
        return new ResponseConverterFactory();
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type,
                                                            Annotation[] annotations,
                                                            Retrofit retrofit) {

        Type rpcType = Types.newParameterizedType(BaseResponse.class, type);
        Converter<ResponseBody, BaseResponse> delegate =
                retrofit.nextResponseBodyConverter(this, rpcType, annotations);
        //noinspection unchecked
        return new ResponseBodyConverter(delegate);
    }

    private static class ResponseBodyConverter<T> implements Converter<ResponseBody, T> {
        final Converter<ResponseBody, BaseResponse<T>> delegate;


        ResponseBodyConverter(Converter<ResponseBody, BaseResponse<T>> delegate) {
            this.delegate = delegate;
        }

        @Override
        public T convert(ResponseBody responseBody) throws IOException {
            BaseResponse<T> response = delegate.convert(responseBody);

            if (response.getError()!=null && response.getError())
                throw new BaseResponseException(response.getMessage());

            return response.getData();

        }
    }


}
