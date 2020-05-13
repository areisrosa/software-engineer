<template>
    <div class="">
        <ticket name="FirstName">
        <input type="text" @input="changeFirstName"
        :value="value.firstname">
        </ticket>
        <ticket name="LastName">
        <input type="text" @input="changeLastName"
            :value="value.lastname">
        </ticket>
    </div>
</template>

<script>
import Ticket from './Ticket.vue'

export default {
    props: {
        value: { type: Object, require: true }
    },
    components: { 'ticket': Ticket },
    methods: {
        changeFirstName(event) {
            this.$emit('input', {
                firstname: event.target.value,
                lastname: this.value.lastname
            })
        },
        changeLastName(event) {
            this.$emit('input', {
                firstname: this.value.lastname,
                lastname: event.target.value
            })
        }
    }
}
</script>

<style>

</style>
