<template>
  <div>
    <h4>Account Frame Wrapper</h4>
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
        { text: 'Class 1', value: 'class1' },
        { text: 'Class 1', value: 'className1' },
        { text: 'Class 1', value: 'class2' },
        { text: 'Class 1', value: 'className2' },
        { text: 'Class 1', value: 'class3' },
        { text: 'Class 1', value: 'className3' },
        { text: 'Class 1', value: 'type1' },
        { text: 'Class 1', value: 'type2' }
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
