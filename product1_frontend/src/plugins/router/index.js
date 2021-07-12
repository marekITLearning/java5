import Vue from 'vue'
import Router from 'vue-router'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import(/* webpackChunkName: "AccountFrame" */ '@/views/AccountFrame.vue'),
    meta: {
      label: 'Account Frame',
      icon: 'mdi-file-table-box-outline',
      isMainMenuItem: false
    }
  },
  {
    path: '/accounframe',
    name: 'AccountFrame',
    component: () => import(/* webpackChunkName: "AccountFrame" */ '@/views/AccountFrame.vue'),
    meta: {
      label: 'Account Frame',
      icon: 'mdi-file-table-box-outline',
      isMainMenuItem: true
    }
  },
  {
    path: '/imdbmovielist',
    name: 'ImdbMovieList',
    component: () => import(/* webpackChunkName: "ImdbMovieList" */ '@/views/ImdbMovieList.vue'),
    meta: {
      label: 'IMDB Movie List',
      icon: 'mdi-view-list-outline',
      isMainMenuItem: true
    }
  }
]

Vue.use(Router)

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [...routes],
  scrollBehavior (to, from, savedPosition) {
    if (savedPosition) {
      return savedPosition
    }
    if (to.hash) {
      return { selector: to.hash }
    }
    return { x: 0, y: 0 }
  }
})

export default router
