<template>
  <div>
    <app-api-call
      :call-result="callResult"
      class="mb-3"
    />

    <v-data-table
      :headers="headers"
      :items="movies"
      :items-per-page="8"
      :footer-props="{
        'items-per-page-options': [8, 16, 40]
      }"
      :options.sync="options"
      :server-items-length="10000"
      class="elevation-1"
      dense
    />
  </div>
</template>

<script>
export default {
  name: 'ImdbMovieListWrapper',
  data () {
    return {
      callResult: { finished: false, authorized: false, error: null, info: null },
      headers: [
        { text: 'Primary title', value: 'primarytitle' },
        { text: 'Issue year', value: 'startyear' }
      ],
      movies: [],
      options: {}
    }
  },
  watch: {
    options: {
      handler () {
        this.init()
      },
      deep: true
    }
  },
  methods: {
    init () {
      this.callResult.info = 'Loading data...'
      this.callResult.finished = false
      this.callResult.error = null
      const params = {}
      params.page = this.options.page
      params.pageSize = this.options.itemsPerPage
      params.order = ['primarytitle']
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
