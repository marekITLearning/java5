// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import SuperAgent from 'superagent'
import Prefix from 'superagent-prefix'
import App from './App'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'

const baseUrl = Prefix('http://localhost:8081/restapi/api')
const agent = SuperAgent.agent().use(baseUrl)

Vue.config.productionTip = false
Vue.prototype.$api = agent

Vue.use(Vuetify, {
  iconfont: 'fa4'
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  components: { App },
  template: '<App/>'
})
