import Vue from "vue"
import Router from "vue-router"
import Index from "./views/index.vue"
import Login from "./views/login.vue"
import Register from "./views/register.vue"
import Detail from "./views/detail.vue"
import Account from "./views/account.vue"
import Security from "./views/security.vue"
import Contribution from "./views/contribution.vue"

Vue.use(Router);

export default new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [{
    path: "*",
    redirect: "/index",
  }, {
    path: "/index",
    component: Index
  }, {
    path: "/login",
    component: Login
  }, {
    path: "/register",
    component: Register
  }, {
    path: "/detail",
    component: Detail
  }, {
    path: "/account",
    component: Account
  }, {
    path: "/security",
    component: Security
  }, {
    path: "/contribution",
    component: Contribution
  }]
})
