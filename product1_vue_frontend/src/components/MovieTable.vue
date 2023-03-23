<template>
      <q-spinner
      v-if="rows.length === 0"
        color="primary"
        size="3em"
      />
  <div class="q-pa-md"
  v-if="rows.length !== 0"
  >
    <q-table
      title="Treats"
      dense
      :rows="rows"
      :columns="columns"
      row-key="name"
    />
  </div>
</template>

<script setup>
import {getMovies} from '@/services/backend'
import {ref} from 'vue'

const columns = [
  { name: 'Title', align: 'left', label: 'Title', field: 'primarytitle', sortable: true, style: 'min-width: 500px; max-width: 500px; overflow: hidden;' },
  { name: 'startyear', align: 'left', label: 'Start Year', field: 'startyear', sortable: true }
]

const rows = ref([])

getMovies().then(d => rows.value = d.data)

</script>
