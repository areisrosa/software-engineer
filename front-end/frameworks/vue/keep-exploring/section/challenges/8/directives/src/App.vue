<template>
	<div id="app">
		<h1>Directives</h1>
		<hr>
		<button v-while:click="action">Run</button>
		<p v-while:mouseenter="mouseEnter"
		   v-while:mouseleave="mouseLeave">Test mouse event!
		</p>
	</div>
</template>

<script>
export default {
	directives: {
		while: {
			bind(el, binding) {
				// el.onclick = function(e) { binding.value() }
				const tip = binding.arg
				const fn  = binding.value
				el.addEventListener(tip, fn)
			}
		}
	},
	methods: {
		action() {
			alert('Action run!')
			},
		mouseEnter() {
			console.log('Mouse enter!')
			},
		mouseLeave() {
			console.log('Mouse leave!')
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

button {
	margin: 10px 0px;
	padding: 10px 20px;
	font-size: 1.4rem;
	border-radius: 5px;
	color: #FFF;
	background-color: #2196F3;
}
</style>
