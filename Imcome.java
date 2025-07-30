let balance = 2000;
let vipList = [];

function updateBalanceDisplay() {
  document.getElementById("balance").innerText = "৳" + balance.toFixed(2);
}

function buyVip(id, cost, hourlyIncome) {
  if (balance >= cost) {
    balance -= cost;
    updateBalanceDisplay();

    const name = id === "vip1" ? "VIP-1" : "VIP-2";
    vipList.push({ name, hourlyIncome });

    const li = document.createElement("li");
    li.innerText = name + " চলছে... প্রতি ঘন্টায় ৳" + hourlyIncome + " ইনকাম হবে।";
    document.getElementById("vipList").appendChild(li);

    setInterval(() => {
      balance += hourlyIncome;
      updateBalanceDisplay();
    }, 3600000); // প্রতি ঘন্টায় ইনকাম
  } else {
    alert("🙁 পর্যাপ্ত ব্যালেন্স নেই!");
  }
}

updateBalanceDisplay();
