new Vue ({
    el: '#challenge',
    data: {
        name: 'Anderson Reis',
        age: 33,
        imagem: 'cat.jpeg'
    },
    methods: {
        random: function() {
            return Math.random()
        },
        ageTimeTree: function() {
            return this.age*3
        }
    }
})

