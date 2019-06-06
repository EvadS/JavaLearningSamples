var messageApi = Vue.resource('/message{/id}');

Vue.component('message-row', {
    props: ['message'],
    template: '<div><i>({{message.id }})</i> {{message.text}}</div>'
});

Vue.component('messages-list', {
    props: ['messages'],
    template: '<div>' +
        '<message-row v-for=" message in messages" :message="message"></message-row>' +
        '</div>',
    created: function () {
        messageApi.get().then(result =>
        result.json().then(data=>
            data.forEach(message => this.messages.push(message))
            )
    )
    }
});

var app = new Vue({
    el: '#app',
    template: '<messages-list :messages="messages"/>',
    data: {
        // messages: [
        //     {id:'123', text: 'text 1'},
        //     {id:'123', text: 'text 2'},
        //     {id:'123', text: 'text 3'},
        //     {id:'123', text: 'text 4'}
        // ]

        messages: []
    }
});

console.log("here");