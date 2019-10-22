package com.rusl215.controller;

import com.rusl215.controller.advice.exception.ExceptionHandling;
import com.rusl215.view.user.UserListFilterView;
import com.rusl215.view.user.UserSaveView;
import com.rusl215.view.user.UserUpdateView;
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
public class UserControllerTest {

    private static final String BASE_URL = "/api/user";
    private static final String EXPECT_USER_LIST_JSON = "{\"data\":[{\"id\":\"1\",\"firstName\":\"Денис\",\"secondName\":\"Подлинов\",\"middleName\":\"Алексеевич\",\"position\":\"менеджер по проектам\"},{\"id\":\"2\",\"firstName\":\"Иван\",\"secondName\":\"Сухоруков\",\"middleName\":\"Андреевич\",\"position\":\"аналитик\"},{\"id\":\"3\",\"firstName\":\"Денис\",\"secondName\":\"Подлинов\",\"middleName\":\"Алексеевич\",\"position\":\"менеджер по проектам\"}]}";
    private static final String EXPECT_USER_JSON = "{\"data\":{\"id\":\"1\",\"firstName\":\"Денис\",\"secondName\":\"Подлинов\",\"middleName\":\"Алексеевич\",\"position\":\"менеджер по проектам\",\"phone\":\"89177754322\",\"docName\":\"Паспорт гражданина РФ\",\"docNumber\":\"8012694822\",\"docDate\":\"1992-04-21\",\"citizenshipName\":\"Российская Федерация\",\"citizenshipCode\":\"643\",\"isIdentified\":\"true\"}}";
    private static final String SUCCESS_JSON = "{\"result\":\"success\"}";

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void positiveGetUserList() {
        UserListFilterView userListFilterView = new UserListFilterView();
        userListFilterView.officeId = 1L;

        String body = testRestTemplate.postForObject(BASE_URL + "/list", userListFilterView, String.class);
        assertThat(body).isEqualTo(EXPECT_USER_LIST_JSON);
    }

    @Test
    public void negativeGetUserList() {
        UserListFilterView userListFilterView = new UserListFilterView();

        String body = testRestTemplate.postForObject(BASE_URL + "/list", userListFilterView, String.class);
        assertThat(body).contains(ExceptionHandling.EXS_STR);
    }

    @Test
    public void positiveGetUserById() {
        int id = 1;
        String body = testRestTemplate.getForObject(BASE_URL + "/" + id, String.class);
        assertThat(body).isEqualTo(EXPECT_USER_JSON);
    }

    @Test
    public void negativeGetUserById() {
        int id = 10;
        String body = testRestTemplate.getForObject(BASE_URL + "/" + id, String.class);
        assertThat(body).contains(ExceptionHandling.EXS_STR);
    }

    @Test
    @DirtiesContext
    public void positiveUpdateUser() {
        UserUpdateView userUpdateView = new UserUpdateView();
        userUpdateView.id = 2L;
        userUpdateView.firstName = "Максим";
        userUpdateView.position = "UX дизайнер";

        String result = testRestTemplate.postForObject(BASE_URL + "/update", userUpdateView, String.class);
        assertThat(result).isEqualTo(SUCCESS_JSON);
    }

    @Test
    public void negativeUpdateUser() {
        UserUpdateView userUpdateView = new UserUpdateView();
        userUpdateView.id = 2L;
        userUpdateView.firstName = "Максим";

        String result = testRestTemplate.postForObject(BASE_URL + "/update", userUpdateView, String.class);
        assertThat(result).contains(ExceptionHandling.EXS_STR);
    }

    @Test
    @DirtiesContext
    public void positiveSaveUser() {
        UserSaveView userSaveView = new UserSaveView();
        userSaveView.officeId = 2L;
        userSaveView.firstName = "Артур";
        userSaveView.position = "UI дизайнер";

        String result = testRestTemplate.postForObject(BASE_URL + "/save", userSaveView, String.class);
        assertThat(result).isEqualTo(SUCCESS_JSON);
    }

    @Test
    public void negativeSaveUser() {
        UserSaveView userSaveView = new UserSaveView();
        userSaveView.firstName = "Артур";
        userSaveView.position = "UI дизайнер";

        String result = testRestTemplate.postForObject(BASE_URL + "/save", userSaveView, String.class);
        assertThat(result).contains(ExceptionHandling.EXS_STR);
    }
}