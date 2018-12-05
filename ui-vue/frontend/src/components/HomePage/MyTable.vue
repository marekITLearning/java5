<template>
  <v-data-table
    :headers="headers"
    :items="customers"
    class="elevation-1"
  >
    <template slot="items" slot-scope="props">
      <td class="text-xs-right">{{ props.item.firstName }}</td>
      <td class="text-xs-right">{{ props.item.lastName }}</td>
      <td class="text-xs-right">{{ props.item.status }}</td>
    </template>
  </v-data-table>
</template>

<script>
export default {
  name: 'MyTable',

  props: {
    customers: {
      type: Array,
      required: true
    }
  },

  data () {
    return {
      headers: [
        {
          text: 'First name',
          align: 'left',
          sortable: true,
          value: 'firstName'
        },
        {
          text: 'Last name',
          align: 'left',
          sortable: true,
          value: 'lastName'
        },
        {
          text: 'Status',
          align: 'left',
          sortable: true,
          value: 'status'
        }
      ]
    }
  }
}
</script>
