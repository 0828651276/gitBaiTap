
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>About Us - BatinQueenShop</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f4f4f4;
    }

    header {
      background-color: #333;
      padding: 10px;
      text-align: center;
    }

    header nav a {
      color: #fff;
      text-decoration: none;
      margin: 0 15px;
    }

    .about-section {
      padding: 50px;
      background-color: #fff;
      text-align: center;
    }

    .about-content {
      display: flex;
      justify-content: center;
      align-items: center;
      gap: 20px;
    }

    .about-text {
      max-width: 600px;
      text-align: left;
    }

    .about-text h2, .about-text h3 {
      margin-bottom: 10px;
      color: #333;
    }

    .about-text p {
      line-height: 1.6;
      color: #555;
    }

    .about-image img {
      width: 300px;
      height: auto;
      border-radius: 50%;
    }

    footer {
      background-color: #333;
      color: #fff;
      text-align: center;
      padding: 10px;
      position: fixed;
      bottom: 0;
      width: 100%;
    }
  </style>
</head>
<body>
<header>
  <nav>
    <a href="index.jsp">Home</a>
    <a href="#">Shop</a>
    <a href="about.jsp">About Us</a>
  </nav>
</header>

<section class="about-section">
  <h1>About BatinQueenShop</h1>
  <div class="about-content">
    <div class="about-text">
      <h2>Our Story</h2>
      <p>BatinQueenShop was founded with the passion for roller skating, bringing the joy of skating to everyone. We specialize in providing high-quality roller skates and accessories for all ages and skill levels.</p>
      <p>Our mission is to make skating accessible, fun, and safe for everyone. Whether you're a beginner or a seasoned skater, we've got the perfect pair of skates for you!</p>

      <h3>Founder: Hung Ech</h3>
      <p> Hung Ech is an avid skater with over 10 years of experience in the roller skating community. Her passion for skating and dedication to quality have driven the success of QueenShop.</p>
    </div>
    <div class="about-image">
      <img src="/anh%20me.jpg" alt="Hung Ech - Founder" />
    </div>
  </div>
</section>

<footer>
  <p>&copy; 2024 QueenShop. All rights reserved.</p>
</footer>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>
