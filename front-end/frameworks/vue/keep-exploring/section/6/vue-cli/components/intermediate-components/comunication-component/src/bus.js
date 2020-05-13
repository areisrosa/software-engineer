import Vue from "vue";

export default new Vue({
  methods: {
    updateAge(age) {
      this.$emit("ageChange", age);
    },
    whenAgeChange(callback) {
      this.$on("ageChange", callback);
    },
  },
});
