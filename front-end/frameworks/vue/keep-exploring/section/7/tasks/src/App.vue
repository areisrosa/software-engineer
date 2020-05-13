<template>
	<div id="app">
		<h1>Tasks</h1>
		<tasks-progress :progress="progress"></tasks-progress>
		<new-task @taskAdded="addTask"></new-task>
		<task-grid :tasks="tasks" @taskDeleted="deletedTask" @taskStateChanged="toggleTaskState" />
	</div>
</template>

<script>
import NewTask from './components/NewTask.vue'
import TaskGrid from './components/TaskGrid.vue'
import TasksProgress from './components/TasksProgress.vue'

export default {
	components: { 'tasks-progress': TasksProgress, 'task-grid': TaskGrid, 'new-task': NewTask },
	data() {
		return {
			tasks: []
		}
	},
	computed: {
		progress() {
			const total = this.tasks.length
			const done = this.tasks.filter(t => !t.pending).length
			return Math.round(done / total * 100) || 0
		}
	},
	watch: {
		tasks: {
			deep: true,
			handler() {
				localStorage.setItem('tasks', JSON.stringify(this.tasks))
			}
		}
	},
	methods: {
		addTask(task) {
			const sameName = t => t.name === task.name
			const reallyNew = this.tasks.filter(sameName).length == 0
			if(reallyNew) {
				this.tasks.push({
					name: task.name,
					pending: task.pending || true
				})
			}
		},
		deletedTask(id) {
			this.tasks.splice(id, 1)
		},
		toggleTaskState(id) {
			this.tasks[id].pending = !this.tasks[id].pending 
		}
	},
	created() {
		const json  = localStorage.getItem('tasks')
		const array = JSON.parse(json)
		this.tasks = Array.isArray(array) ? array : []
	}
}
</script>

<style>
body {
	font-family: 'Lato', sans-serif;
	background: linear-gradient(to right, rgb(22, 34, 42), rgb(58, 96, 115));
	color: #FFF;
}

#app {
	display: flex;
	flex: 1;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

#app h1 {
	margin-bottom: 5px;
	font-weight: 300;
	font-size: 3rem;
}
</style>
