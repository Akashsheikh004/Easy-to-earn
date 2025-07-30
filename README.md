<!DOCTYPE html>
<html>
<head>
  <title>Easy to Earn</title>
  <meta charset="UTF-8" />
  <style>
    body {
      font-family: Arial, sans-serif;
      padding: 20px;
      background: #f0f8ff;
    }
    h2 {
      color: #0066cc;
    }
    input, button {
      padding: 8px;
      margin: 5px 0;
      width: 100%;
      max-width: 300px;
    }
    .profile {
      margin-top: 20px;
      background: #fff;
      padding: 15px;
      border-radius: 10px;
      box-shadow: 0 0 5px rgba(0,0,0,0.1);
      max-width: 350px;
    }
  </style>
</head>
<body>

  <h2>👤 একাউন্ট খুলুন</h2>

  <input type="text" id="name" placeholder="আপনার নাম লিখুন" required />
  <input type="text" id="mobile" placeholder="মোবাইল নাম্বার লিখুন" required />
  <input type="text" id="referral" placeholder="ইনভাইট কোড লিখুন" />
  <input type="password" id="password" placeholder="পাসওয়ার্ড দিন" required />
  <button onclick="register()">✅ একাউন্ট তৈরি করুন</button>

  <div class="profile" id="profile" style="display:none;">
    <h3>📄 প্রোফাইল:</h3>
    <p><strong>নাম:</strong> <span id="p_name"></span></p>
    <p><strong>মোবাইল:</strong> <span id="p_mobile"></span></p>
    <p><strong>ইনভাইট কোড:</strong> <span id="p_referral"></span></p>
    <p><strong>ব্যালান্স:</strong> <span id="p_balance"></span> টাকা</p>
  </div>

  <script>
    function register() {
      const name = document.getElementById("name").value.trim();
      const mobile = document.getElementById("mobile").value.trim();
      const referral = document.getElementById("referral").value.trim();
      const password = document.getElementById("password").value;

      if (!name || !mobile || !password) {
        alert("নাম, মোবাইল ও পাসওয়ার্ড দিন");
        return;
      }

      const user = {
        name,
        mobile,
        referral,
        password,  // ভবিষ্যতে লগইনের কাজে লাগবে
        balance: 20
      };

      localStorage.setItem("easy_user", JSON.stringify(user));
      showProfile();
    }

    function showProfile() {
      const data = localStorage.getItem("easy_user");
      if (data) {
        const user = JSON.parse(data);
        document.getElementById("p_name").textContent = user.name;
        document.getElementById("p_mobile").textContent = user.mobile;
        document.getElementById("p_referral").textContent = user.referral;
        document.getElementById("p_balance").textContent = user.balance;
        document.getElementById("profile").style.display = "block";
      }
    }

    showProfile();
  </script>

</body>
</html>
