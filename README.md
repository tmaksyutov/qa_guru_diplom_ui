# <img width="4%" title="Allure TestOPS" src="images/logo/hh_logo.svg"> Проект по автоматизации тестирования сайта hh.ru

##	Содержание

- [Технологии и инструменты](#technologist-технологии-и-инструменты)
- [Реализованыe проверки](#bookmark_tabs-реализованные-проверки)
- [Запуск тестов из терминала](#computer-запуск-тестов-из-терминала)
- [Запуск тестов в Jenkins](#-запуск-тестов-в-jenkins)
- [Отчет о результатах тестирования в Allure Report](#-отчет-о-результатах-тестирования-в-Allure-report)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)
- [Пример запуска теста в Selenoid](#-пример-запуска-теста-в-selenoid)


## :technologist: Технологии и инструменты

<p  align="center">

<code><img width="5%" title="IntelliJ IDEA" src="images/logo/Idea.svg"></code>
<code><img width="5%" title="Java" src="images/logo/Java.svg"></code>
<code><img width="5%" title="Selenoid" src="images/logo/Selenoid.svg"></code>
<code><img width="5%" title="Selenide" src="images/logo/Selenide.svg"></code>
<code><img width="5%" title="Gradle" src="images/logo/Gradle.svg"></code>
<code><img width="5%" title="Junit5" src="images/logo/Junit5.svg"></code>
<code><img width="5%" title="GitHub" src="images/logo/GitHub.svg"></code>
<code><img width="5%" title="Allure Report" src="images/logo/Allure.svg"></code>
<code><img width="5%" title="Allure TestOps" src="images/logo/Allure_TO.svg"></code>
<code><img width="5%" title="Jenkins" src="images/logo/Jenkins_logo.svg"></code>
<code><img width="5%" title="Jira" src="images/logo/Jira.svg"></code>
<code><img width="5%" title="Telegram" src="images/logo/Telegram.svg"></code>
</p>


## :bookmark_tabs: Реализованные проверки:

- Успешная авторизация с помощью пароля
- Проверка сообщения об ошибке при авторизации c невалидными данными 
- Проверка названия главной страницы 
- Проверка ошибок в Console 
- Выбор страны поиска вакансий 
- Проверка списка стран и городов 
- Поиск вакансий


## :computer: Запуск тестов из терминала

### Локальный запуск тестов

```bash
gradle clean test
```

### Удаленный запуск тестов

```bash
gradle clean test

-Dremote=${SELENOID_URL}
-Dbrowser=${BROWSER}
-DbrowserSize=${BROWSER_SIZE}
-DbrowserVersion=${BROWSER_VERSION}
```

## Параметры сборки

 <code>remote</code> – логин, пароль и адрес удаленного сервера Selenoid (_по умолчанию указаны в сборке Jenkins_).

 <code>browser</code> – браузер, в котором будут выполняться тесты (_по умолчанию - <code>chrome</code>_).

 <code>browserSize</code> – размер окна браузера, в котором будут выполняться тесты (_по умолчанию - <code>1920x1080</code>_).

 <code>browserVersion</code> – версия браузера (_по умолчанию - <code>106</code>_).




## <img width="4%" title="Jenkins" src="images/logo/Jenkins_logo.svg"> Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/tmaksyutov_diplom_ui/)

Для запуска сборки необходимо указать значения параметров и нажать кнопку <code><strong>*Собрать*</strong></code>.

<p align="center">
  <img src="images/jenkins.png" alt="Jenkins" width="800">
</p>

После выполнения сборки, в блоке <code><strong>*История сборок*</strong></code> напротив номера сборки появится
значок *Allure Report*, кликнув по которому, откроется страница с сформированным html-отчетом.

<p align="center">
  <img src="images/allure-report.png" alt="allure-report" width="800">
</p>


## <img width="4%" title="Allure Report" src="images/logo/Allure.svg"> Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/tmaksyutov_diplom_ui/33/allure/)

<p align="center">
  <img src="images/allure-report1.png" alt="allure-report1" width="900">
</p>



## <img width="4%" title="Allure TestOPS" src="images/logo/Allure_TO.svg"> Интеграция с [Allure TestOps](https://allure.autotests.cloud/launch/17965)

### Основной дашборд

<p align="center">
  <img src="images/dashboard.png" alt="dashboard" width="900">
</p>

### Список тестов с результатами прогона

<p align="center">
  <img src="images/three.png" alt="dashboard" width="900">
</p>
 
### Тест-кейсы 

<p align="center">
  <img src="images/testcase.png" alt="testcase" width="900">
</p>

## <img width="4%" title="Jira" src="images/logo/Jira.svg"> Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-483)

<p align="center">
  <img src="images/jira.png" alt="jira" width="900">
</p>

## <img width="4%" title="Telegram" src="images/logo/Telegram.svg"> Уведомления в Telegram с использованием бота
После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.

<p align="center">
<img title="Telegram Notifications" src="images/telegram.png">
</p>

## <img width="4%" title="Selenoid" src="images/logo/Selenoid.svg"> Пример запуска теста в Selenoid

К каждому тесту в отчете прилагается видео.

На данном видео выполняется:

- Проверка сообщения об ошибке при авторизации c невалидными данными


<p align="center">
  <img title="Selenoid Video" src="images/gif/test1.gif">
</p>