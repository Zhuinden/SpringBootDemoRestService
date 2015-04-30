package springpetserver.bo.response.component;

import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * Created by Zhuinden on 2015.04.30..
 */
public class ErrorResponse {
    public static enum ErrorCodes {
        UNKNOWN(-1),
        INTERNAL_SERVER_ERROR(500);

        private int code;

        private ErrorCodes(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public static ErrorCodes findByCode(int code) {
            for(ErrorCodes errorCode : ErrorCodes.values()) {
                if(errorCode.getCode() == code) {
                    return errorCode;
                }
            }
            return UNKNOWN;
        }
    }

    private int errorCode;
    private String errorMessage;
    private String rootCauseMessage;

    public ErrorResponse() {

    }

    public ErrorResponse(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ErrorResponse(Throwable exception) {
        this.errorCode = ErrorCodes.INTERNAL_SERVER_ERROR.getCode();
        rootCauseMessage = ExceptionUtils.getRootCauseMessage(exception);
        errorMessage = ExceptionUtils.getMessage(exception);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
