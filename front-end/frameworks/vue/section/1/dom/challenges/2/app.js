new Vue({
    el: '#desafio',
    data: {
        value: ''

    },
    methods: {
        showAlert(event) {
            alert("Hello")
        },
        getValue(event) {
            this.value = event.target.value
        }
    }
})
