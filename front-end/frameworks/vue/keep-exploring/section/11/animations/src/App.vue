<template>
	<div id="app" class="container-fluid">
		<h1>Animations</h1>
		<!-- <hr> -->
		<!-- <b&#45;button variant="primary" class="mb&#45;4"  -->
		<!-- 	@click="show = !show"> Show Message</b&#45;button> -->
		<!-- <transition name="fade" appear> -->
		<!-- 	<b&#45;alert variant="info" show v&#45;if="show">{{  msg }}</b&#45;alert> -->
		<!-- </transition> -->
        <!--  -->
		<!-- <transition name="slide" type="animation" appear> -->
		<!-- 	<b&#45;alert variant="info" show v&#45;show="show">{{  msg }}</b&#45;alert> -->
		<!-- </transition> -->
        <!--  -->
		<!-- <transition enter&#45;active&#45;class="animated bounce" leave&#45;active&#45;class=" anumated shake"><b&#45;alert variant="info" show v&#45;show="show">{{  msg }}</b&#45;alert> -->
		<!-- </transition> -->

		<!-- <hr> -->
		<!-- <b&#45;select v&#45;model="typeAnimation"> -->
		<!-- 	<option value="fade">Fade</option> -->
		<!-- 	<option value="slide">Slide</option> -->
		<!-- </b&#45;select> -->
        <!--  -->
		<!-- <transition :name="typeAnimation" mode="out&#45;in"> -->
		<!-- 	<b&#45;alert variant="info" show v&#45;if="show" key="info">{{  msg }}</b&#45;alert> -->
		<!-- 	<b&#45;alert variant="warning" show v&#45;else key="warn">{{  msg }}</b&#45;alert> -->
		<!-- </transition> -->
        <!--  -->
		<!-- <hr> -->
		<!-- <button @click="show2 = !show2">Show</button> -->
		<!-- <transition :css="false" -->
		<!-- @before&#45;enter="beforeEnter" -->
		<!-- @enter="enter" -->
		<!-- @after&#45;enter="afterEnter" -->
		<!-- @enter&#45;cancelled="enterCancelled" -->
        <!--  -->
		<!-- @before&#45;leave="beforeLeave" -->
		<!-- @leave="leave" -->
		<!-- @after&#45;leave="afterLeave" -->
		<!-- @leave&#45;cancelled="leaveCancelled"> -->
		<!-- <div v&#45;if="show2" class="box"></div> -->
		<!-- </transition> -->
        <!--  -->
		<!-- <hr> -->
		<!-- <div class="mb&#45;4"> -->
		<!-- 	<b&#45;button variant="primary" class="mr&#45;2"  -->
		<!-- 		@click="componentSelect = 'Warning'">Warning</b&#45;button> -->
		<!-- 	<b&#45;button variant="secondary"  -->
		<!-- 		@click="componentSelect = 'Info'">Info</b&#45;button> -->
		<!-- </div> -->
		<!-- <transition name="fade" mode="out&#45;in"> -->
		<!-- 	<componet :is="componentSelect"></componet> -->
		<!-- </transition> -->
		<hr>
		<b-button @click="addStudent" class="mb-4">Add Student</b-button>
		<transition-group name="slide" tag="div">
			<b-list-group v-for="(student, i) in students" :key="student">
				<b-list-group-item @click="removeStudent(i)">{{ student }}</b-list-group-item>
			</b-list-group>
		</transition-group>
	</div>
</template>

<script>
import Warning from './Warning.vue'
import Info from './Info.vue'

export default {
	components: { 'warning': Warning, 'info': Info },
	data() {
		return {
			students: ['Roberto', 'Julia', 'Teresa', 'Paulo'],
			msg: 'A user information message', 
			show: false,
			show2: true,
			typeAnimation: 'fade',
			baseWidth: 0,
			componentSelect: 'Info'
		}
	},
	methods: {
		addStudent() {
			const s = Math.random().toString(36).substring(2)
			this.students.push(s)
		},
		removeStudent(index) {
			this.students.splice(index, 1)
		},
		animated(el, done, neg) {
			let rod = 1
			const temp = setInterval(() => {
				const newWidth = this.baseWidth + 
					(neg ? -rod * 10 : rod * 10)
				el.style.width = `${newWidth}px`
				rod++
				if(rod > 30) {
					clearInterval(temp)
					done()
				}
			}, 20)
		},
		beforeEnter(el) {
			this.baseWidth = 0
			el.style.width = `${this.newWidth}px`
		},
		enter(el, done) {
			this.animated(el, done, false)
		},
		afterEnter() {},
		enterCancelled() {},
		beforeLeave(el) {
			this.baseWidth = 300
			el.style.width = `${this.baseWidth}px`
		},
		leave(el, done) {
			this.animated(el, done, false)
		},
		afterLeave() {},
		leaveCancelled() {}
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
	font-size: 1.5rem;
}
.box {
	height: 100px;
	width: 300px;
	margin: 30px auto;
	background-color: lightgreen;
}
.fade-enter, .fade-entrer-to {
	opacity: 0;
}

.fade-entrer-active, .fade-leave-active {
	transition: opacity 2s; 
}

@keyframes slide-in {
	from { transform: translateY(40px); }
	to   { transform: translateY(0); }
}

@keyframes slide-out {
	from { transform: translateY(0); }
	to   { transform: translateY(40px); }
}

.slide-enter-active {
	animation: slide-in 2s ease;
	transition: opacity 2s; 
}

.slide-leave-active {
	position: absolute;
	width: 100%;
	animation: slide-out 2s ease;
	transition: opacity 2s; 
}

.slide-enter, .slide-leave-to {
	opacity: 0;
}

.slide-move {
	transition: transform 1s;
}
</style>
