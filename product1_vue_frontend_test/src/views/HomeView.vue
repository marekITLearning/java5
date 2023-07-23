<template>
  <h6>This is an home page</h6>

  <div class="q-pa-md bg-grey-9 text-white">
    <q-list dark bordered separator>
      <div v-for="item in arrayData">
      <q-item clickable v-ripple>
        <q-item-section>{{ item.primarytitle }}</q-item-section>
      </q-item>
    </div>
    </q-list>
  </div>

</template>

<script setup>
import {ref} from 'vue'
import {fetchUrl} from '@/functions'

const arrayData = ref([])

fetchUrl('http://localhost:8081/restapp/api/movie').then(r => r.json().then(data => arrayData.value = data));

</script>