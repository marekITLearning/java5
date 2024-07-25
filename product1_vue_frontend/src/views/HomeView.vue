<template>
      <q-input color="lime-11" bg-color="green" filled v-model="text" label="Label">
        <template v-slot:prepend>
          <q-icon name="event" />
        </template>
      </q-input>

      <div class="row q-col-gutter-md q-mt-xs">
    <div class="col-lg-6 col-md-9 col-xs-12">
      <MovieTable rowsLabel="Rows label"/>
    </div>
    <div class="col-lg-6 col-md-9 col-xs-12">
      <MovieTable rowsLabel="Rows label"/>
    </div>
  </div>

</template>

<script setup>
import {ref} from 'vue'
import MovieTable from '@/components/MovieTable.vue'

const text = ref()

</script>
