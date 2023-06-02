<#import "/spring.ftl" as spring/>

<html lang="">
<head>
    <title>Main</title>
    <style>
        body {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%)
        }
    </style>
</head>
<body>
<div align="center">
    <h2><@spring.message "main"/></h2>
    <input type="button" style="width: 150px; height: 50px;" onclick="location.href='?lang=en';" value=<@spring.message "lang.eng"/> />
    <input type="button" style="width: 150px; height: 50px;" onclick="location.href='?lang=ru';" value=<@spring.message "lang.ru"/> />
    <input type="button" style="width: 150px; height: 50px;" onclick="location.href='session/search';" value=<@spring.message "cinema"/> />
    <input type="button" style="width: 150px; height: 50px;" onclick="location.href='profile';" value=<@spring.message "profile"/> />
    <input type="button" style="width: 150px; height: 50px;" onclick="location.href='signIn';" value="<@spring.message "login"/>" />
    <input type="button" style="width: 150px; height: 50px;" onclick="location.href='signUp';" value="<@spring.message "signup"/>" />
</div>
</body>
</html>