<template>
  <div>
    <v-row>
      <v-col
        cols="12"
      >
        <v-data-table
          :headers="headers"
          :items="aktiva"
          :items-per-page="50"
          class="elevation-1"
          dense
        />
      </v-col>
      <v-col
        cols="12"
      >
        <v-card
          elevation="1"
        >
          <v-list>
            <v-list-item
              v-for="ucet in aktiva"
              :key="ucet.class3"
            >
              {{ ucet.class3 + ' ' + ucet.className3 }}
            </v-list-item>
          </v-list>
        </v-card>
      </v-col>
    </v-row>
  </div>
</template>

<script>

export default {
  name: 'AccountFrameWrapper',
  data () {
    return {
      osnova: [],
      headers: [
        { text: 'A', value: 'class1', width: '10%' },
        { text: 'B', value: 'className1', width: '10%' },
        { text: 'C', value: 'class2', width: '10%' },
        { text: 'D', value: 'className2', width: '20%' },
        { text: 'E', value: 'class3', width: '10%' },
        { text: 'F', value: 'className3', width: '20%' },
        { text: 'G', value: 'type1', width: '10%' },
        { text: 'H', value: 'type2', width: '10%' }
      ],
      aktiva: [],
      pasiva: [],
      naklady: [],
      vynosy: []
    }
  },
  mounted () {
    const osnova = require('@/assets/osnova.json')
    this.osnova = osnova
    this.aktiva = this.osnova.filter(u => u.type1 === 'A')
  }
}
</script>
