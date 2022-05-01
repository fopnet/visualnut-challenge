package visualnut.challenge.ex2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RestHelper {
    private static final ResponseEntity NO_CONTENT_RESPONSE_ENTITY = new ResponseEntity(HttpStatus.NO_CONTENT);
    private static final ResponseEntity NOT_FOUND_RESPONSE_ENTITY = new ResponseEntity(HttpStatus.NOT_FOUND);

    public <T> ResponseEntity<T> ok(T t) {
        return new ResponseEntity(t, HttpStatus.OK);
    }

    public <T> ResponseEntity<T> okOrNotFound(T t) {
        if (null == t) {
            return NOT_FOUND_RESPONSE_ENTITY;
        } else {
            return ok(t);
        }
    }

}
