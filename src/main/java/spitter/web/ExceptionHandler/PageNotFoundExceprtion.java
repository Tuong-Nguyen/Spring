package spitter.web.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by nttao on 5/25/2017.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Page not found")
public class PageNotFoundExceprtion extends RuntimeException {
}
