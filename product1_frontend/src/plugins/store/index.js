import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
  },
  plugins: [
    createPersistedState({
      key: 'dsbc',
      paths: ['userName', 'userData', 'config']
    })
  ],
  state: {
    userName: '',
    userData: [],
    config: {}
  },
  mutations: {
    SET_USERNAME (state, user) {
      state.userName = user
    },
    SET_CONFIG_VALUE (state, value) {
      state.config = { ...state.config, ...value }
    },
    RESET_PERSISTED_STATE (state) {
      state.userName = ''
      state.userData = []
      state.config = {}
    },
    SAVE_USER_DATA (state, value) {
      state.userData = value
    }
  },
  actions: {

  }
})

export default store
