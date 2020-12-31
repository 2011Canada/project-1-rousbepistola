//                                                                                CREATING SESSION STORAGE
let storage = window.sessionStorage;

// if(storage.length > 0){
//     console.log(storage)
//     window.location.href = "../index.html";
// };




//                                                          LOAD DASH DATA
document.getElementById("dashData").innerHTML = `<strong>NAME:</strong> ${storage.getItem("fname")} ${storage.getItem("lname")}`
document.getElementById("dashUsername").innerHTML = `<strong>USERNAME:</strong>  ${storage.getItem("username")}`
document.getElementById("dashEmail").innerHTML = `<strong>EMAIL:</strong> ${storage.getItem("email")}`
document.getElementById("dashUserId").innerHTML = `<strong>USER ID:</strong> ${storage.getItem("user_id")}`



//-------------------------------------------------HANDLING REIMBURSEMENT SUBMIT-------------------------------------------------------------------
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


    console.log(response, response.status, "succesfully submitted reimbursement!")

      
	})
	.catch(function (error) {
	  // handle error
    console.log(error, "Invalid Request");
	})

}



//-------------------------------------------------HANDLING TICKET CHECKING-------------------------------------------------------------------

let showTicketButton = document.getElementById("showTicketButton");
showTicketButton.addEventListener('click', showTickets)
let ticketSection = document.getElementById("ticketSection")

async function showTickets(e){
    e.preventDefault();
    document.getElementById("spinner").style.display = "flex"
 
    

    let author = storage.getItem("user_id")

    await axios.post('http://localhost:8080/Project1/FrontController', {
        typeOfRequest: "showTickets",
        author,

    })
	.then(function (response) {
    

        setTimeout(()=>{
            document.getElementById("spinner").style.display = "none"
            document.getElementById("ticketSection").style.display = "flex"
            
        }, 1000)
        ticketSection.innerHTML = ""
        ticketSection.innerHTML += `<li style="border: 1px solid seagreen; padding: .5rem;" class="list-group-item list-group-item-primary text-left bg-dark text-light">Tickets <button style="position:absolute; right: 3%; border-radius:8%;" id="closeTicket" class="btn btn-light btn-sm px-1 py-0" onclick="closeTicketNow()"> close </button></li>`
        // generating child nodes
        for(let i = 0; i < response.data.length; i++){
            console.log(response.data[i])
            

            if(response.data[i].status == true){
                ticketSection.innerHTML += `
                <li style="border-bottom: 3px solid seagreen; padding: 0.5rem; display:initial;" class="list-group-item list-group-item-success approved-tickets">
                    <i class="far fa-thumbs-up fa-lg text-success py-2" style="position:absolute; right:3%;"></i> <span class="badge  text-secondary p-1">Ticket Number: ${response.data[i].id}</span> ••• <strong>DATE SUBMITTED:</strong> ${response.data[i].time_submitted}<hr>
                    <p><strong class="badge bg-success text-light">APPROVED</strong> - Amount: ${response.data[i].amount} (<small>Expense Description: ${response.data[i].description}</small>)</p>
                    <p>Approved on: ${response.data[i].time_resolved} by employee ID : ${response.data[i].resolver}</p>
                </li>`

            } else if(response.data[i].status == false && response.data[i].time_resolved == null){
                ticketSection.innerHTML += `
                <li style="border-bottom: 3px solid seagreen; padding: 0.5rem; display:initial;" class="list-group-item list-group-item-dark pending-tickets bg-light">
                    <i class="fas fa-hourglass-start fa-lg py-2" style="position:absolute; right:3%;"></i> <span class="badge  text-secondary p-1">Ticket Number: ${response.data[i].id}</span> ••• <strong>DATE SUBMITTED:</strong> ${response.data[i].time_submitted}<hr>
                    <p><strong class="badge bg-info text-text-light"> PENDING </strong> - Amount: ${response.data[i].amount} (<small>Expense Description: ${response.data[i].description}</small>)</p>
                </li>
                `

            } else if(response.data[i].status == false && response.data[i].time_resolved != null){
                ticketSection.innerHTML += `
                <li style="border-bottom: 3px solid seagreen; padding: 0.5rem; display:initial;" class="list-group-item list-group-item-danger rejected-tickets">
                    <i class="fas fa-times fa-lg text-danger py-2" style="position:absolute; right:3%;"></i> <span class="badge  text-secondary p-1">Ticket Number: ${response.data[i].id}</span> ••• <strong>DATE SUBMITTED:</strong> ${response.data[i].time_submitted}<hr>
                    <p><strong class="badge bg-danger text-light">REJECTED</strong> - Amount: ${response.data[i].amount} (<small>Expense Description: ${response.data[i].description}</small>)</p>
                    <p>Rejected on: ${response.data[i].time_resolved} by employee ID : ${response.data[i].resolver}</p>
                    <button class="btn btn-sm btn-dark btn-outline-red text-light" > Contest Rejection </button>
                </li>
                `
                
            }




    }



    console.log(response, response.status, "SUCCESSFULLY RETRIEVED TICKETS!")

      
	})
	.catch(function (error) {
	  // handle error
    console.log(error, "Invalid Request");
	})

}

//-------------------------------------------------CLOSING TICKET TAB-------------------------------------------------------------------


// let closeTicketTab = document.getElementById("closeTicket");
// closeTicketTab.addEventListener("click", closeTicketNow)

function closeTicketNow(){
    document.getElementById("ticketSection").style.display = "none"
}


//-------------------------------------------------LOG OUT-------------------------------------------------------------------


let logout = document.getElementById("logout")
logout.addEventListener("click", logoutNow)

function logoutNow(e){
    e.preventDefault();
    storage.clear();
    window.location.replace("../index.html");


}





