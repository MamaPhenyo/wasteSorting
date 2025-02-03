package com.enviro.assessment.grad001.thandekaradebe.wasteSorting;

import com.enviro.assessment.grad001.thandekaradebe.wasteSorting.model.WasteCategory;
import com.enviro.assessment.grad001.thandekaradebe.wasteSorting.repository.WasteCategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class WasteRepositoryTests {

    @Test
    void testConstructorAndGetters() {
        Long expectedId = 1L;
        String expectedName = "Paper";
        WasteCategory wasteCategory = new WasteCategory(expectedId, expectedName);

        Assertions.assertThat((Long) wasteCategory.getId()).isEqualTo(expectedId);
        Assertions.assertThat(wasteCategory.getName()).isEqualTo(expectedName);
    }

    @Test
    void testSetters() {
        WasteCategory wasteCategory = new WasteCategory(1L, "Plastic");
        Long newId = 2L;
        String newName = "Glass";
        wasteCategory.setId(newId);
        wasteCategory.setName(newName);

        Assertions.assertThat((Long) wasteCategory.getId()).isEqualTo(newId);
        Assertions.assertThat(wasteCategory.getName()).isEqualTo(newName);
    }
}