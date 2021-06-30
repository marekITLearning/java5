import Vue from 'vue'
import { config } from '@/plugins/index/config'
import axios from 'axios'

const xapi = axios.create({
  baseURL: config.api_url,
  headers: {
    Accept: 'application/json, text/plain, */*'
  }
})

// xapi.interceptors.request.use(config => {
//   config.headers.Authorization = `Bearer ${sessionStorage.getItem('token')}`
//   return config
// }, error => {
//   return Promise.reject(error)
// })

// xapi.interceptors.response.use(function (response) {
//   return response
// }, function (error) {
//   if (error.response.status === 401) {
//     store.dispatch('logoutUser')
//     return Promise.reject(error)
//   } else {
//     return Promise.reject(error)
//   }
// })

export default xapi

Vue.prototype.$xapi = xapi
