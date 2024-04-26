package rs.in.staleksit.eagle.template.domain.geo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CountryTest {

    @Test
    void testConstructorDefinition() {
        var country = new Country();

        assertNotNull(country);
        assertTrue(country.isVisible());
        assertFalse(country.isDeleted());
    }

    @Test
    void testToggleVisibility() {
        var country = new Country();

        country.toggleVisibility();

        assertFalse(country.isVisible());
    }

    @Test
    void testDelete() {
        var country = new Country();

        country.setDeleted(true);

        assertTrue(country.isDeleted());
    }

    @Test
    void testCreate() {
        var country = Country.create("john.doe@test.com", "Italy", "IT", "ITA");

        assertNotNull(country);
        assertEquals("Italy", country.getName());
        assertEquals("john.doe@test.com", country.getCreatedBy());
        assertNotNull(country.getCreatedDate());
        assertTrue(country.isVisible());
        assertFalse(country.isDeleted());
    }

    @Test
    void testUpdate() {
        var country = Country.create("john.doe@test.com", "Italy", "IT", "ITA");
        country.update(1, "jahne.doe@test.com", "Italy", "IT", "ITA", true, false);

        assertNotNull(country);
        assertEquals("Italy", country.getName());
        assertEquals("john.doe@test.com", country.getCreatedBy());
        assertNotNull(country.getCreatedDate());
        assertTrue(country.isVisible());
        assertFalse(country.isDeleted());

        assertEquals("jahne.doe@test.com", country.getLastModifiedBy());
        assertNotNull(country.getLastModifiedDate());

        assertTrue(country.getCreatedDate().isBefore(country.getLastModifiedDate()));
    }

}
