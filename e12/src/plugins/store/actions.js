export default {
  async loadHeroes ({ commit }) {
    let response = await fetch('https://swapi.co/api/people')
    let { results } = await response.json()
    commit('updateHeroes', results)
  },

  async loadPlanets ({ commit }) {
    let response = await fetch('https://swapi.co/api/planets')
    let { results } = await response.json()
    commit('updatePlanets', results)
  }
}
