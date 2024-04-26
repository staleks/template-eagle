package rs.in.staleksit.eagle.template.domain.geo;

import com.github.javafaker.Faker;

public class CountryTestData {

    private static Faker faker = Faker.instance();

    public static Country createRandom() {
        return Country.create(
                faker.name().username(),
                faker.country().name(),
                faker.country().countryCode2(),
                faker.country().countryCode3()
        );
    }

    public static Country createItaly() {
        return Country.create(
                faker.name().username(),
                "Italy",
                "IT",
                "ITA"
        );
    }

    public static Country createNonVisible(final String name,
                                           final String alpha2,
                                           final String alpha3) {
        Country country = new Country();
        country.setCreatedBy(faker.name().username());
        country.setName(name);
        country.setAlpha2(alpha2);
        country.setAlpha3(alpha3);

        country.toggleVisibility();
        return country;
    }

    public static Country createDeleted(final String name,
                                        final String alpha2,
                                        final String alpha3) {
        Country country = new Country();
        country.setCreatedBy(faker.name().username());
        country.setName(name);
        country.setAlpha2(alpha2);
        country.setAlpha3(alpha3);
        country.setDeleted(true);
        return country;
    }

    public static Country randomPersisted() {
        Country country = new Country();
        country.setId(faker.number().randomNumber());
        country.setCreatedBy(faker.name().username());
        country.setName(faker.country().name());
        country.setAlpha2(faker.country().countryCode2());
        country.setAlpha3(faker.country().countryCode3());
        return country;
    }

    public static Country randomPersistedUpdated() {
        Country country = new Country();
        country.setId(faker.number().randomNumber());
        country.setCreatedBy(faker.name().username());
        country.setName(faker.country().name());
        country.setAlpha2(faker.country().countryCode2());
        country.setAlpha3(faker.country().countryCode3());

        country.update(country.getId(),
                faker.name().username(),
                country.getName(),
                country.getAlpha2(),
                country.getAlpha3(),
                country.isVisible(),
                country.isDeleted());

        return country;
    }

}
