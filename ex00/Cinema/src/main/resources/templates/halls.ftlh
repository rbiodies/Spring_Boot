<html lang="">
<head>
    <title>Hall Manager</title>
</head>
<body>
<div align="center">
    <h2>Hall Manager</h2>
    <form method="get" action="search">
        <label>
            <input type="text" name="keyword" />
        </label>
        <input type="submit" value="Search" />
    </form>
    <h3><a href="new">New Hall</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Serial number</th>
            <th>Number of seats</th>
            <th>Action</th>
        </tr>
        <#list halls as hall>
            <tr>
                <td>${hall.id}</td>
                <td>${hall.serialNumber}</td>
                <td>${hall.numberOfSeats}</td>
                <td>
                    <a href="/admin/panel/halls/edit?id=${hall.id}">Edit</a>

                    <a href="/admin/panel/halls/delete?id=${hall.id}">Delete</a>
                </td>
            </tr>
        </#list>
    </table>
    <input type="button" style="width: 150px; height: 50px;" onclick="location.href='/admin/panel';" value="Panel" />
</div>
</body>
</html>