package com.rusl215.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HandbookControllerTest {

    private static final String EXPECT_COUNTRY_JSON = "{\"data\":[{\"name\":\"Канада\",\"code\":\"124\"},{\"name\":\"Германия\",\"code\":\"276\"},{\"name\":\"Российская Федерация\",\"code\":\"643\"}]}";
    private static final String EXPECT_DOC_JSON = "{\"data\":[{\"name\":\"Свидетельство о рождении\",\"code\":\"3\"},{\"name\":\"Паспорт иностранного гражданина\",\"code\":\"10\"},{\"name\":\"Паспорт гражданина РФ\",\"code\":\"21\"}]}";

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getAllCountries() {
        String body = testRestTemplate.getForObject("/api/countries", String.class);
        assertThat(body).isEqualTo(EXPECT_COUNTRY_JSON);
    }

    @Test
    public void getAllDocs() {
        String body = testRestTemplate.getForObject("/api/docs", String.class);
        assertThat(body).isEqualTo(EXPECT_DOC_JSON);
    }
}