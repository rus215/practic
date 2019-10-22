package com.rusl215.controller;

import com.rusl215.controller.advice.exception.ExceptionHandling;
import com.rusl215.view.organization.OrganizationListFilterView;
import com.rusl215.view.organization.OrganizationSaveView;
import com.rusl215.view.organization.OrganizationView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class OrganizationControllerTest {

    private static final String BASE_URL = "/api/organization";
    private static final String EXPECT_ORGANIZATION_JSON = "{\"data\":{\"id\":1,\"name\":\"IT\",\"fullName\":\"ООО IT\",\"inn\":\"1234905319\",\"kpp\":\"123463893\",\"address\":\"ул. Цурюпы 6\",\"phone\":\"83479875643\",\"isActive\":true}}";
    private static final String EXPECT_ORGANIZATION_LIST_JSON = "{\"data\":[{\"id\":\"1\",\"name\":\"IT\",\"isActive\":\"true\"}]}";
    private static final String SUCCESS_JSON = "{\"result\":\"success\"}";

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void positiveGetOrganizationList() {
        OrganizationListFilterView organizationListFilterView = new OrganizationListFilterView();
        organizationListFilterView.name = "IT";
        String body = testRestTemplate.postForObject(BASE_URL + "/list", organizationListFilterView, String.class);
        assertThat(body).isEqualTo(EXPECT_ORGANIZATION_LIST_JSON);
    }

    @Test
    public void negativeGetOrganizationList() {
        OrganizationListFilterView organizationListFilterView = new OrganizationListFilterView();
        String body = testRestTemplate.postForObject(BASE_URL + "/list", organizationListFilterView, String.class);
        assertThat(body).contains(ExceptionHandling.EXS_STR);
    }

    @Test
    public void positiveGetOrganizationById() {
        int id = 1;
        String body = testRestTemplate.getForObject(BASE_URL + "/" + id, String.class);
        assertThat(body).isEqualTo(EXPECT_ORGANIZATION_JSON);
    }

    @Test
    public void negativeGetOrganizationById() {
        int id = 4;
        String body = testRestTemplate.getForObject(BASE_URL + "/" + id, String.class);
        assertThat(body).contains(ExceptionHandling.EXS_STR);
    }

    @Test
    @DirtiesContext
    public void positiveUpdateOrganization() {
        OrganizationView organizationView = new OrganizationView();
        organizationView.id = 1L;
        organizationView.name = "DSL";
        organizationView.fullName = "DSL Techno base";
        organizationView.inn = "1234565";
        organizationView.kpp = "12345675";
        organizationView.address = "ул. Аксакова 13";
        String result = testRestTemplate.postForObject(BASE_URL + "/update", organizationView, String.class);
        assertThat(result).isEqualTo(SUCCESS_JSON);
    }

    @Test
    public void negativeUpdateOrganization() {
        OrganizationView organizationView = new OrganizationView();
        organizationView.name = "DSL";
        organizationView.fullName = "DSL Techno base";
        organizationView.inn = "1234565";
        organizationView.kpp = "12345675";
        organizationView.address = "ул. Аксакова 13";
        String result = testRestTemplate.postForObject(BASE_URL + "/update", organizationView, String.class);
        assertThat(result).contains(ExceptionHandling.EXS_STR);
    }

    @Test
    @DirtiesContext
    public void positiveSaveOrganization() {
        OrganizationSaveView organizationSaveView = new OrganizationSaveView();
        organizationSaveView.name = "BELL Time";
        organizationSaveView.fullName = "BELL Time inc";
        organizationSaveView.inn = "3214564321";
        organizationSaveView.kpp = "3214532456";
        organizationSaveView.address = "ул. Гагарина 10";
        String result = testRestTemplate.postForObject(BASE_URL + "/save", organizationSaveView, String.class);
        assertThat(result).isEqualTo(SUCCESS_JSON);
    }

    @Test
    public void negativeSaveOrganization() {
        OrganizationSaveView organizationSaveView = new OrganizationSaveView();
        organizationSaveView.fullName = "BELL Time inc";
        organizationSaveView.inn = "3214564321";
        organizationSaveView.kpp = "3214532456";
        organizationSaveView.address = "ул. Гагарина 10";
        String result = testRestTemplate.postForObject(BASE_URL + "/save", organizationSaveView, String.class);
        assertThat(result).contains(ExceptionHandling.EXS_STR);
    }
}