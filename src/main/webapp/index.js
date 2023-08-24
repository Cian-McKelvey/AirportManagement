// Function to read form elements and display their values
function readFormElements() {
    const airline = document.getElementById('Airline').value;
    const manufacturer = document.getElementById('Manufacturer').value;
    const model = document.getElementById('Model').value;
    const numSeats = parseInt(document.getElementById('numSeats').value);

    console.log("Airline:", airline);
    console.log('Manufacturer:', manufacturer);
    console.log('Aircraft Model:', model);
    console.log('Number of Seats:', numSeats);

    let aircraftJson = {
        "type": "aircraft",
        "airline": airline,
        "manufacturer": manufacturer,
        "model": model,
        "numSeats": numSeats
    };
    console.log(aircraftJson);

    return aircraftJson;
}


var ws;
function connect() {
    var host = document.location.host;
    var pathname = document.location.pathname;

    console.log("ws://" +host  + pathname + "socket");
    ws = new WebSocket("ws://" +host  + pathname + "socket");
    return ws;
}


let socket = connect();
//let socket = new WebSocket("http://localhost:8080/AirportManagement-1.0-SNAPSHOT/socket"); // Can probably be moved out so it isn't ran every time the for is submitted

document.addEventListener('DOMContentLoaded', function () { // This is vital!!! :) the js runs too early otherwise

    // Add event listener to the form submission
    document.getElementById('AircraftForm').addEventListener('submit', function (event) {

        event.preventDefault(); // Prevent form submission to see the console output

        let returnedObj = readFormElements();
        let returnedObjString = JSON.stringify(returnedObj);
        
        //let socket = new WebSocket("ws://localhost:8765"); // Can probably be moved out so it isn't ran every time the for is submitted
        socket.onopen = function (e) { 
            console.log("session started");
        };

        alert("Sending to server");
        socket.send(returnedObjString);
        console.log("message sent!!!");
    });

});



