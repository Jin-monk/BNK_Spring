<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>문화재 목록</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ccc; padding: 8px; }
        th { background-color: #f0f0f0; }
    </style>
</head>
<body>

<h2>경남 문화재 목록</h2>

<table id="culturalTable">
    <thead>
        <tr>
            <th>이름</th>
            <th>시대</th>
            <th>주소</th>
        </tr>
    </thead>
    <tbody></tbody>
</table>

<script>
    // JSP에서 전달받은 JSON 문자열을 안전하게 출력

    const raw = `${fn:escapeXml(jsonData)}`;
    console.log("raw jsonData:", raw);
    const data = JSON.parse(raw);
    const items = data.gyeongnamculturallist.body.items.item;

    const tbody = document.querySelector("#culturalTable tbody");

    let html = "";
    items.forEach(item => {
        html += `
            <tr>
                <td>${item.MYONGCHING}</td>
                <td>${item.SIDAE}</td>
                <td>${item.ADDRESS1}</td>
            </tr>
        `;
    });

    tbody.innerHTML = html;
</script>

</body>
</html>
