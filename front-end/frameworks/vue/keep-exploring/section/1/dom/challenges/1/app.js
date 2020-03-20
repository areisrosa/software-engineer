var challenge = new Vue({
    el: '#challenge',
    data: {
        name: 'Jesus Cat',
        age: 2031,
        imagem: 'images.jpeg'
    },
    methods: {
        multAge: function () {
            return this.age * 3
        },
        randNumber: function() {
            return Math.random()
        }
    }
})
