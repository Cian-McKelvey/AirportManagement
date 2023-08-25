var ws;
function connect() {
    var host = document.location.host;
    var pathname = document.location.pathname;

    console.log("ws://" +host  + pathname + "socket");
    ws = new WebSocket("ws://" +host  + pathname + "socket");
    return ws;
}

let socket = connect();

// Just prints traffic for debugging
socket.addEventListener('message', (event) => {
    const message = event.data;
    console.log('Received message:', message);
    // You can process the message here
});
