import Vue from 'vue'
import Router from 'vue-router'

const routes = [
  {
    path: '/movies',
    name: 'Movies',
    component: () => import(/* webpackChunkName: "Movies" */ '@/views/Movies.vue'),
    meta: {
      label: 'Movie List',
      icon: 'mdi-view-dashboard-variant',
      isMainMenuItem: true
    }
  },
  {
    path: '/finder',
    name: 'Finder',
    component: () => import(/* webpackChunkName: "Finder" */ '@/views/Finder.vue'),
    meta: {
      label: 'Movie Finder',
      icon: 'mdi-archive-arrow-down-outline',
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
