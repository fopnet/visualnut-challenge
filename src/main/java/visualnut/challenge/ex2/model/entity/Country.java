package visualnut.challenge.ex2.model.entity;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = { "country" })
@ToString
public class Country {
    private String country;
    private List<String> languages;
}
