import Vue from "vue";

export default new Vue({
  methods: {
    setUserSelect(user) {
      this.$emit("userSelect", user);
    },
    onUserSelect(callback) {
      this.$on("userSelect", callback);
    },
  },
});
