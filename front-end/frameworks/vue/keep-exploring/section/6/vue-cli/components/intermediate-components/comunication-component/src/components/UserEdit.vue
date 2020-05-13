<template>
    <div class="component">
        <h2> Change User Data </h2>
        <p>Edit the Informations</p>
        <p> User age <strong>{{ age }}</strong></p>
        <button @click="updadeAge">Change age</button>
    </div>
</template>

<script>
import bus from '@/bus'

export default {
    props: { age: Number },
    methods: {
        updadeAge() {
            this.age += 1
            bus.$emit('ageChange', this.age)
        }
    }
}
</script>

<style scoped>
    .component {
        flex: 1;
        background-color: #98b99a;
        color: #fff;
    }
</style>
