<template>
	<div class="task-grid">
		<template v-if="tasks.length">
			<task v-for="(task, id) in tasks" :key="task.name"
	@taskDeleted="$emit('taskDeleted', id)"
	@taskStateChanged="$emit('taskStateChanged', id)"
	:task="task"></task>
		</template>
		<p v-else class="no-task">Your life is up to date :)</p>
	</div>
</template>

<script>
import Task from './Task.vue'

export default {
	components: { 'task': Task },
	props: {
		tasks: { type: Array, required: true }
	}
}
</script>

<style>

.task-grid {
	display: flex;
	justify-content: center;
	flex-wrap: wrap;
}

.task-grid .task {
	margin: 10px
}

.no-task {
	color: #aaa;
	font-size: 1.7rem;
}
</style>
