<template>
  <q-page padding>
    <q-table
      title="Star Wars Heroes"
      :columns="[
        {name: 'name', label: 'Name', align: 'left', field: 'name', sortable: true},
        {name: 'gender', label: 'Gender', align: 'left', field: 'gender', sortable: true},
        {name: 'birth_year', label: 'Birth year', align: 'left', field: 'birth_year', sortable: true}
      ]"
      :data="heroes"
      row-key="name"
      :loading="loading"
    ></q-table>
  </q-page>
</template>

<script>
import { QPage, QTable } from 'quasar'
import { mapActions, mapGetters } from 'vuex'

export default {
  name: 'PageHeroes',

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
    'heroes'
  ]),

  methods: mapActions([
    'loadHeroes'
  ]),

  async created () {
    this.loading = true
    await this.loadHeroes()
    this.loading = false  
  }
}
</script>
