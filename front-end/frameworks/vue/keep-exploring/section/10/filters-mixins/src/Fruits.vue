<template>
	<div>
		<ul>
			<li v-for="fruit in fruits" v-bind:key="fruit">{{ fruit }}</li>
		</ul>
		<input type="text" v-model="fruit" @keydown.enter="add">
	</div>
</template>

<script>
import fruitsMixin from './usersMixin.js'
import usersMixin from './usersMixin.js'

export default {
mixins: [fruitsMixin, usersMixin],
created() { console.log("Created - Fruits.vue!") }
}
</script>

<style>
</style>
