const PageHome = () => ({
  component: import('@/views/PageHome')
})

const PageHeroes = () => ({
  component: import('@/views/PageHeroes')
})

const PagePlanets = () => ({
  component: import('@/views/PagePlanets')
})

export default [{
  path: '/',
  component: PageHome
}, {
  path: '/heroes',
  component: PageHeroes
}, {
  path: '/planets',
  component: PagePlanets
}]
