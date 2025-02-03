package com.enviro.assessment.grad001.thandekaradebe.wasteSorting;

import com.enviro.assessment.grad001.thandekaradebe.wasteSorting.model.RecyclingTips;
import com.enviro.assessment.grad001.thandekaradebe.wasteSorting.repository.RecyclingTipsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

class RecyclingTipsRepositoryTests{
    @Test
    void testConstructorAndGetters() {
        Long expectedId = 1L;
        String expectedTip = "Recycles plastic bottles separately";
        RecyclingTips recyclingTips = new RecyclingTips(expectedId,expectedTip);

        Assertions.assertThat(recyclingTips.getId()).isEqualTo(expectedId);
        Assertions.assertThat(recyclingTips.getTip()).isEqualTo(expectedTip);
    }

    @Test
    void testSetters() {
        RecyclingTips recyclingTips = new RecyclingTips(1L, "tip" );
        Long newId = 2L;
        String newTip = "Sort the waste";

        recyclingTips.setId(newId);
        recyclingTips.setTip(newTip);

        Assertions.assertThat(recyclingTips.getId()).isEqualTo(newId);
        Assertions.assertThat(recyclingTips.getTip()).isEqualTo(newTip);


    }
}
