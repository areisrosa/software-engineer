new Vue({
    el: '#challenge',
    data: {
        value: ''
    },
    methods: {
        showAlert() {
            alert('You click in button')
        },
        changeValue(event) {
            this.value = event.target.value
        }
    }
})
