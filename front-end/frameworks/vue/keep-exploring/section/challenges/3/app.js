new Vue({
    el: '#challenge',
    data: {
        value: 0
    },
    computed: {
        result() {
            return this.value == 37 ? 'Current value' : 'Different value'
        }
    },
    watch: {
        result() {
            setTimeout(() => {
                this.value = 0
            }, 5000) 
        }
    }
});
