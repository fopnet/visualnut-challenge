package visualnut.challenge.ex2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RestHelper {

    public <T> ResponseEntity<T> ok(T t) {
        return new ResponseEntity(t, HttpStatus.OK);
    }

}
