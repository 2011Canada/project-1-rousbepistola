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




//                                                                                 LOGIN LOGIC

let loginForm = document.getElementById("login-form");
loginForm.addEventListener('submit', loginAccess)

async function loginAccess(e){
    e.preventDefault();

    let loginUsername = document.getElementById('loginUsername').value
    let loginPass = document.getElementById('loginPass').value

    await axios.post('http://localhost:8080/Project1/FrontController', {
        username: loginUsername,
        pass: loginPass
    })
	.then(function (response) {
	  // handle success
      
    let data = response.data
    

    
    console.log(response)
      
	})
	.catch(function (error) {
	  // handle error
	  console.log(error);
	})

}










