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
    <h2>New User</h2>
    <form name="user" action="signUp" method="POST">
        <table border="0" cellpadding="5">
            <tr>
                <td>First name: </td>
                <td><@spring.formInput "user.firstName" "" "text"/></td>
            </tr>
            <tr>
                <td>Last name: </td>
                <td><@spring.formInput "user.lastName" "" "text"/></td>
            </tr>
            <tr>
                <td>Username: </td>
                <td><@spring.formInput "user.username" "" "text"/></td>
            </tr>
            <tr>
                <td>Phone number: </td>
                <td><@spring.formInput "user.phoneNumber" "" "tel"/></td>
            </tr>
            <tr>
                <td>E-mail: </td>
                <td><@spring.formInput "user.email" "" "email"/></td>
            </tr>
            ${(usernameError)!}
            <tr>
                <td>Password: </td>
                <td><@spring.formPasswordInput "user.password" ""/></td>
            </tr>
            <tr>
                <td>Confirm your password: </td>
                <td><@spring.formPasswordInput "user.passwordConfirm" ""/></td>
            </tr>
            ${(passwordError)!}
            <tr>
                <td colspan="2"><input type="submit" value="Create"></td>
                <td colspan="2"><input type="reset" value="Reset"></td>
                <td colspan="2"><input type="button" onclick="location.href='/';" value="Main" /></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>