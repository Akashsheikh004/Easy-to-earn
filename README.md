<!DOCTYPE html>
<html lang="bn">
<head>
  <meta charset="UTF-8">
  <title>হোম - Easy to Earn</title>
  <style>
    body {
      margin: 0;
      font-family: Arial, sans-serif;
      background: url('https://images.unsplash.com/photo-1570129477492-45c003edd2be?auto=format&fit=crop&w=1350&q=80');
      background-size: cover;
      background-position: center;
      color: white;
    }

    .container {
      max-width: 400px;
      margin: 60px auto;
      padding: 25px;
      background-color: rgba(0, 0, 0, 0.7);
      border-radius: 15px;
      text-align: center;
    }

    button {
      width: 100%;
      padding: 15px;
      margin: 10px 0;
      font-size: 18px;
      font-weight: bold;
      border: none;
      border-radius: 8px;
      cursor: pointer;
    }

    .recharge { background-color: #28a745; }
    .withdraw { background-color: #ff9800; }
    .support { background-color: #2196f3; }
    .reward { background-color: #9c27b0; }

    .balance {
      margin-top: 20px;
      font-size: 20px;
    }
  </style>
</head>
<body>
  <div class="container">
    <h2>🏠 হোম</h2>

    <button class="recharge" onclick="alert('রিচার্জ ফর্ম আসবে')">💳 টাকা রিচার্জ</button>
    <button class="withdraw" onclick="alert('উত্তোলন ফর্ম আসবে')">🏧 উত্তোলন</button>
    <button class="support" onclick="alert('গ্রাহক সেবার তথ্য আসবে')">📞 গ্রাহক সেবা</button>

    <div class="balance">💰 একাউন্ট ব্যালেন্স: <span id="balance">0</span> টাকা</div>

    <button class="reward" onclick="collectReward()">🎁 লগ ইন পুরস্কার</button>
  </div>

  <script>
    function getUser() {
      return JSON.parse(localStorage.getItem("easy_user")) || { balance: 0 };
    }

    function setUser(user) {
      localStorage.setItem("easy_user", JSON.stringify(user));
    }

    function updateBalanceDisplay() {
      const user = getUser();
      document.getElementById("balance").textContent = user.balance;
    }

    function collectReward() {
      const now = new Date();
      const last = localStorage.getItem("last_reward_time");

      if (last && (now - new Date(last)) < 24 * 60 * 60 * 1000) {
        alert("⚠️ ২৪ ঘন্টার আগে আবার নেওয়া যাবে না!");
        return;
      }

      let user = getUser();
      user.balance += 10;
      setUser(user);
      localStorage.setItem("last_reward_time", now.toString());
      updateBalanceDisplay();
      alert("🎉 ১০ টাকা যোগ হয়েছে!");
    }

    updateBalanceDisplay();
  </script>
</body>
</html>
