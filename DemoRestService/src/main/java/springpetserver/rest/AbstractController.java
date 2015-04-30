package springpetserver.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import springpetserver.bo.response.Response;

/**
 * Created by Zhuinden on 2015.04.30..
 */
public abstract class AbstractController {
    private final static Logger logger = LoggerFactory.getLogger(AbstractController.class);

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Response handleException(Exception e) {
        logger.error("Exception occurred", e);
        return Response.createErrorResponse(e);
    }
}
