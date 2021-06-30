let config

if (process.env.NODE_ENV === 'production') {
  config = {
    api_url: '/bcapi/rest/'
  }
}

if (process.env.NODE_ENV === 'development') {
  config = {
    api_url: 'http://127.0.0.1:8082/bcapi/rest/'
  }
}

export {
  config
}
