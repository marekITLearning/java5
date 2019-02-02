const Home = () => ({
  component: import(/* webpackChunkName: "home" */ '@/views/Home.vue')
})

const Customers = () => ({
  component: import(/* webpackChunkName: "customers" */ '@/views/Customers.vue')
})

export default [{
  path: '/',
  name: 'Home',
  component: Home,
  meta: {
    title: 'Home',
    icon: 'fa-dashboard',
    requiresAuth: false
  }
}, {
  path: '/customers',
  name: 'Customers',
  component: Customers,
  meta: {
    title: 'Customers',
    icon: 'fa-search',
    requiresAuth: false
  }
}, {
  path: '*',
  name: 'Error404',
  redirect: {
    name: 'Home'
  }
}]
