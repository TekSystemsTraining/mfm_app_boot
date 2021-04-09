window.onload = function () {
  var element = document.getElementById("form");
  if (element.addEventListener) {
    element.addEventListener("submit", validate, true);
  }

  function validate(e) {
    console.log("e", e);
    e.preventDefault();
    var nameInput = e.target[0].value;
    var emailInput = e.target[1].value;
    console.log("name", nameInput);
    checkName(nameInput);
    console.log("email", emailInput);
    checkEmail(emailInput);
    if (checkName(nameInput) && checkEmail(emailInput)) {
      console.log("both inputs are valid");
      advancePage();
    } else {
      console.log("please use the correct input formats");
      if(checkName(nameInput) == false){
        alert("Please fix your name to only include letters.");
      }else{
        alert("Please provide a valid email address");
      }
    }
  }
  function checkName(name) {
    var regex = new RegExp(/^[a-zA-Z0-9_.-]*$[a-zA-Z_.-]*$/g);
    result = regex.test(name);
    console.log("result", result);
    return result;
  }
  function checkEmail(email) {
    var eRegex = new RegExp(
      /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/
    );
    result = eRegex.test(email);
    console.log("result", result);
    return result;
  }
  function advancePage() {
    window.location.href = "./order.html";
  }
};
