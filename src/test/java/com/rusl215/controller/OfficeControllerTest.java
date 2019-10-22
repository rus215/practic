package com.rusl215.controller;

import com.rusl215.controller.advice.exception.ExceptionHandling;
import com.rusl215.view.office.OfficeListFilterView;
import com.rusl215.view.office.OfficeSaveView;
import com.rusl215.view.office.OfficeView;
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
public class OfficeControllerTest {

    private static final String BASE_URL = "/api/office";
    private static final String EXPECT_OFFICE_LIST_JSON = "{\"data\":[{\"id\":\"1\",\"name\":\"ЦентрОфис\",\"isActive\":\"true\"},{\"id\":\"2\",\"name\":\"ВторойОфис\",\"isActive\":\"true\"}]}";
    private static final String EXPECT_OFFICE_JSON = "{\"data\":{\"id\":2,\"name\":\"ВторойОфис\",\"address\":\"ул. Цурюпы 34\",\"phone\":\"89874563542\",\"isActive\":true}}";
    private static final String SUCCESS_JSON = "{\"result\":\"success\"}";

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void positiveGetOfficeList() {
        OfficeListFilterView officeListFilterView = new OfficeListFilterView();
        officeListFilterView.orgId = 1L;
        String body = testRestTemplate.postForObject(BASE_URL + "/list", officeListFilterView, String.class);
        assertThat(body).isEqualTo(EXPECT_OFFICE_LIST_JSON);
    }

    @Test
    public void negativeGetOfficeList() {
        OfficeListFilterView officeListFilterView = new OfficeListFilterView();
        String body = testRestTemplate.postForObject(BASE_URL + "/list", officeListFilterView, String.class);
        assertThat(body).contains(ExceptionHandling.EXS_STR);
    }

    @Test
    public void positiveGetOfficeById() {
        int id = 2;
        String body = testRestTemplate.getForObject(BASE_URL + "/" + id, String.class);
        assertThat(body).isEqualTo(EXPECT_OFFICE_JSON);
    }

    @Test
    public void negativeGetOfficeById() {
        int id = 6;
        String body = testRestTemplate.getForObject(BASE_URL + "/" + id, String.class);
        assertThat(body).contains(ExceptionHandling.EXS_STR);
    }

    @Test
    @DirtiesContext
    public void positiveUpdateOffice() {
        OfficeView officeView = new OfficeView();
        officeView.id = 2L;
        officeView.name = "ГлаВОфис";
        officeView.address = "ул. Рабкорова 42";
        String result = testRestTemplate.postForObject(BASE_URL + "/update", officeView, String.class);
        assertThat(result).isEqualTo(SUCCESS_JSON);
    }

    @Test
    public void negativeUpdateOffice() {
        OfficeView officeView = new OfficeView();
        officeView.id = 2L;
        officeView.address = "ул. Рабкорова 42";
        String result = testRestTemplate.postForObject(BASE_URL + "/update", officeView, String.class);
        assertThat(result).contains(ExceptionHandling.EXS_STR);
    }

    @Test
    @DirtiesContext
    public void positiveSaveOffice() {
        OfficeSaveView officeSaveView = new OfficeSaveView();
        officeSaveView.orgId = 2L;
        officeSaveView.name = "SecOffice";
        officeSaveView.address = "ул. Московская 23";
        officeSaveView.phone = "89971234321";
        officeSaveView.isActive = true;
        String result = testRestTemplate.postForObject(BASE_URL + "/save", officeSaveView, String.class);
        assertThat(result).isEqualTo(SUCCESS_JSON);
    }

    @Test
    public void negativeSaveOffice() {
        OfficeSaveView officeSaveView = new OfficeSaveView();
        officeSaveView.name = "SecOffice";
        officeSaveView.address = "ул. Московская 23";
        officeSaveView.phone = "89971234321";
        officeSaveView.isActive = true;
        String result = testRestTemplate.postForObject(BASE_URL + "/save", officeSaveView, String.class);
        assertThat(result).contains(ExceptionHandling.EXS_STR);
    }
}