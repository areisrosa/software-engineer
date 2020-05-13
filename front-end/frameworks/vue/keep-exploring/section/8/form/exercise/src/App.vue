<template>
	<div id="app">
		<h1>Register Complaint</h1>
		<div class="content">
			<form class="panel" v-if="!sent">
				<div class="header">Form</div>
				<ticket name="E-mail">
					<input type="text" v-model.lazy.trim="user.email">
				</ticket>
				<ticket name="Password">
					<input type="password" v-model="user.password">
				</ticket>
				<ticket name="Age">
					<input type="number" v-model.number="user.age">
				</ticket>
				<ticket name="Message">
					<textarea name="" cols="30" rows="5" v-model="message"></textarea>
				</ticket>
				<ticket name="Problem Characteristics">
					<span class="mr-4"><input type="checkbox" v-model="characteristic" 
						value="reproducible"> Reproducible</span>
					<span><input type="checkbox" v-model="characteristic"
						value="intermittent"> Intermittent</span>
				</ticket>
				<ticket name="What is problem?">
					<span class="mr-4"><input type="radio" value="web" v-model="product"> Web</span>
					<span class="mr-4"><input type="radio" value="mobile" v-model="product"> Mobile</span>
					<span><input type="radio" value="other" v-model="product"> Other</span>
				</ticket>
				<ticket name="Priority">
					<select v-model="priority">
						<option v-for="priority in priorities" 
						:value="priority.code" 
						:key="priority.code">
						{{ priority.code }} - {{ priority.name }}</option>
					</select>
				</ticket>
				<ticket name="First complaint?">
					<choice v-model="choice" />
				</ticket>
				<hr>
				<button @click.prevent="submit">Submit</button>
			</form>
			<div class="panel" v-else>
				<div class="header">Result</div>
				<ticket name="E-mail">
				<span>{{ user.email }}</span>
				</ticket>
				<ticket name="Password">
				<span>{{ user.password }}</span>
				</ticket>
				<ticket name="Age">
				<span>{{ user.age }}</span>
				</ticket>
				<ticket name="Message">
				<span style="white-space: pre;">{{ message }}</span>
				</ticket>
				<ticket name="Problem Characteristics">
					<span>
						<ul>
							<li v-for=" c in characteristic" :key="c">{{ c }}</li>
						</ul>
					</span>
				</ticket>
				<ticket name="Which product?">
				<span>{{ product }}</span>
				</ticket>
				<ticket name="Priority">
				<span>{{ priority }} {{ typePriority }}</span>
				</ticket>
				<ticket name="First Complaint?">
				<span>{{ choice }}</span>
				</ticket>
			</div>
		</div>
	</div>
</template>

<script>
import Ticket from './components/Ticket.vue'
import Choice from './components/Choice.vue'

export default {
	name: 'app',
	components: { 'ticket': Ticket, 'choice': Choice },
	computed: {
		typeAge() {
			return typeof this.user.age
		},
		typePriority () {
			return typeof this.priotity
		}
	},
	methods: {
			submit() {
				this.sent = true
			}
		},
	data() {
		return {
			message: '',
			characteristic: [],
			product: 'web',
			priotity: 1,
			priorities: [
				{code: 1, name: 'Low'},
				{code: 2, name: 'Average'},
				{code: 3, name: 'High'}
			],
			user: {
				email: '',
				password: '',
				age: 25
			},
			choice: true,
			sent: false
		}
	}
}
</script>

<style>

body {
	background-color: #ececec;
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
	background: #fff;
	margin: 0px 10px;
	padding: 20px;
	border: 1px solid #aaa;
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
	color: #fff;
	background-color: #2196f3;
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
