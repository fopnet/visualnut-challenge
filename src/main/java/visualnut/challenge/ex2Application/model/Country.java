package visualnut.challenge.ex2Application.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = { "country" })
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    private String country;
    private List<String> languages;
}
