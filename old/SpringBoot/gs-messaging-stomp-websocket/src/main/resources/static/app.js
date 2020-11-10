var stompClient = null;
var ws = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    console.log('connect()')

    var socket = new SockJS('/greeting');
    //  var socket =  new SockJS('http://localhost:8080/ws')
    stompClient = Stomp.over(socket);
    /*stompClient.connect({}, function(frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function(greeting){
            showGreeting(JSON.parse(greeting.body).content);
        });
    });*/

    stompClient.connect({}, function (frame) {
        setConnected(true);
        stompClient.subscribe("/user/queue/errors", function (message) {
            alert("Error " + message.body);
        });

        stompClient.subscribe("/user/queue/reply", function (message) {
            alert("Message " + message.body);
        });
    }, function (error) {
        alert("STOMP error " + error);
    });
}


/*
function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}*/

function disconnect() {
    if (ws != null) {
        ws.close();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    // stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));

    /// stompClient.send("app/message", {}, JSON.stringify({'from': 'from' ,'message': $("#name").val(), }));

    stompClient.send("/app/chat", {'user': 'AA123'}, JSON.stringify({'from': 'from', 'text': $("#name").val(),}));

}


function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#connect").click(function () {
        connect();
    });
    $("#disconnect").click(function () {
        disconnect();
    });
    $("#send").click(function () {
        sendName();
    });
});

