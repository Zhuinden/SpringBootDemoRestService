package springpetserver.bo.response;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import springpetserver.bo.response.component.ErrorResponse;

import java.util.HashMap;
import java.util.Map;

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

    @SuppressWarnings("deprecation")
    public static Response<?> createErrorResponse(BindingResult bindingResult) {
        Response<?> response = new Response<>();
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(ErrorResponse.ErrorCodes.BAD_REQUEST.getCode());
        errorResponse.setErrorMessage("Validation error.");

        Map<String, String> errorsInFields = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorsInFields.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        errorResponse.setOptionalData(errorsInFields);
        response.setError(errorResponse);
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
