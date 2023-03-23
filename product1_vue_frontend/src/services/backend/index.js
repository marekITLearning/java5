import xapi from '@/services/axios'

export async function getMovies() {
  return xapi.post('movie', {})
}
