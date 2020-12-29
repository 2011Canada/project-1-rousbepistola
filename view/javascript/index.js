//THIS CODE IS FOR TESTING, MOVE ALONG
// let form = document.getElementById("thisForm");
// let nameTag = document.getElementById("nameTag");
// form.addEventListener('submit', servletAccess)

// async function servletAccess(e){
//     e.preventDefault();

//     let newData

//     console.log("im here")
// 	await axios.get('http://localhost:8080/Project1/MyServlet')
// 	.then(function (response) {
// 	  // handle success
      
//       let data = response.data
//     //   console.log(data);

    
//     console.log(response)
//     newData = document.createElement("P")
//     newData.innerHTML = response.data[0].name
//     nameTag.appendChild(newData);
      
// 	})
// 	.catch(function (error) {
// 	  // handle error
// 	  console.log(error);
// 	})
// }

//                                                                                CREATING SESSION STORAGE
let storage = window.sessionStorage;



//                                                                                 LOGIN LOGIC

let loginForm = document.getElementById("login-form");
loginForm.addEventListener('submit', loginAccess)

async function loginAccess(e){
    e.preventDefault();

    let loginUsername = document.getElementById('loginUsername').value
    let loginPass = document.getElementById('loginPass').value

    await axios.post('http://localhost:8080/Project1/FrontController', {
        typeOfRequest: "loginRequest",
        username: loginUsername,
        pass: loginPass
    })
	.then(function (response) {
	  // handle success
    console.log(response.status)

    if(response.status == 200 && response.data.userRole == "employee"){
      console.log(response.data)
      let {fname, lname, username, pass, email, user_id} = response.data;
      console.log("WELCOME! ",fname, lname)
      
      // setting sessionStorage
      storage.setItem("fname", fname)
      storage.setItem("lname", lname)
      storage.setItem("username", username)
      storage.setItem("email", email)
      storage.setItem("user_id", user_id)
      
      window.location.href = "./html/employeeDash.html";
    } 
      
	})
	.catch(function (error) {
	  // handle error
    console.log(error, "Unauthorized access");
    document.getElementById("loginError").innerHTML = "Invalid credentials or account may not exist"
	})

}










