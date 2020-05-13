<template>
    <div class="component">
        <h2>The User Informations</h2>
        <p>Various details...</p>
        <p> User Name: <strong>{{ reverseName() }}</strong></p>
        <p> User age <strong>{{ age }}</strong></p>
        <button @click="restartName">Restart Name</button>
        <button @click="restartFn()">Restart Name (Callback)</button>
    </div>
</template>

<script>
import bus from '@/bus'

export default {
    props: {
        name: {
            type: String,
            default: 'Maria'
        },
        restartFn: Function,
        age: Number
    },
    methods: {
        reverseName() {
            return this.name.split('').reverse().join('')
        },
        restartName() {
            this.name = 'Pedro'
            bus.$emit('nameChange', this.name)
        }
    },
    created() { bus.whenAgeChange(age => { this.age = age }) }
}
</script>

<style scoped>
    .component {
        flex: 1;
        background-color: #ec485f;
        color: #fff;
    }
</style>
