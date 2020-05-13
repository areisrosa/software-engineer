<template>
	<div id="app">
		<h1>Filters & Mixins</h1>
		<p>{{phrase | comma-space }}</p>
		<p>{{ commaPhrase }}</p>
		<p>{{ sizePhrase }}</p>
	</div>
</template>

<script>
import phraseMixin from './phraseMixin.js'

export default {
	mixins: [phraseMixin],
	data() {
		return { phrase: 'This is the phrase that will be used in the challenge.' }
	},
	filters: {
		commaSpace(value) {
			return value.replace(/\s/g, ',') 
		} 
	}
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
</style>
