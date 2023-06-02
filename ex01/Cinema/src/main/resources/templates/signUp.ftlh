<#import "/spring.ftl" as spring/>

<html lang="">
<head>
    <title>New User</title>
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
    <h2><@spring.message "newuser"/></h2>
    <input type="button" style="width: 150px; height: 50px;" onclick="location.href='?lang=en';" value=<@spring.message "lang.eng"/> />
    <input type="button" style="width: 150px; height: 50px;" onclick="location.href='?lang=ru';" value=<@spring.message "lang.ru"/> />
    <form name="user" action="signUp" method="POST">
        <table border="0" cellpadding="5">
            <tr>
                <td><@spring.message "firstname"/>: </td>
                <td><@spring.formInput "user.firstName" "" "text"/></td>
            </tr>
            <tr>
                <td><@spring.message "lastname"/>: </td>
                <td><@spring.formInput "user.lastName" "" "text"/></td>
            </tr>
            <tr>
                <td><@spring.message "username"/>: </td>
                <td><@spring.formInput "user.username" "" "text"/></td>
            </tr>
            <tr>
                <td><@spring.message "phonenumber"/>: </td>
                <td><@spring.formInput "user.phoneNumber" "" "tel"/></td>
            </tr>
            <tr>
                <td><@spring.message "email"/>: </td>
                <td><@spring.formInput "user.email" "" "email"/></td>
            </tr>
            ${(usernameError)!}
            <tr>
                <td><@spring.message "password"/>: </td>
                <td><@spring.formPasswordInput "user.password" ""/></td>
            </tr>
            <tr>
                <td><@spring.message "confirmyourpassword"/>: </td>
                <td><@spring.formPasswordInput "user.passwordConfirm" ""/></td>
            </tr>
            ${(passwordError)!}
            <tr>
                <td colspan="2"><input type="submit" value=<@spring.message "create"/>></td>
                <td colspan="2"><input type="reset" value=<@spring.message "reset"/>></td>
                <td colspan="2"><input type="button" onclick="location.href='/';" value=<@spring.message "main"/> /></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>