<!DOCTYPE html>
<html lang="bn">
<head>
  <meta charset="UTF-8">
  <title>Easy to Earn</title>
  <style>
    body {
      margin: 0;
      font-family: Arial, sans-serif;
      background-image: url('https://images.unsplash.com/photo-1504384308090-c894fdcc538d');
      background-size: cover;
      background-position: center;
      min-height: 100vh;
      color: #fff;
    }

    .container {
      background: rgba(0, 0, 0, 0.7);
      max-width: 400px;
      margin: 50px auto;
      padding: 30px;
      border-radius: 10px;
    }

    h2 {
      text-align: center;
      color: #00ffcc;
    }

    input, button {
      width: 100%;
      padding: 10px;
      margin: 10px 0;
      border: none;
      border-radius: 5px;
    }

    button {
      background-color: #00cc99;
      color: #fff;
      font-weight: bold;
      cursor: pointer;
    }

    .link {
      text-align: center;
      margin-top: 10px;
    }

    .link a {
      color: #66ffff;
      text-decoration: underline;
      cursor: pointer;
    }
  </style>
</head>
<body>

  <div class="container" id="registerPage">
    <h2>👤 রেজিস্ট্রেশন</h2>
    <input type="text" id="reg_name" placeholder="আপনার নাম" required>
    <input type="text" id="reg_mobile" placeholder="মোবাইল নাম্বার" required>
    <input type="text" id="reg_ref" placeholder="রেফার কোড (ঐচ্ছিক)">
    <input type="password" id="reg_pass" placeholder="পাসওয়ার্ড দিন" required>
    <button onclick="register()">✅ একাউন্ট তৈরি করুন</button>
    <div class="link">একাউন্ট আছে? <a onclick="showLogin()">লগইন করুন</a></div>
  </div>

  <div class="container" id="loginPage" style="display:none;">
    <h2>🔐 লগইন</h2>
    <input type="text" id="log_mobile" placeholder="মোবাইল নাম্বার" required>
    <input type="password" id="log_pass" placeholder="পাসওয়ার্ড দিন" required>
    <button onclick="login()">লগইন করুন</button>
    <div class="link">নতুন একাউন্ট? <a onclick="showRegister()">রেজিস্টার করুন</a></div>
  </div>

  <div class="container" id="profilePage" style="display:none;">
    <h2>🎉 প্রোফাইল</h2>
    <p><strong>নাম:</strong> <span id="p_name"></span></p>
    <p><strong>মোবাইল:</strong> <span id="p_mobile"></span></p>
    <p><strong>রেফার:</strong> <span id="p_ref"></span></p>
    <p><strong>ব্যালান্স:</strong> <span id="p_bal"></span> টাকা</p>
  </div>

  <script>
    function register() {
      const name = document.getElementById("reg_name").value.trim();
      const mobile = document.getElementById("reg_mobile").value.trim();
      const ref = document.getElementById("reg_ref").value.trim();
      const pass = document.getElementById("reg_pass").value;

      if (!name || !mobile || !pass) {
        alert("সব ঘর পূরণ করুন!");
        return;
      }

      const user = { name, mobile, ref, pass, balance: 20 };
      localStorage.setItem("easy_user", JSON.stringify(user));
      showProfile(user);
    }

    function login() {
      const mobile = document.getElementById("log_mobile").value.trim();
      const pass = document.getElementById("log_pass").value;

      const data = localStorage.getItem("easy_user");
      if (!data) {
        alert("কোনো একাউন্ট পাওয়া যায়নি!");
        return;
      }

      const user = JSON.parse(data);
      if (user.mobile === mobile && user.pass === pass) {
        showProfile(user);
      } else {
        alert("ভুল মোবাইল নাম্বার বা পাসওয়ার্ড!");
      }
    }

    function showProfile(user) {
      document.getElementById("p_name").textContent = user.name;
      document.getElementById("p_mobile").textContent = user.mobile;
      document.getElementById("p_ref").textContent = user.ref;
      document.getElementById("p_bal").textContent = user.balance;

      document.getElementById("registerPage").style.display = "none";
      document.getElementById("loginPage").style.display = "none";
      document.getElementById("profilePage").style.display = "block";
    }

    function showLogin() {
      document.getElementById("registerPage").style.display = "none";
      document.getElementById("loginPage").style.display = "block";
    }

    function showRegister() {
      document.getElementById("loginPage").style.display = "none";
      document.getElementById("registerPage").style.display = "block";
    }

    // অটো চেক
    const savedUser = localStorage.getItem("easy_user");
    if (savedUser) {
      showLogin();  // আগেই একাউন্ট থাকলে Login দেখাবে
    }
  </script>

</body>
</html>
