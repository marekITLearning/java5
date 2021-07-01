<template>
  <div>
    <app-api-call
      :call-result="callResult"
      class="mb-3"
    />

    <v-data-table
      :headers="headers"
      :items="movies"
      :items-per-page="10"
      class="elevation-1"
      dense
    />
  </div>
</template>

<script>
export default {
  data () {
    return {
      callResult: { finished: false, authorized: false, error: null, info: null },
      headers: [
        { text: 'Primary title', value: 'primarytitle' },
        { text: 'Issue year', value: 'startyear' }
      ],
      movies: []
    }
  },
  created () {
    this.callResult.info = 'Loading data...'
    setTimeout(() => {
      this.init()
    }, 2000)
  },
  methods: {
    init () {
      this.callResult.info = 'Loading data...'
      this.callResult.finished = false
      this.callResult.error = null
      const params = {}
      params.page = 3
      params.pageSize = 10
      params.order = ['primarytitl']
      params.asc = false
      this.$xapi.post('movie', params)
        .then(r => {
          this.movies = r.data
        })
        .catch(e => {
          this.callResult.error = e.response.localizedMessage
        })
        .finally(() => {
          this.callResult.info = null
          this.callResult.finished = true
        })
    }
  }

}
</script>
