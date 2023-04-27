<template>
  <div class="q-pa-none">

    <q-input outlined v-model="filter" dense label="Filter by movie substring" @keydown.enter="getData()" />

    <div class="row justify-end q-gutter-sm q-py-sm">
      <q-btn 
        color="grey-4" 
        text-color="primary" 
        glossy 
        unelevated icon="camera_enhance" 
        label="Submit"
        @click="getData()"
      />

      <q-btn 
        color="grey-4" 
        text-color="negative" 
        glossy 
        unelevated icon="camera_enhance" 
        label="Delete"
        @click="deleteSelected()"
      />
    </div>

    <q-table 
      flat 
      bordered 
      title="Treats" 
      dense 
      :rows="rows" 
      :columns="columns" 
      row-key="tconst"
      selection="single"
      :auto-width="false"
      v-model:selected="selected"
      :rows-per-page-options="[15]"
      />
  </div>
</template>

<script setup>
import { getMovies, deleteMovie } from '@/services/backend'
import { ref } from 'vue'

const columns = [
  { name: 'primarytitle', align: 'left', label: 'Názov', field: 'primarytitle', sortable: true, style: "max-width: 200px; min-width: 200px; overflow:hidden; text-overflow: ellipsis;" },
  { name: 'startyear', label: 'Rok vydania', field: 'startyear', sortable: true, align: 'left' },
  { name: 'runtimeMinutes', label: 'Trvanie (min)', field: 'runtimeMinutes', sortable: true, align: 'left' }
]

const rows = ref([])

const filter = ref('')

const selected = ref([])

const getData = function () {
  return getMovies(`{"title" : "${filter.value}"}`)
  .then(r => rows.value = r.data)
  .catch(() => console.log('error on getting data'))}

const deleteSelected = function () {
  if (selected.value.length === 0) return
  var s = selected.value[0]
  s = JSON.parse(JSON.stringify(s))
  deleteMovie(s.tconst).then(() => getData())
}

getData()

</script>
