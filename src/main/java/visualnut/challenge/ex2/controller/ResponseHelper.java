package visualnut.challenge.ex2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseHelper {
    public <T> ResponseEntity<T> ok(T t) {
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    public <T> ResponseEntity<T> okOrNotFound(T t) {
        if (null == t) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ok(t);
        }
    }

}
