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
    <h2>User Form</h2>
    <form action="/signIn" method="POST">
        <table>
            <tr>
                <td>Email:</td>
                <td><@spring.formInput "user.email" "" "text"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><@spring.formPasswordInput "user.password" ""/></td>
            </tr>
            <tr>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </tr>
            <tr>
                <td>Remember Me:</td>
                <td><label>
                        <input type="checkbox" name="remember-me" />
                    </label></td>
            </tr>
        </table>
        <input type="submit" value="Submit" />
        <input type="reset" value="Reset" />
        <input type="button" onclick="location.href='signUp';" value="Sign up" />
    </form>
</div>
</body>
</html>