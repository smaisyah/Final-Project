<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>[Tugas 4] Muhammad Raihan Alfirzie</title>
    <style>
        body {
            margin: 20px;
            border: 1px solid black;
            padding: 20px;
            background-color: #fff;
        }
        .container {
            background-color: #ccc;
            padding: 10px;
            border-radius: 4px;
        }
        .button {
            display: inline-block;
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border-radius: 4px;
            text-decoration: none;
        }
        .container .bg-green {
            background-color: #00b894;
            padding: 10px;
            border-radius: 4px;
        }
    </style>
</head>
<body>
    <h1>[Tugas 4] Muhammad Raihan Alfirzie</h1>
    <h2>Sending Email using Spring Boot with FreeMaker Template</h2><br>
    <p>Dear Fuad Zein,</p>
    <p>Saya menggunakan Mimemessage dengan menggunakan template dari freemaker untuk mengirimkan email ini. Semoga email ini bisa diterima dengan baik.</p>
    <div class="container">
        <table>
            <tr>
                <td>Nama:</td>
                <td>${Name}</td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>${email}</td>
            </tr>
        </table>
        <p>Terima kasih.</p>
        <div class="bg-green">
            <p>
                <a href="https://www.google.com/maps?q=${location}" class="button">Kunjungi Jakarta Selatan</a>
            </p>
        </div>
    </div>
</body>
</html>