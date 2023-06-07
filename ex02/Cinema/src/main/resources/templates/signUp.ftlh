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
<#--    <h2><@spring.message "newuser"/></h2>-->
    <input type="button" style="width: 150px; height: 50px;" onclick="location.href='?lang=en';" value=<@spring.message "lang.eng"/> />
    <input type="button" style="width: 150px; height: 50px;" onclick="location.href='?lang=ru';" value=<@spring.message "lang.ru"/> />
    <form name="user" action="signUp" method="POST">
        <table border="0" cellpadding="5">
            <tr>
                <td><@spring.message "firstname"/>: </td>
                <td><@spring.formInput "user.firstName" "" "text"/></td>
                <td style="color: red"><@spring.showErrors "<br>" /><td>
            </tr>
            <tr>
                <td><@spring.message "lastname"/>: </td>
                <td><@spring.formInput "user.lastName" "" "text"/></td>
                <td style="color: red"><@spring.showErrors "<br>" /><td>
            </tr>
            <tr>
                <td><@spring.message "username"/>: </td>
                <td><@spring.formInput "user.username" "" "text"/></td>
                <td style="color: red"><@spring.showErrors "<br>"/><td>
            </tr>
            <tr>
                <td><@spring.message "phonenumber"/>: </td>
                <td><@spring.formInput "user.phoneNumber" "" "tel"/></td>
                <td style="color: red"><@spring.showErrors "<br>"/><td>
            </tr>
            <tr>
                <td><@spring.message "email"/>: </td>
                <td><@spring.formInput "user.email" "" "email"/></td>
                <td style="color: red"><@spring.showErrors "<br>"/><td>
            </tr>
<#--            ${(usernameError)!}-->
            <tr>
                <td><@spring.message "password"/>: </td>
                <td><@spring.formPasswordInput "user.password" ""/></td>
                <td style="color: red"><@spring.showErrors "<br>"/><td>
            </tr>
            <tr>
                <td><@spring.message "confirmyourpassword"/>: </td>
                <td><@spring.formPasswordInput "user.passwordConfirm" ""/></td>
                <td style="color: red"><@spring.showErrors "<br>"/><td>
            </tr>
<#--            ${(passwordError)!}-->
            <tr>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </tr>
<#--            <tr>-->
<#--                <td colspan="2"><input type="submit" value="<@spring.message "signup"/>"></td>-->
<#--                <td colspan="2"><input type="reset" value=<@spring.message "reset"/>></td>-->
<#--                <td colspan="2"><input type="button" onclick="location.href='/';" value=<@spring.message "main"/> /></td>-->
<#--            </tr>-->
        </table>
        <input type="submit" style="width: 150px; height: 50px;" value="<@spring.message "signup"/>">
    </form>
</div>
</body>
</html>