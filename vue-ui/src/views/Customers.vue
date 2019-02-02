<template>
  <v-layout row>
    <v-flex>
      <v-subheader class="title pl-0 secondary--text">Overview</v-subheader>
      <v-layout>
        <v-flex>
          <v-data-table :headers="headers" :items="customers" class="elevation-1">
            <template slot="items" slot-scope="props">
              <td class="text-xs-right">{{ props.item.name }}</td>
              <td class="text-xs-right">{{ props.item.surname }}</td>
              <td class="text-xs-right">{{ props.item.status }}</td>
            </template>
          </v-data-table>
        </v-flex>
      </v-layout>
    </v-flex>
  </v-layout>
</template>

<script>
export default {
  data () {
    return {
      headers: [
        { text: 'Custome Name', value: 'name' },
        { text: 'Customer Surname', value: 'surname' },
        { text: 'Status', value: 'status' }
      ],
      customers: []
    }
  }
}
</script>
