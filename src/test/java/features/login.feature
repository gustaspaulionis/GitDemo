Feature: Login into Application

Scenario Outline: Positive test validating login
Given Initialize the browser
And Navigate to the "http://qaclickacademy.com/"
And Click on the Login button
When Enter <username> and <password> and click Login button
And Close browsers

Examples:
|username			|password	|
|test99@gmail.com	|123456		|
|test123@gmail.co	|12345		|