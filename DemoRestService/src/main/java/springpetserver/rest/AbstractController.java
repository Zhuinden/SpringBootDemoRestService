package springpetserver.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import springpetserver.bo.response.Response;
import springpetserver.exception.ValidBindingException;

/**
 * Created by Zhuinden on 2015.04.30..
 */
public abstract class AbstractController {

    protected abstract Logger getLogger();

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Response handleException(Exception e) {
        getLogger().error("Exception occurred", e);
        return Response.createErrorResponse(e);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response handleValidBindingException(ValidBindingException e) {
        getLogger().error("Validation error occurred", e);
        return Response.createErrorResponse(e.getBindingResult());
    }
}
