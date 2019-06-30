<#-- @ftlvariable name="" type="views.HelloView" -->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>Welcome!</title>
</head>
<body>
<h1>Welcome ${name}!</h1>

<script>
    function wrapper(url, data, success, args) {
        args = $.extend({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url: url,
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            async: true,
            success: success
        }, args);
        return $.ajax(args);
    };
</script>

<form method="POST" action="/person/please" onsubmit="return wrapper('/person/please', data, function(result) {
        console.log('result', result);
    });">
    <input type="submit" value="Submit" />
</form>

</body>
</html>