package springpetserver.bo.response;

import springpetserver.bo.response.component.ErrorResponse;

/**
 * Created by Zhuinden on 2015.04.30..
 */
public class Response<T> {
    private T payload;
    private ErrorResponse error;

    @Deprecated
    public Response() {

    }

    @SuppressWarnings("deprecation")
    public static <T> Response<T> createOKResponse(T payload) {
        Response<T> response = new Response<>();
        response.setPayload(payload);
        return response;
    }

    @SuppressWarnings("deprecation")
    public static Response<?> createErrorResponse(ErrorResponse errorResponse) {
        Response<?> response = new Response<>();
        response.setError(errorResponse);
        return response;
    }

    @SuppressWarnings("deprecation")
    public static Response<?> createErrorResponse(Throwable throwable) {
        Response<?> response = new Response<>();
        response.setError(new ErrorResponse(throwable));
        return response;
    }



    public Object getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }
}
