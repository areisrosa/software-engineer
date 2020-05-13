<template>
  <div class="counters">
    <app-counter v-for="count in 5" :key="count" />
  </div>
</template>

<script>
import Counter from './Counter.vue'

export default {
  components: { 'app-counter': Counter}
}
</script>

<style>

</style>
