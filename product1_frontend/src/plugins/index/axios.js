import Vue from 'vue'
import { config } from '@/plugins/index/config'
import axios from 'axios'
import i18n from '@/plugins/i18n'

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

xapi.interceptors.response.use(function (response) {
  return response
}, function (err) {
  if (err.response) {
    err.response.code = err.response.statusText
    if (err.response.data && err.response.data.code) {
      err.response.code = err.response.data.code
    }
    err.response.localizedMessage = i18n.t(`$l.errorcode.${err.response.code}`)
    return Promise.reject(err)
  } else {
    err.response = {}
    err.response.code = 'default'
    err.response.status = 404
    err.response.message = i18n.t(`$l.errorcode.${err.response.code}`) + ' Root cause: ' + err.message
    err.response.localizedMessage = i18n.t(`$l.errorcode.${err.response.code}`) + ' Root cause: ' + err.message
    return Promise.reject(err)
  }
})

export default xapi

Vue.prototype.$xapi = xapi
