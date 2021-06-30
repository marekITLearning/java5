<template>
  <div>
    <v-data-table
      :headers="headers"
      :items="items"
      :loading="!callResult.finished"
      :mobile-breakpoint="0"
      :search="search"
      :footer-props="{
        itemsPerPageOptions:[10, 20]
      }"
      dense
      @click:row="exchangeDetail"
    >
      <template #top>
        <v-container>
          <v-row>
            <v-col
              cols="10"
              sm="10"
            >
              <v-text-field
                v-model="search"
                append-icon="mdi-magnify"
                :label="$i18n.t('$l.app.search')"
                single-line
                hide-details
                class="ma-0 pa-0"
              />
            </v-col>
            <v-col
              cols="2"
              sm="2"
            >
              <v-btn
                color="primary"
                dark
                class="mb-2"
                :loading="exportLoadingBtn"
                @click="doDownloadExport()"
              >
                CSV Export
              </v-btn>
            </v-col>
          </v-row>
        </v-container>
      </template>
      <template
        v-for="header in headers"
      >
        <span
          :slot="`header.${header.value}`"
          :key="header.value"
        >{{ $i18n.t(header.text) }}</span>
      </template>
      <template
        #[`item.exName`]="{ item }"
      >
        <div class="d-flex">
          <v-img
            :src="getLogoById(item)"
            height="20"
            max-width="40"
            contain
          />
          {{ item.exName }}
        </div>
      </template>
      <template
        #[`item.exchangeRating.data.risk`]="{ item }"
      >
        <div
          v-if="item.exchangeRating.data.risk != null"
          class="d-flex"
        >
          <v-chip
            dark
            class=""
            small
            :color="getRiskColor(item.exchangeRating.data.risk)"
          >
            {{ getRiskName(item.exchangeRating.data.risk) }}
          </v-chip>
        </div>
      </template>
      <template
        #[`item.exchangeRating.data.rating`]="{ item }"
      >
        <div
          v-if="item.exchangeRating.data.rating != null"
          class="d-flex"
        >
          {{ item.exchangeRating.data.rating }}
        </div>
      </template>
      <template
        #[`item.exchange.data.score`]="{ item }"
      >
        <v-chip
          v-if="item.exchange.data.score != null"
          :color="getColor(item.exchange.data.score)"
          dark
          class=""
          small
        >
          {{ item.exchange.data.score }}
        </v-chip>
        <v-chip
          v-if="item.exchange.data.score == null"
          color=""
          light
          class=""
          small
        >
          --
        </v-chip>
      </template>
    </v-data-table>
  </div>
</template>

<script>
export default {
  name: 'MovieWrapper',
  data () {
    return {
      callResult: { finished: true, authorized: false, error: null, info: null },
      headers: [
        { text: '$l.exchange.risk', value: 'exchangeRating.data.risk' },
        { text: '$l.exchange.rating', value: 'exchangeRating.data.rating' },
        { text: '$l.exchange.name', value: 'exchange.exName' },
        { text: '$l.exchange.score', value: 'exchange.data.score' },
        { text: '$l.exchange.dataVersion', value: 'exchange.dataVersion' }
      ],
      items: [],
      ratings: [],
      search: '',
      exportLoadingBtn: false
    }
  },
  created () {
    this.loadExchanges()
  },
  methods: {
    exchangeDetail (item) {
      this.$refs.exchangeDialog.openDialog(item)
    },
    test () {
      this.$xapi.get('exchange/init')
        .then(r => {
        }).catch(e => {
        })
        .finally(() => {

        })
    },
    loadExchanges () {
      this.callResult.finished = false
      this.callResult.error = null
      this.$xapi.get('exchange/list')
        .then(r => {
          this.items = r.data
          Array.from(this.items, item => {
            item.exchange.data = JSON.parse(item.exchange.data)
            item.exchangeRating.data = JSON.parse(item.exchangeRating.data)
            item.exchange.dataVersion = new Date(item.exchange.dataVersion).toISOString().substring(0, 10)
            item.exchange.lastModified = new Date(item.exchange.lastModified).toISOString()
            item.exchangeRating.lastModified = new Date(item.exchangeRating.lastModified).toISOString()
          })
        }).catch(e => {
          this.callResult.error = this.$i18n.t('Error on loading data')
          this.callResult.finished = true
        })
        .finally(() => {
          this.callResult.finished = true
        })
    },
    getLogoById (item) {
      return 'https://s2.coinmarketcap.com/static/img/exchanges/64x64/' + item.exId + '.png'
    },
    getColor (rating) {
      if (rating > 8) return 'green'
      else if (rating <= 8 && rating > 6) return 'orange'
      else return 'red'
    },
    getRiskColor (risk) {
      if (risk === 2) return 'green'
      else if (risk === 1) return 'orange'
      else return 'red'
    },
    getRiskName (val) {
      if (val === 2) {
        return 'LOW'
      } else if (val === 1) {
        return 'MEDIUM'
      } else {
        return 'HIGH'
      }
    },
    doDownloadExport () {
      this.exportLoadingBtn = true
      this.callResult.error = null
      this.$xapi.get('exchange/export')
        .then(r => {
          var csvFile
          var downloadLink
          var filename = 'exchangeRatingExport_' + new Date().toISOString() + '.csv'

          csvFile = new Blob([r.data], { type: 'text/csv' })
          downloadLink = document.createElement('a')
          downloadLink.download = filename
          downloadLink.href = window.URL.createObjectURL(csvFile)
          downloadLink.style.display = 'none'
          document.body.appendChild(downloadLink)
          downloadLink.click()
        }).catch(e => {
          this.exportLoadingBtn = false
          this.callResult.error = 'Error downloading export'
        })
        .finally(() => {
          this.exportLoadingBtn = false
        })
    }

  }
}
</script>
