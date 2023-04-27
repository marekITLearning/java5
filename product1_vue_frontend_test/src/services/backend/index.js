import xapi from '@/services/axios'

export async function getMovies(payload) {
  return xapi.post('movie', JSON.parse(payload))
}

export async function deleteMovie(payload) {
  return xapi.delete('movie/delete/' + payload)
}
