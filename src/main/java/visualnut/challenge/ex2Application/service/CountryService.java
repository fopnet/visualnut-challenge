package visualnut.challenge.ex2Application.service;

import java.util.List;

import visualnut.challenge.ex2Application.model.Country;

public interface CountryService {
    /**
     * returns the number of countries in the world
     * @return
     */
    List<Country> findAll();

    /**
     * finds the country with the most official languages, where they officially speak @lang.
     * @param lang
     * @return
     */
    Country findMostOfficialLanguage(String lang);

    /**
     * that counts all the official languages spoken in the listed countries
     * @return
     */
    Integer countsAllOfficialLanguagesSpoken();

    /**
     * to find the country with the highest number of official languages
     */
    Country findCountryHighestNumberOfficialLanguages();

    /**
     * to find the most common official language(s), of all countries.
     * @return
     */
    List<String> findTheMostCommonOfficialLanguageInTheWorld();

    /**
     * Return the amount of countries
     * @return
     */
    int count();

}
