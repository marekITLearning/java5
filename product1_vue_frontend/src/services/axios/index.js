import axios from 'axios'

const xapi = axios.create({
  baseURL: 'http://localhost:8081/restapp/api/',
  headers: {
    Accept: 'application/json, text/plain, */*'
  }
})

export default xapi
