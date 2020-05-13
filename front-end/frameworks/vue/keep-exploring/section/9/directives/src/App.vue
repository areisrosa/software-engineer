<template>
	<div id="app">
		<h1>Directives</h1>
		<hr>
		<p v-text="'Using directive v-text'"></p>
		<p v-html="'Using directive <strong>v-text</strong>'"></p>
		<hr>
		<p v-contrast:background.retard="'lightblue'">Using person directive</p>
		<p v-contrast.retard="color">Using person directive</p>
		<hr>
		<p v-contrast-local:background.retard.interchange="{color1: 'green', color2: 'red', delay: 2000, interval: 200}">Using person directive</p>
		<p v-contrast-local.retard="{color1: 'green', delay: 5000}">Using person directive</p>
	
	</div>
</template>

<script>
export default {
components: {},
directives: {
	'contrast-local': {
		bind(el, binding) {
			const applyColor = color => {
				if (binding.arg === "background") {
					el.style.backgroundColor = color;
				} else {
					el.style.color = color;
				}
			}

			let delay = 0;
			if (binding.modifiers["retard"]) delay = binding.value.delay;

			const color1     = binding.valeu.color1
			const color2     = binding.valeu.color2
			let currentColor = color1

			setTimeout(() => {
				if (binding.modifiers["interchange"]) {
					setInterval(() => {
						currentColor = currentColor == color1 ? color2 : color1
						applyColor(currentColor)
					}, binding.value.interval);
				} else {
					applyColor(binding.value.color1)
				}
			}, delay);
		},
	}
},
	data() {
		return {
			color: 'red'
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
