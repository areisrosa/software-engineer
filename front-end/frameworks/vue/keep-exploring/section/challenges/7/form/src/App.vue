<template>
	<div id="app">
		<h1>Challenge Form</h1>
		<div class="content">
			<form class="panel" v-if="!sent">
				<div class="header">Form</div>
				<full-name></full-name>
				<ticket name="Email">
					<input type="email" v-model="email">
				</ticket>
				<ticket name="Password">
					<input type="password" v-model="password">
				</ticket>
				<ticket name="Store data?">
					<input type="checkbox" v-model="storesData">
				</ticket>
				<hr>
				<button @click.prevent="submit">Submit</button>
			</form>
			<div class="panel" v-else>
				<div class="header">Result</div>
				<ticket name="FirstName">
					<span>{{ fullName.firstname }}</span>
				</ticket>
				<ticket name="LastName">
					<span>{{ fullName.lastname }}</span>
				</ticket>
				<ticket name="Email">
					<span>{{ email }}</span>
				</ticket>
				<ticket name="Password">
					<span>{{ password }}</span>
				</ticket>
				<ticket name="Store data?">
					<span>{{ storesData }}</span>
				</ticket>
			</div>
		</div>
	</div>
</template>

<script>
import Ticket from './components/Ticket.vue'
import FullName from './components/FullName.vue'

export default {
	name: 'app',
	components: { 'ticket': Ticket, 'full-name': FullName },
	data() {
		return {
			sent: false,
			fullName: {
				firstname: '',
				lastname: '',
			},
			email: '',
			password: '',
			storesData: true
		}
	},
	methods: {
		submit() {
			this.sent = true
		}
	}
}
</script>

<style>

body {
	background-color: #ECECEC;
}

#app {
	font-family: 'Avenir', Helvetica, Arial, sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
	text-align: center;
	color: #2c3e50;

	display: flex;
	flex-direction: column;
}

.content {
	display: flex;
}

.panel {
	flex: 1;
	background: #FFF;
	margin: 0px 10px;
	padding: 20px;
	border: 1px solid #AAA;
	border-radius: 5px;
}

.panel .header {
	width: 100%;
	background-color: #DDD;
	padding: 10px 0px;
	border-radius: 5px;
	font-size: 1.4rem;
}

#app form button {
	float: right;
	margin: 10px 0px;
	padding: 10px 20px;
	font-size: 1.4rem;
	border-radius: 5px;
	color: #FFF;
	background-color: #2196F3;
}

#app h1 {
	font-weight: 200;
	margin: 20px;
	padding: 0;
}

.mr-4 {
	margin-right: 40px;
}
</style>
