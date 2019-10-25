# Учебное приложение

## Внимание
Для работы с проектом необходимо установить [Maven](https://maven.apache.org/download.cgi "Скачать Maven")

## Запуск
Чтобы запустить приложение перейдите в директорию проекта и в консоли выполните команду **mvn spring-boot:run**
Приложение будет доступно по адресу [localhost:8888](//localhost:8888 "Учебное приложение")

## API
 
###Организация

**id** - идентификатор организации;
**name** - краткое название организации;
**fullName** - полное название организации; 
**inn** - ИНН организации; 
**kpp** - КПП организации; 
**address** - адрес организации; 
**phone** - телефон организации; 
**isActive** - активность организации.

URL| Метод|Описание|Входные параметры|Выходные данные
---| ---- | ------ | --------------- | -------------- 
/api/organization/list|POST|Получить список организаций по фильтрам|**name (обязательный параметр)**; inn; isActive|[{"id":"", "name":"", "isActive":"true"}, ...]
/api/organization/{id}|GET|Получить организацию по идентификатору|-|{"id":"", "name":"", "fullName":"", "inn":"", "kpp":"", "address":"", "phone":"", "isActive":"true"}
/api/organization/update|POST|Обновить данные организации|**id (обязательный параметр); name (обязательный параметр); fullName (обязательный параметр); inn (обязательный параметр); kpp (обязательный параметр); address (обязательный параметр)**; phone; isActive|{"result":"success"}
/api/organization/save|POST|Добавить новую организацию|**name (обязательный параметр); fullName (обязательный параметр); inn (обязательный параметр); kpp (обязательный параметр); address (обязательный параметр)**; phone; isActive|{"result":"success"}

###Офис

**id** - идентификатор офиса;
**orgId** - идентификатор организации;
**name** - название офиса;
**address** - адрес офиса; 
**phone** - телефон офиса; 
**isActive** - активность офиса.

URL| Метод|Описание|Входные параметры|Выходные данные
---| ---- | ------ | --------------- | -------------- 
/api/office/list|POST|Получить список офисов по фильтрам|**orgId (обязательный параметр)**; name; phone; isActive|[{"id":"", "name":"", "isActive":"true"}, ...]
/api/office/{id}|GET|Получить офис по идентификатору|-|{"id":"", "name":"", "address":"", "phone":"", isActive":"true"}
/api/office/update|POST|Обновить данные офиса|**id (обязательный параметр); name (обязательный параметр); address (обязательный параметр)**; phone; isActive|{"result":"success"}
/api/office/save|POST|Добавить новый офис|**orgId (обязательный параметр)**; name; address; phone; isActive|{"result":"success"}

###Сотрудники

**id** - идентификатор сотрудника;
**officeId** - идентификатор офиса;
**firstName** - имя сотрудника;
**secondName (lastName)** - фамилия сотрудника;
**middleName** - отчество сотрудника;
**position** - должность сотрудника; 
**phone** - телефон сотрудника; 
**docCode** - идентификатор документа; 
**docName** - название документа; 
**docNumber** - код документа; 
**docDate** - дата документа; 
**citizenshipCode** - код гражданства; 
**citizenshipName** - гражданство; 
**isIdentified** - активность сотрудника.

URL| Метод|Описание|Входные параметры|Выходные данные
---| ---- | ------ | --------------- | -------------- 
/api/user/list|POST|Получить список сотрудников по фильтрам|**officeId (обязательный параметр)**; firstName; lastName; middleName; position; docCode; citizenshipCode|[{"id":"", "firstName":"", "secondName":"", "middleName":"", "position":""}, ...]
/api/user/{id}|GET|Получить сотрудника по идентификатору|-|{"id":"", "firstName":"", "secondName":"", "middleName":"", "position":"", "phone":"", "docName":"", "docNumber":"", "docDate":"", "citizenshipName":"", "citizenshipCode":"", "isIdentified":""}
/api/user/update|POST|Обновить данные сотрудника|**id (обязательный параметр); firstName (обязательный параметр); position (обязательный параметр)**; officeId; secondName; middleName; phone; docName; docNumber; docDate; citizenshipCode; isIdentified|{"result":"success"}
/api/user/save|POST|Добавить нового сотрудника|**officeId (обязательный параметр); firstName (обязательный параметр); position (обязательный параметр)**; secondName; middleName; phone; docCode; docName; docNumber; docDate; citizenshipCode; isIdentified|{"result":"success"}

###Справочники

URL| Метод|Описание|Входные параметры|Выходные данные
---| ---- | ------ | --------------- | -------------- 
/api/docs|GET|Получить список документов|-|[{"name":"Паспорт гражданина РФ", "code":"21"}, ...]
/api/countries|GET|Получить список гражданств|-|[{"name":"Российская Федерация", "code":"643"}, ...]