import axios from "axios";
import router from "@/router/router";
import VueRouter from "vue-router";
import Vue from "vue";
import App from "@/App";
import VueResource from 'vue-resource'
/*import products_list from "@/components/products_list";*/
axios.defaults.headers.get['header-name'] = 'value'
axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
Vue.use(VueRouter)
Vue.use(VueResource)
/*Vue.component('products_list',products_list)*/
new Vue({
  render: h=>h(App),
  el:'#app',
  router,
})
