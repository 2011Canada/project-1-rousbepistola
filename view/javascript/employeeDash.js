//                                                                                CREATING SESSION STORAGE
let storage = window.sessionStorage;
//                                                          LOAD DASH DATA
document.getElementById("dashData").innerHTML = `<strong>NAME:</strong> ${storage.getItem("fname")} ${storage.getItem("lname")}`
document.getElementById("dashUsername").innerHTML = `<strong>USERNAME:</strong>  ${storage.getItem("username")}`
document.getElementById("dashEmail").innerHTML = `<strong>EMAIL:</strong> ${storage.getItem("email")}`
document.getElementById("dashUserId").innerHTML = `<strong>USER ID:</strong> ${storage.getItem("user_id")}`



//                                                        HANDLING REIMBURSEMENT SUBMIT
let reimbursementForm = document.getElementById("reimbursementForm");
reimbursementForm.addEventListener('submit', reimbursementRequest)

async function reimbursementRequest(e){
    e.preventDefault();


    let date = new Date();

    let r_amount = document.getElementById('reimbursementAmount').value
    let r_timeSubmitted = `${date.getFullYear()}/${date.getMonth() + 1}/${date.getDate()} : ${date.getHours()}:${date.getMinutes()}(H:M)`
    let r_desc = document.getElementById('reimbursementDescription').value
    let r_author = storage.getItem("user_id")
    let r_status = false
    let r_type = document.getElementById('reimbursementType').value


    await axios.post('http://localhost:8080/Project1/FrontController', {
        typeOfRequest: "reimbursementRequest",
        amount: r_amount,
        timeSubmitted: r_timeSubmitted,
        description: r_desc,
        author: r_author,
        status: r_status,
        type: r_type
    })
	.then(function (response) {
      // handle success
    document.getElementById("reimbursementForm").reset()
    document.getElementById("reimbursementToast").innerHTML = `
    <div class="alert alert-warning alert-dismissible fade show" style="background-color:lightgreen; color:black; font-size:0.8rem; padding:0.6rem" role="alert">
        <p class="badge bg-success text-light">Info</p>
        <span class="mx-5"><strong>$${r_amount}</strong> submitted for approval at ${r_timeSubmitted}</span>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>`


    console.log(response, response.status, "you got it!")

    // if(response.status == 200 && response.data.userRole == "employee"){
    //   console.log(response.data)
    //   let {fname, lname, username, pass, email, user_id} = response.data;
    //   console.log("WELCOME! ",fname, lname)
      
    //   // setting sessionStorage
    //   storage.setItem("fname", fname)
    //   storage.setItem("lname", lname)
    //   storage.setItem("username", username)
    //   storage.setItem("email", email)
    //   storage.setItem("user_id", user_id)
      
    //   window.location.href = "./html/employeeDash.html";
    // } 
      
	})
	.catch(function (error) {
	  // handle error
    console.log(error, "Invalid Request");
	})

}



