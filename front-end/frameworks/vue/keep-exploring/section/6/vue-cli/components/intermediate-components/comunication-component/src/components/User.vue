<template>
    <div class="container">
        <h1> User Component </h1>
        <p>This is very cool component!</p>
        <p>Nome is <strong>{{ name }}</strong></p>
        <p> Age is <strong>{{ age }}</strong></p>
        <button @click="updateName">Change Name</button>
        <hr>
        <div class="components">
            <app-user-info 
                v-bind:name="name"
                :age="age"
                @nameChange="name = $event"
                :restartFn="restartName"
                />
            <app-user-edit 
                :age="age" />
        </div>
    </div>
</template>

<script>
import AppUserInfo from './UserInfo'
import AppUserEdit from './UserEdit'

export default {
    components: { AppUserInfo, AppUserEdit },
    data() {
        return {
            name: 'Pedro',
            age: 21
        }
    },
    methods: {
        updateName() {
            this.name = 'Ana'
        },
        restartName() {
            this.name = 'Pedro'
        }
    }
}
</script>

<style scoped>
    .container {
        background-color: #27363b;
        color: #fff;
        padding: 10px;
    }

    .container hr {
        margin: 20px 10px;
    }

    .components {
        display: flex;
    }

    .components > * {
        margin: 10px;
    }
</style>
