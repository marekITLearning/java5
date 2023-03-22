import axios from 'axios'

const xapi = axios.create({
  baseURL: 'http://localhost:8080/webapp/api/',
  headers: {
    Accept: 'application/json, text/plain, */*'
  }
})

export default xapi
