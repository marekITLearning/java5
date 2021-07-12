import Vue from 'vue'

import '@/plugins'
import '@/components/app'
import '@/components/basic'

import App from '@/App.vue'

import i18n from '@/plugins/i18n'
import router from '@/plugins/router'
import store from '@/plugins/store'
import vuetify from '@/plugins/vuetify'

import '@mdi/font/css/materialdesignicons.css'

import { sync } from 'vuex-router-sync'

import Meta from 'vue-meta'
import VueSessionStorage from 'vue-sessionstorage'
import VueCookies from 'vue-cookies'

sync(store, router)

Vue.use(Meta)
Vue.use(VueSessionStorage)
Vue.use(VueCookies)

Vue.config.productionTip = false

new Vue({
  i18n,
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('main')
