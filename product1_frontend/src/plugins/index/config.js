let config

if (process.env.NODE_ENV === 'production') {
  config = {
    api_url: '/bcapi/rest/'
  }
}

if (process.env.NODE_ENV === 'development') {
  config = {
    api_url: 'http://localhost:8080/restapi/api'
  }
}

export {
  config
}
