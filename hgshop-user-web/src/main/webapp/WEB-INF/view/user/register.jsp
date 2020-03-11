<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.6">
    <title></title>

   
    <!-- Bootstrap core CSS -->
<link href="/resource/bootstrap4/css/bootstrap.css" rel="stylesheet" >

    <!-- Favicons -->
<link rel="apple-touch-icon" href="https://v4.bootcss.com/docs/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="https://v4.bootcss.com/docs/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="https://v4.bootcss.com/docs/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="https://v4.bootcss.com/docs/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="https://v4.bootcss.com/docs/assets/img/favicons/safari-pinned-tab.svg" color="#563d7c">
<link rel="icon" href="https://v4.bootcss.com/docs/assets/img/favicons/favicon.ico">
<meta name="msapplication-config" content="/docs/assets/img/favicons/browserconfig.xml">
<meta name="theme-color" content="#563d7c">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="/resource/css/signin.css" rel="stylesheet">
  </head>
  <body class="text-center">
    <form class="form-signin" action="/user/register" method="post">
  
  <h1 class="h3 mb-3 font-weight-normal">请输入您的注册数据</h1>
  
  <label for="inputEmail" class="sr-only">用户名</label>
  <input type="text"  name="username" id="inputEmail" class="form-control" placeholder="用户名" >
  
  <label for="inputPassword" class="sr-only">密码</label>
  <input type="password" id="inputPassword" name="password" class="form-control" placeholder="密码" >
  
  <label for="inputPassword" class="sr-only">真实姓名</label>
  <input type="text" id="inputPassword" name="name" class="form-control" placeholder="真实姓名" >
  
  
  <label for="inputPassword" class="sr-only">电话</label>
  <input type="text" id="inputPassword" name="telephone" class="form-control" placeholder="电话" >
  
  
  <label for="inputPassword" class="sr-only">邮箱</label>
  <input type="text" id="inputPassword" name="email" class="form-control" placeholder="邮箱" >
  
  <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
  <p class="mt-5 mb-3 text-muted">© 2017-2020</p>
</form>


</body></html>