<template>
  <q-page padding>
    <q-table
      title="Star Wars Planets"
      :columns="[
        {name: 'name', label: 'Name', align: 'left', field: 'name', sortable: true},
        {name: 'climate', label: 'Climate', align: 'left', field: 'climate', sortable: true},
        {name: 'terrain', label: 'Terrain', align: 'left', field: 'terrain', sortable: true}
      ]"
      :data="planets"
      row-key="name"
      :loading="loading"
    ></q-table>
  </q-page>
</template>

<script>
import { QPage, QTable } from 'quasar'
import { mapActions, mapGetters } from 'vuex'

export default {
  name: 'PagePlanets',

  components: {
    QPage,
    QTable
  },

  data () {
    return {
      loading: false
    }
  },

  computed: mapGetters([
    'planets'
  ]),

  methods: mapActions([
    'loadPlanets'
  ]),

  async created () {
    this.loading = true
    await this.loadPlanets()
    this.loading = false
  }
}
</script>
