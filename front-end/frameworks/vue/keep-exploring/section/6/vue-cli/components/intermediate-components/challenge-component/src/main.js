import Vue from "vue";
import App from "./main/app/App.vue";
import "./plugins/vuetify";

Vue.config.productionTip = false;

new Vue({
  render: (h) => h(App),
}).$mount("#app");
