<template>
  <div class="counter">
    <span>{{ counter }}</span>
    <button @click="add">+</button>
    <button @clock="remove">-</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      counter: 0
    }
  },
  methods: {
    add() {
      this.counter++
    },
    remove() {
      this.counter--
    }
  }
}
</script>

<style scoped>
span {
  border-bottom: 1px solid #ccc;
  height: 30px;
  padding: 5px 25px;
}

button[data-v-469f0013] {
  height: 30px;
  width: 30px;
  border-radius: 15px;
  background-color: coral;
  margin-left: 10px;
  outline: none;
}
</style>
