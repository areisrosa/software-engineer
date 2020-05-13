<template>
	<v-app>
		<app-menu></app-menu>
		<app-toolbar></app-toolbar>
		<v-content>
			<app-carousel></app-carousel>
		</v-content>
		<app-footer></app-footer>
	</v-app>
</template>

<script>
import Menu     from '@/components/templates/Menu.vue'
import Footer   from '@/components/templates/Footer.vue'
import Toolbar  from '@/components/templates/Toolbar.vue'
import Carousel from '@/components/widgets/Carousel.vue'

export default {
	components: { 'app-footer': Footer, 'app-carousel': Carousel, 
		'app-toolbar': Toolbar, 'app-menu': Menu }
}
</script>
