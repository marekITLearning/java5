import xapi from '@/services/axios'
import type { AxiosResponse } from 'axios'

export async function setMovies(payload: object): Promise<AxiosResponse> {
  return xapi.post(movies, tags)
}
