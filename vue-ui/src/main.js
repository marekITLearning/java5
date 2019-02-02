import Vue from 'vue'
import App from '@/App'
import router from '@/plugins/router'

import '@/plugins/vuetify'
import '@/plugins/eventbus'

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('main')
