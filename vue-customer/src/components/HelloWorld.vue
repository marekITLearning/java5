<template>
    <v-data-table
    :headers="[
          { text: 'First Name', value: 'fistName' },
          { text: 'Last Name', value: 'lastName' },
          { text: 'Status', value: 'status' },
        ]"
    :items="polozky"
    class="elevation-3 ma-3"
  >
    <template v-slot:items="props">
      <td class="text-xs-left">{{ props.item.firstName }}</td>
      <td class="text-xs-left">{{ props.item.lastName }}</td>
      <td class="text-xs-left">{{ props.item.status }}</td>
    </template>
  </v-data-table>
</template>

<script>
  export default {
    props: {
      polozky: []
    }
  }
</script>

<style>

</style>
