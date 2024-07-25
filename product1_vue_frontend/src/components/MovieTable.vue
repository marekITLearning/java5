<template>
      <q-table
        title="Movies"
        dense
        :rows="rows"
        :columns="columns"
        row-key="name"
        :rows-per-page-label="rowsLabel"
      />
</template>

<script setup>
import {getMovies} from '@/services/backend'
import {ref} from 'vue'

defineProps({
  rowsLabel: {
    type: String,
    default: "Not defined"
  }
})

const columns = [
  { name: 'Title', align: 'left', label: 'Title', field: 'primarytitle', sortable: true, style: 'min-width: 500px; max-width: 500px; overflow: hidden;' },
  { name: 'startyear', align: 'left', label: 'Start Year', field: 'startyear', sortable: true }
]

const rows = ref([])

getMovies().then(d => rows.value = d.data)

</script>
