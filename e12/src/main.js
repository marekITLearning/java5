import Vue from 'vue'
import App from '@/App.vue'

import '@/styles/quasar.styl'
import 'quasar-extras/animate'
import 'quasar-extras/material-icons'
import { Quasar } from 'quasar'

import router from '@/plugins/router'
import store from '@/plugins/store'

 
Vue.use(Quasar, {
  config: {},
  directives: {},
  plugins: {}
})

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
