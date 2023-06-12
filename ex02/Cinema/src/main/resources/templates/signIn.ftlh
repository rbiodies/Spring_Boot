<#import "/spring.ftl" as spring/>

<html lang="">
<head>
    <title>User Form</title>
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
    <h2><@spring.message "userform"/></h2>
    <div class="alert alert-success" role="alert">
        <p style="color:green">${(verifiedAccountMsg)!}</p>
    </div>
    <div class="alert alert-danger" role="alert">
        <p style="color:red">${(tokenError)!}</p>
    </div>
    <form action="/signIn" method="POST">
        <table>
            <tr>
                <td><@spring.message "email"/>:</td>
                <td><@spring.formInput "user.email" "" "text"/></td>
            </tr>
            <tr>
                <td><@spring.message "password"/>:</td>
                <td><@spring.formPasswordInput "user.password" ""/></td>
            </tr>
            <tr>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </tr>
            <tr>
                <td><@spring.message "rememberme"/>:</td>
                <td><label>
                        <input type="checkbox" name="remember-me" />
                    </label></td>
            </tr>
        </table>
        <input type="submit" value=<@spring.message "submit"/> />
        <input type="reset" value=<@spring.message "reset"/> />
        <input type="button" onclick="location.href='/signUp';" value="<@spring.message "signup"/>" />
    </form>
</div>
</body>
</html>