<template>
	<div id="app">
		<h1>Filters & Mixins</h1>
		<hr>
		<p>{{ userLogin }}</p>
		<p>{{ cpf | cpf | reverse }}</p>
		<input type="text" :value="cpf | cpf | reverse">
		<hr>
		<fruits></fruits>
	</div>
</template>

<script>
import Fruits from './Fruits.vue'
import fruitsMixin from './fruitsMixin.js'
import usersMixin from './usersMixin.js'

export default {
	components: { 'fruits': Fruits },
	mixins: [fruitsMixin, usersMixin],
	filters: {
		cpf(value) {
			const arr = value.split('')
			arr.splice(3, 0, '.')
			arr.splice(7, 0, '.')
			arr.splice(11, 0, '-')
			return arr.join('')
		}
	},
	data() {
		return {
			cpf: '60010100101'
		}
	},
	created() { console.log("Created - App.vue!") }
}
</script>

<style>
#app {
	font-family: 'Avenir', Helvetica, Arial, sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
	text-align: center;
	color: #2c3e50;
	margin-top: 60px;
	font-size: 2.5rem;
}

input {
	font-size: 2.5rem;
}
</style>
