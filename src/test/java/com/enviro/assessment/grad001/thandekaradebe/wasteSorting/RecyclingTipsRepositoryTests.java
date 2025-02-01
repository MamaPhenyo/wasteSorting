package com.enviro.assessment.grad001.thandekaradebe.wasteSorting;

import com.enviro.assessment.grad001.thandekaradebe.wasteSorting.model.RecyclingTips;
import com.enviro.assessment.grad001.thandekaradebe.wasteSorting.repository.RecyclingTipsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class RecyclingTipsRepositoryTests {

    @Autowired
    private RecyclingTipsRepository repository;

    @Test
    public void RecyclingTipsRepository_testSave_ReturnNotNull() {
        RecyclingTips recyclingTips = RecyclingTips.builder()
                .tip("Recycling Tip")
                .build();
        RecyclingTips savedRecyclingTips = repository.save(recyclingTips);

        Assertions.assertThat(savedRecyclingTips).isNotNull();
        Assertions.assertThat(savedRecyclingTips.getId()).isNotNull();
    }
}
